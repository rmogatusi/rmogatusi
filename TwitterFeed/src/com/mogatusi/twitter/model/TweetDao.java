package com.mogatusi.twitter.model;

public class TweetDao {

    private String tweeter;
    private String tweet;

    public TweetDao(String tweeter, String tweet) {
        this.tweeter = tweeter;
        this.tweet = tweet;
    }

    public String getTweeter() {
        return tweeter;
    }

    public void setTweeter(String tweeter) {
        this.tweeter = tweeter;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}
