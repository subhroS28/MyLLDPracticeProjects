package com.subhro.dao;

import com.subhro.exceptions.NoUserExistException;
import com.subhro.models.User;
import com.subhro.requests.UserCreateRequest;
import com.subhro.util.IdGenerator;

import java.util.HashMap;
import java.util.List;

public class UserDao {

    private static UserDao userDaoInstance;

//    private HashMap<Long, User> userPhoneNumberMap;
    private HashMap<String, User> userNameMap;

    private UserDao(){
        userNameMap = new HashMap<>();
    }

    public static UserDao getUserDao(){
        if(userDaoInstance==null){
            userDaoInstance = new UserDao();
        }
        return userDaoInstance;
    }

    public User signUpUser(UserCreateRequest userCreateRequest) throws Exception {
        if(doesUserExists(userCreateRequest.getUserName())){
            System.out.println("User is already registered!!!");
            throw new Exception("User is already registered!!!");
        }

        //Create a new User
        User newUser = new User(userCreateRequest);
        newUser.setUserId(IdGenerator.getId());

        userNameMap.put(newUser.getUserName(), newUser);
        return newUser;
    }

    public User loginUser(String userName) throws Exception {
        if(!doesUserExists(userName)){
            System.out.println("User does not exists");
            throw new NoUserExistException("User does not exists");
        }

        System.out.println("User successfully logged in.");
        return userNameMap.get(userName);
    }

    private boolean doesUserExists(String userName) throws Exception {
        if(userName==null || userName.equals("")){
            System.out.println("User name can not be null/empty.");
            throw new Exception("User name can not be null/empty.");
        }

        return userNameMap.containsKey(userName);
    }

    /**
     * We are using phone number because we already have a map for phoneNumber
     */
    public void followUser(String followerName, String influencerName) throws Exception {
        if(!doesUserExists(followerName) || !doesUserExists(influencerName)){
            System.out.println("User does not exists");
            throw new NoUserExistException("User does not exists");
        }

        User follewerUser = userNameMap.get(followerName);
        User influencerUser = userNameMap.get(influencerName);

        follewerUser.addNewFollowedUser(influencerUser);
    }

    public List<User> getFollowedUser(User user) {
        return user.getFollowedUser();
    }
}
