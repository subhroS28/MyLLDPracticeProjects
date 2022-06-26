package com.subhro.models;

import com.subhro.requests.UserCreateRequest;

import java.util.ArrayList;
import java.util.List;

public class User extends UserCreateRequest {

    private Long userId;
    private List<User> followedUser= new ArrayList<>();

    public User(UserCreateRequest newUserRequest){
        setCommonProperties(newUserRequest);
    }

    private void setCommonProperties(UserCreateRequest newUserRequest) {
        this.setUserName(newUserRequest.getUserName());
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<User> getFollowedUser() {
        return followedUser;
    }

    public void setFollowedUser(List<User> followedUser) {
        this.followedUser = followedUser;
    }

    public void addNewFollowedUser(User influencerUser){
        followedUser.add(influencerUser);
    }
}
