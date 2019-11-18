package com.mogatusi.twitter.service;

import com.mogatusi.twitter.model.TweetDao;
import com.mogatusi.twitter.model.UserDao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserService {

    List<UserDao> getUserDaos() throws FileNotFoundException, IOException, Exception;

    List<TweetDao> getTweets(List<UserDao> userDao) throws IOException;

    boolean isUserFollowingTweeter(String user, TweetDao tweet, List<UserDao> returnedUsers);
}
