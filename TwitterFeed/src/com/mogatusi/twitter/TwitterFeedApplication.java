package com.mogatusi.twitter;

import com.mogatusi.twitter.model.TweetDao;
import com.mogatusi.twitter.model.TweetDaoImpl;
import com.mogatusi.twitter.model.UserDao;
import com.mogatusi.twitter.model.UserDaoImpl;
import com.mogatusi.twitter.service.UserService;
import com.mogatusi.twitter.service.UserServiceImpl;

import java.io.*;
import java.util.List;
import java.util.Scanner;

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

        try (OutputStreamWriter osw = new OutputStreamWriter(System.out)){
            for (TweetDao tweet: tweets){
                    osw.write(tweet.getTweeter() + "\n" + "\t" + tweet.getTweet() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
