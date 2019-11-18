package com.mogatusi.twitter;

import com.mogatusi.twitter.model.TweetDao;
import com.mogatusi.twitter.model.UserDao;
import com.mogatusi.twitter.service.UserService;
import com.mogatusi.twitter.service.UserServiceImpl;

import java.io.*;
import java.util.*;

public class TwitterFeedApplication {

    public static void main(String [] args) throws Exception {
        System.out.println("Welcome to the Twitter Feed Application.");
        System.out.println("");
        UserService service = new UserServiceImpl();
        List<UserDao> returnedUsers = service.getUserDaos();
        consoleOutput(returnedUsers, service);
    }

    private static void consoleOutput(List<UserDao> returnedUsers, UserService service) throws IOException {

        System.out.println();
        List<TweetDao> tweets = service.getTweets(returnedUsers);

        List<String> users = getAllUsers(returnedUsers);

        try (OutputStreamWriter osw = new OutputStreamWriter(System.out)){

            for (String user: users){
                osw.write(user + ":\n");
                for (TweetDao tweet:tweets){
                    if (user.equals(tweet.getTweeter()) || service.isUserFollowingTweeter(user, tweet, returnedUsers) ){
                        osw.write("\t" + tweet.getTweet() + "\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getAllUsers(List<UserDao> returnedUsers){
        List<String> users = new ArrayList<>();
        List<String> following = new ArrayList<>();

        //checking tweeters
        for (UserDao user: returnedUsers){
            if (!users.contains(user.getName())){
                users.add(user.getName());
            }
        }

        //checking followed users
        for (UserDao twitterUser: returnedUsers){
            following = twitterUser.getFollowing();
            for (String user: following){
                if (!users.contains(user)){
                    users.add(user);
                }
            }
        }

        Collections.sort(users);
        return users;
    }
}
