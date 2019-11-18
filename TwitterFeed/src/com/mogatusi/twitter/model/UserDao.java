package com.mogatusi.twitter.model;

import java.util.List;

public class UserDao {

    private String name;
    private List<String> following;

    public UserDao(String name, List<String> following){
        this.name = name;
        this.following = following;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFollowers() {
        return following;
    }

    public void setFollowing(List<String> following) {
        this.following = following;
    }
}
