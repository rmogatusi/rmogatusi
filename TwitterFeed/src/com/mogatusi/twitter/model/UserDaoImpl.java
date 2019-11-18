package com.mogatusi.twitter.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDaoImpl {

    private List<UserDao> usersList;
    private File users;

    public UserDaoImpl() {
        this.usersList = new ArrayList<>();
    }

    public List<UserDao> userFromFile() throws FileNotFoundException, IOException, Exception {
        users = new File("user.txt");
        Scanner fileReader = new Scanner(users);

        String usersLine = null;

        while (fileReader.hasNextLine()){
            usersLine = fileReader.nextLine();
            usersList.add(lineReader(usersLine));
        }

        if (usersList==null){
            throw new Exception("No users exist in the records.");
        }
        return usersList;
    }

    //Mapping users from the source line in user.txt
    private UserDao lineReader(String sourceLine) {

        //twitter user
        String user = sourceLine.substring(0, sourceLine.indexOf("follows") - 1);

        List<String> followingArray = new ArrayList<>();
        //finding the person the user follows people
        String following = sourceLine.substring(sourceLine.lastIndexOf(" ") + 1, sourceLine.length()) ;
        String alsoFollowing = null;

        followingArray.add(following);

        //checking if there is another person the user is following
        boolean alsoFollows = false;
        for (int c=0; c<=sourceLine.length()-1; c++) {
            if (sourceLine.charAt(c) == ',') {
                alsoFollows = true;
            }
        }

        if ((sourceLine.lastIndexOf(" ") - sourceLine.indexOf("follows")) > 7 && (alsoFollows)) {
            alsoFollowing = sourceLine.substring(sourceLine.indexOf("follows") + 8, sourceLine.indexOf(","));
            followingArray.add(alsoFollowing);
        }

        return new UserDao(user, followingArray);
    }
}
