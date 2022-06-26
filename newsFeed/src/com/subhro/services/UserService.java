package com.subhro.services;

import com.subhro.dao.UserDao;
import com.subhro.models.User;
import com.subhro.requests.UserCreateRequest;

public class UserService {

    private static UserService userServiceInstance;

    private UserDao userDao = UserDao.getUserDao();

    private UserService(){

    }

    public static UserService getUserService(){
        if(userServiceInstance==null){
            userServiceInstance = new UserService();
        }
        return userServiceInstance;
    }

    public User signUp(String userName) throws Exception {
        UserCreateRequest newCreateRequest = new UserCreateRequest();
        newCreateRequest.setUserName(userName);
        return userDao.signUpUser(newCreateRequest);
    }

    public User login(String userName) throws Exception {
        return userDao.loginUser(userName);
    }

    public void followUser(String followerName, String influencerName) throws Exception {
        userDao.followUser(followerName, influencerName);
    }
}
