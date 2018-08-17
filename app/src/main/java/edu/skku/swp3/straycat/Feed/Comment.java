package edu.skku.swp3.straycat.Feed;

import java.util.List;

public class Comment {

    String comment;
    String user_id;
    String date_created;
    int profileImgUri;

    public Comment(String comment, String user_id, String date_created, int profileImgUri) {
        this.comment = comment;
        this.user_id = user_id;
        this.date_created = date_created;
        this.profileImgUri = profileImgUri;
    }
    public int getProfileImgUri() {
        return profileImgUri;
    }

    public void setProfileImgUri(int profileImgUri) {
        this.profileImgUri = profileImgUri;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

}
