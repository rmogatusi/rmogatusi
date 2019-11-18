package com.mogatusi.twitter.test.model;

import com.mogatusi.twitter.model.UserDao;
import com.mogatusi.twitter.model.UserDaoImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TweetDaoImplTest {

    private UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Test
    public void fromFile() throws Exception {

        List<UserDao> userDaoList = userDaoImpl.userFromFile();
        assertEquals(userDaoList.size(), 3);
        assertEquals(userDaoList.get(0).getFollowing().size(), 1);
        assertEquals(userDaoList.get(1).getFollowing().size(), 1);
        assertEquals(userDaoList.get(2).getFollowing().size(), 2);
        assertEquals(userDaoList.get(2).getFollowing().get(0), "Alan");
        assertEquals(userDaoList.get(2).getFollowing().get(1), "Martin");
    }
}