package com.mogatusi.twitter.test.model;

import com.mogatusi.twitter.model.UserDao;
import com.mogatusi.twitter.model.UserDaoImpl;
import com.mogatusi.twitter.service.UserService;
import com.mogatusi.twitter.service.UserServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    private UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Test
    public void userFromFile() throws Exception {

        List<UserDao> userDaoList = userDaoImpl.userFromFile();
        assertEquals(userDaoList.size(), 3);
        assertEquals(userDaoList.get(0).getFollowing().size(), 1);
        assertEquals(userDaoList.get(1).getFollowing().size(), 1);
        assertEquals(userDaoList.get(2).getFollowing().size(), 2);
    }
}