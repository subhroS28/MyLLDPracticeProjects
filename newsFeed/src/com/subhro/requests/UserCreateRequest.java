package com.subhro.requests;

/**
 * This class is used while creating/registering the user.
 * This class is used so that user cannot pass/set/see other fields like userid, postmap etc
 */
public class UserCreateRequest {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserCreateRequest{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
