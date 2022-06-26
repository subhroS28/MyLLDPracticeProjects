package com.subhro.models;

import com.subhro.requests.PostCreateRequest;

import java.util.ArrayList;
import java.util.Date;

public class Post extends PostCreateRequest {

    private Long postId;
    private Date date;
    private Long upVotes = 0l;
    private Long downVotes = 0l;
    private Long score = 0l;//upVotes - downVotes
    //As user can add multiple comment in one post
    private ArrayList<String> comments = new ArrayList<>();

    public Post(PostCreateRequest postCreateRequest){
        setCommonProperties(postCreateRequest);
    }

    private void setCommonProperties(PostCreateRequest postCreateRequest) {
        this.setMessage(postCreateRequest.getMessage());
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(Long upVotes) {
        this.upVotes = upVotes;
    }

    public Long getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(Long downVotes) {
        this.downVotes = downVotes;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public void addNewComment(String comment){
        comments.add(comment);
    }
}
