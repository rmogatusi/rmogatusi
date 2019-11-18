package com.mogatusi.twitter.test.service;

import com.mogatusi.twitter.model.TweetDao;
import com.mogatusi.twitter.model.UserDao;
import com.mogatusi.twitter.service.UserService;
import com.mogatusi.twitter.service.UserServiceImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    private UserService service = new UserServiceImpl();

    @Test
    public void testGetUserDaos() throws Exception {
        List<UserDao> returnedUsers = service.getUserDaos();
        assertEquals(returnedUsers.size(), 3);
        assertEquals(returnedUsers.get(0).getFollowing().size(), 1);
        assertEquals(returnedUsers.get(1).getFollowing().size(), 1);
        assertEquals(returnedUsers.get(2).getFollowing().size(), 2);
    }

    @Test
    public void testGetTweets() throws IOException {
        List<TweetDao> tweets = service.getTweets(returnedUsers());
        assertEquals(tweets.size(), 3);
        assertEquals(tweets.get(0).getTweeter(), "Alan");
        assertEquals(tweets.get(1).getTweeter(), "Ward");
        assertEquals(tweets.get(2).getTweeter(), "Alan");
    }

    @Test
    public void testIsUserFollowingTweeter_allTrue() throws IOException {
        String user = "Martin";
        List<TweetDao> tweets = service.getTweets(returnedUsers());
        assertEquals(service.isUserFollowingTweeter(user, tweets.get(0), returnedUsers()), true);
        assertEquals(service.isUserFollowingTweeter(user, tweets.get(0), returnedUsers()), true);
    }

    @Test
    public void testIsUserFollowingTweeter_withFalse() throws IOException {
        String user = "Alan";
        List<TweetDao> tweets = service.getTweets(returnedUsersFalse());
        assertEquals(service.isUserFollowingTweeter(user, tweets.get(0), returnedUsersFalse()), false);
        assertEquals(service.isUserFollowingTweeter(user, tweets.get(0), returnedUsersFalse()), false);
    }

    private List<UserDao> returnedUsers(){
        List<UserDao> returnedUsers = new ArrayList<>();
        List<String> wardFollows = new ArrayList<>();
        wardFollows.add("Alan");
        wardFollows.add("Martin");
        List<String> martinFollows = new ArrayList<>();
        martinFollows.add("Alan");
        martinFollows.add("Martin");
        UserDao ward = new UserDao("Ward", wardFollows);
        UserDao martin = new UserDao("Martin", martinFollows);
        returnedUsers.add(ward);
        returnedUsers.add(martin);
        return returnedUsers;
    }

    private List<UserDao> returnedUsersFalse(){
        List<UserDao> returnedUsers = new ArrayList<>();
        List<String> wardFollows = new ArrayList<>();
        wardFollows.add("Ward");
        wardFollows.add("Martin");
        List<String> martinFollows = new ArrayList<>();
        martinFollows.add("Martin");
        UserDao ward = new UserDao("Ward", wardFollows);
        UserDao martin = new UserDao("Martin", martinFollows);
        UserDao alan = new UserDao("Alan", martinFollows);
        returnedUsers.add(ward);
        returnedUsers.add(martin);
        returnedUsers.add(alan);
        return returnedUsers;
    }
}