package com.mogatusi.twitter.service;

import com.mogatusi.twitter.model.TweetDao;
import com.mogatusi.twitter.model.TweetDaoImpl;
import com.mogatusi.twitter.model.UserDao;
import com.mogatusi.twitter.model.UserDaoImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDaoImpl = new UserDaoImpl();
    private TweetDaoImpl tweetDaoImpl = new TweetDaoImpl();


    @Override
    public List<UserDao> getUserDaos() throws FileNotFoundException, IOException, Exception {
        List<UserDao> userDaoList = userDaoImpl.userFromFile();
        Collections.sort(userDaoList, new Comparator<UserDao>() {
            @Override
            public int compare(UserDao o1, UserDao o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return userDaoList;
    }

    @Override
    public List<TweetDao> getTweets(List<UserDao> userDao) throws FileNotFoundException, IOException {
        List<TweetDao> tweetDao = tweetDaoImpl.fromFile(userDao);
        return tweetDao;
    }

    @Override
    public boolean isUserFollowingTweeter(String user, TweetDao tweet, List<UserDao> returnedUsers) {

        for (UserDao returnedUser: returnedUsers){
            if (user.equals(returnedUser.getName())){
                for (String following: returnedUser.getFollowing()){
                    if (following.equals(tweet.getTweeter())){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
