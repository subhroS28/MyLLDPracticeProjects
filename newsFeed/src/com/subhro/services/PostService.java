package com.subhro.services;

import com.subhro.dao.PostDao;
import com.subhro.models.ActionType;
import com.subhro.models.Post;
import com.subhro.models.User;
import com.subhro.requests.PostCreateRequest;

public class PostService {

    private static PostService postServiceInstance;

    private PostDao postDao = PostDao.getPostDaoInstance();

    private PostService(){

    }

    public static PostService getPostServiceInstance(){
        if(postServiceInstance==null){
            postServiceInstance = new PostService();
        }
        return postServiceInstance;
    }

    public Post createNewPost(String userName, String postMessage){
        PostCreateRequest postCreateRequest = new PostCreateRequest();
        postCreateRequest.setMessage(postMessage);

        Post newPost = postDao.createNewPost(userName, postCreateRequest);
        return newPost;
    }

    public void addNewComment(Long postId, String comment){
        postDao.addNewComment(postId, comment);
    }

    public void upvoteOrDownvote(Long postId, ActionType operation) throws Exception {
        postDao.postOperation(postId, operation);
    }

    public void showNewsFeed(User user){

        postDao.showNewsFeed(user);
    }

}
