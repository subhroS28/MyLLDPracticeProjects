package com.subhro;

import com.subhro.models.ActionType;
import com.subhro.models.Post;
import com.subhro.models.User;
import com.subhro.services.PostService;
import com.subhro.services.UserService;

public class NewsFeed {
    public static void main(String[] args) throws Exception {

        PostService postService = PostService.getPostServiceInstance();
        UserService userService = UserService.getUserService();

        userService.signUp("tom");
        userService.signUp("albus");

        User user = userService.login("tom");

        postService.createNewPost("tom", "I am going to be the darkest dark wizard of all time");
        Post post = postService.createNewPost("tom", "I am lord Voldemort btw 3:)");
        postService.createNewPost("tom", "I am the greatest");

        postService.createNewPost("albus", "I am the albus");

        userService.followUser("tom", "albus");

        postService.upvoteOrDownvote(post.getPostId(), ActionType.UPVOTE);
        postService.upvoteOrDownvote(post.getPostId(), ActionType.UPVOTE);
        postService.upvoteOrDownvote(post.getPostId(), ActionType.UPVOTE);
        postService.upvoteOrDownvote(post.getPostId(), ActionType.UPVOTE);
        postService.upvoteOrDownvote(post.getPostId(), ActionType.UPVOTE);

        postService.upvoteOrDownvote(post.getPostId(), ActionType.DOWNVOTE);
        postService.upvoteOrDownvote(post.getPostId(), ActionType.DOWNVOTE);

        postService.addNewComment(post.getPostId(), "this is the reply text");
        postService.addNewComment(post.getPostId(), "this is a dummy comment");

        postService.showNewsFeed(user);


        /*StringBuilder command = new StringBuilder();

        command.append("signup~lucious\n");
        command.append("signup~albus\n");
        command.append("signup~tom\n");
        command.append("login~tom\n");
        command.append("post~I am going to be the darkest dark wizard of all time\n");
        command.append("post~I am lord Voldemort btw 3:)\n");
        command.append("login~tom\n");
//        command.append("upvote~1L \n");
//        command.append("reply~1L~I am with you dark lord! \n");
//        command.append("follow~albus \n");

        System.out.println(command);

        PerformeOperations performeOperations = PerformeOperations.getPerformeOperationsInstance();
        performeOperations.performOperations(command.toString());*/
    }
}
