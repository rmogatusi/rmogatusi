package com.mogatusi.twitter.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TweetDaoImpl {

    private File tweetsFile;
    private List<TweetDao> tweetsList;
    private String tweetLine;

    public TweetDaoImpl() {
        tweetsList = new ArrayList<>();
    }

    public List<TweetDao> fromFile(List<UserDao> userDao) throws FileNotFoundException, IOException {
        tweetsFile = new File("tweet.txt");

        Scanner fileReader = new Scanner(tweetsFile);
        int userIndex=0;
        while (fileReader.hasNextLine()) {
            tweetLine = fileReader.nextLine();
            tweetsList.add(lineReader(/*userDao.get(0).getName(),*/ tweetLine));
            userIndex++;
        }

        return tweetsList;
    }

    private TweetDao lineReader(/*String user,*/ String sourceLine) {
        String presentationTweet = null;

        String tweetUser = sourceLine.substring(0, sourceLine.indexOf(">"));
        String tweet = sourceLine.substring(sourceLine.lastIndexOf(">")+2, sourceLine.length()) ;

        //if(tweetUser.equals(user)){
            presentationTweet = "@" + tweetUser + ": " + tweet;
            return new TweetDao(tweetUser, presentationTweet);
        //}
        //return new TweetDao(tweetUser, tweet);
    }
}
