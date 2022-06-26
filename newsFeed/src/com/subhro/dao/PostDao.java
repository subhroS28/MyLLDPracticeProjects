package com.subhro.dao;

import com.subhro.models.Post;
import com.subhro.models.ActionType;
import com.subhro.models.User;
import com.subhro.requests.PostCreateRequest;
import com.subhro.util.IdGenerator;

import java.text.SimpleDateFormat;
import java.util.*;

public class PostDao {

    private static PostDao postDaoInstance;

    private HashMap<String, ArrayList<Post>> userPostMap;
    private HashMap<Long, Post> postMap;

    private PostDao(){
        userPostMap = new HashMap<>();
        postMap = new HashMap<>();
    }

    public static PostDao getPostDaoInstance(){
        if(postDaoInstance==null){
            postDaoInstance = new PostDao();
        }
        return postDaoInstance;
    }

    public Post createNewPost(String userName, PostCreateRequest postCreateRequest){
        Post newPost = new Post(postCreateRequest);
        newPost.setPostId(IdGenerator.getId());
        newPost.setDate(new Date());
        postMap.put(newPost.getPostId(), newPost);

        if(!userPostMap.containsKey(userName)){
            userPostMap.put(userName, new ArrayList<>());
        }
        userPostMap.get(userName).add(newPost);
        return newPost;
    }

    public void addNewComment(Long postId, String comment){
        Post post = postMap.get(postId);
        post.addNewComment(comment);
    }

    public void postOperation(Long postId, ActionType operation) throws Exception {
        if(!postMap.containsKey(postId)){
            throw new Exception("Invalid postId");
        }
        Post post = postMap.get(postId);
        if(operation.equals(ActionType.UPVOTE)){
            post.setUpVotes(post.getUpVotes()+1);
            post.setScore(post.getScore()+1);
        }else{
            post.setDownVotes(post.getDownVotes()+1);
            post.setScore(post.getScore()-1);
        }
    }


    /**
     * Sorting condition:-
     *
     * Now We will sort the list based on the condition
     *  News items are sorted based on the following:
     * ● Followed users : posts by followed users appear first.
     * ● Score (= upvotes - downvotes): higher the better.
     * ● Number of comments: higher the better.
     * ● Timestamp: more recent the better.
     */
    public void showNewsFeed(User user){
        //First Fetching all the post for the given user
        List<Post> userFeeds = new ArrayList<>();

        List<User> followedUser = UserDao.getUserDao().getFollowedUser(user);
        //Getting posts of influencer's
        for(User influencer : followedUser){
            userFeeds.addAll(userPostMap.get(influencer.getUserName()));
        }
        //Getting all user's post
//        userFeeds.addAll(user.getPosts());
        userFeeds.addAll(userPostMap.get(user.getUserName()));
        //Now sorting it
        userFeeds.sort(scoreBasedComparator()
                .thenComparing(commentBasedComparator())
                .thenComparing(timeBasedComparator())
                );

        displayFeeds(userFeeds);
    }

    private void displayFeeds(List<Post> userFeeds) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm aaa");
        for(Post post : userFeeds){
            StringBuilder oneFeed = new StringBuilder();
            oneFeed.append("id: "+post.getPostId());
            oneFeed.append("\n");
            oneFeed.append("("+post.getUpVotes()+" upvotes, "+post.getDownVotes()+" downvotes)");
            oneFeed.append("\n");
            oneFeed.append(post.getMessage());
            oneFeed.append("\n");
            oneFeed.append(dateFormat.format(post.getDate()));
            oneFeed.append("\n");

            //Now showing comments
            for (String comment : post.getComments()){
                oneFeed.append("\t");
                oneFeed.append(comment);
                oneFeed.append("\n");
            }
            System.out.println(oneFeed);
        }
    }

    private Comparator<Post> scoreBasedComparator(){
        return Comparator.comparing(Post::getScore);
    }

    private Comparator<Post> commentBasedComparator(){
//        return Comparator.comparing(Post::getComments, Comparator.comparingInt(HashMap::size));
        return Comparator.comparing(Post::getComments, (p1, p2) -> p1.size() - p2.size());
    }

    //As the most frequent post will have more postId
    private Comparator<Post> timeBasedComparator(){
//        return Comparator.comparing(Post::getDate);
        return Comparator.comparing(Post::getPostId, Collections.reverseOrder());
    }

    /*
        1. For Reverse order
        private Comparator<Post> scoreBasedComparator(){
            return Comparator.comparing(Post::getScore, Collections.reverseOrder());
        }

        2. Or for normal we can do this:-
        class SortbyAge implements Comparator<User>
        {
            public int compare(User a, User b)
            {
                return a.getAge()-b.getAge();
            }
        }
     */

}
