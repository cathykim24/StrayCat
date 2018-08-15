package edu.skku.swp3.straycat;

import android.util.Log;

public class PostItem {

    boolean isUserLike;
    int postLikeCount;
    int imgUri;
    int profileImgUri;
    String username;
    String postImgUrl;
    String postText;

    public void setImgUri(int imgUri) {
        this.imgUri = imgUri;
    }

    public int getProfileImgUri() {
        return profileImgUri;
    }

    public void setProfileImgUri(int profileImgUri) {
        this.profileImgUri = profileImgUri;
    }

    public String getProfileUserName() {
        return profileUserName;
    }

    public void setProfileUserName(String profileUserName) {
        this.profileUserName = profileUserName;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    String profileUserName;
    int idx=0;

    public int getidx(){
        return idx;
    }
    public void addidx(){
        this.idx = idx + 1;

    }
    public boolean isUserLike() {
        return isUserLike;
    }

    public void setUserLike(boolean userLike) {
        isUserLike = userLike;
    }

    public int getPostLikeCount() {
        return postLikeCount;
    }

    public void setPostLikeCount(int postLikeCount) {
        this.postLikeCount = postLikeCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPostImgUrl() {
        return postImgUrl;
    }
    public int getImgUri(){ return imgUri;    }

    public void setPostImgUrl(String postImgUrl) {
        this.postImgUrl = postImgUrl;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public PostItem(boolean isUserLike, int postLikeCount, String username, String postImgUrl, String postText) {
        this.isUserLike = isUserLike;
        this.postLikeCount = postLikeCount;
        this.username = username;
        this.postImgUrl = postImgUrl;
        this.postText = postText;
    }

    public PostItem(boolean isUserLike, int postLikeCount, String username, int postImgUrl, String postText, String profileUserName, int profileImgUri) {
        this.isUserLike = isUserLike;
        this.postLikeCount = postLikeCount;
        this.username = username;
        this.imgUri = postImgUrl;
        this.postText = postText;
        this.profileUserName = profileUserName;
        this.profileImgUri = profileImgUri;
    }


}
