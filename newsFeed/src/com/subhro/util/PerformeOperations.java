package com.subhro.util;

import com.subhro.models.ActionType;
import com.subhro.models.User;
import com.subhro.services.PostService;
import com.subhro.services.UserService;

public class PerformeOperations {

    private static PerformeOperations performeOperationsInstance;

    private PerformeOperations(){

    }

    private PostService postService = PostService.getPostServiceInstance();
    private UserService userService = UserService.getUserService();
    private User user = null;

    public static PerformeOperations getPerformeOperationsInstance(){
        if(performeOperationsInstance==null){
            performeOperationsInstance = new PerformeOperations();
        }
        return performeOperationsInstance;
    }

    public void performOperations(String command) throws Exception {
        String[] commands = command.split("\n");

        for(String singleCommand : commands){
            String[] singleCommandUnit = singleCommand.split("~");

            int singleCommandUnitLen = singleCommandUnit.length;

            //3 when reply --> Example - "reply~005~this is the reply text"
            //2 for remaining cases
            if(singleCommandUnitLen == 3){
                //For Adding new Comment
                postService.addNewComment(Long.getLong(singleCommandUnit[1]), singleCommandUnit[2]);
            }else if(singleCommandUnitLen == 2){
                performeOperation(singleCommandUnit);
            }
        }

        //Reseting user
        user = null;
    }

    private void performeOperation(String[] singleCommandUnit) throws Exception {
        String operationName = singleCommandUnit[0];

        if(operationName.equals("signup")){

            String userName = singleCommandUnit[1];
            user = userService.signUp(userName);
        }else if(operationName.equals("login")){

            String userName = singleCommandUnit[1];
            user = userService.login(userName);

            //Now displaying newFeed
            postService.showNewsFeed(user);
        }else if(operationName.equals("post")){

            String postMessage = singleCommandUnit[1];
            if(user==null){
                throw new Exception("User is not logged in, thus can not post anything.");
            }
            postService.createNewPost(user.getUserName(), postMessage);
        }else if(operationName.equals("follow")){

            String influencerName = singleCommandUnit[1];
            if(user==null){
                throw new Exception("User is not logged in, thus can not follow anyone.");
            }
            userService.followUser(user.getUserName(), influencerName);
        }else if(operationName.equals("upvote")){

            Long postId = Long.getLong(singleCommandUnit[1]);
            postService.upvoteOrDownvote(postId, ActionType.UPVOTE);
        }else if(operationName.equals("downvote")){

            Long postId = Long.getLong(singleCommandUnit[1]);
            postService.upvoteOrDownvote(postId, ActionType.DOWNVOTE);
        }
    }
}
