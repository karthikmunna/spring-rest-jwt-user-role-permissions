package com.fullstackblog.sms.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void getId() {
        Long idValue = 4l;

        user.setId(idValue);
        assertEquals(idValue,user.getId());
    }

    @Test
    public void setUsername() {
    }

    @Test
    public void getRole() {
    }
}