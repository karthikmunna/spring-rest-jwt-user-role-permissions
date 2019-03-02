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
        String username = "admin";

        user.setUsername(username);

        assertEquals(username,user.getUsername());
    }

    @Test
    public void getRole() {
        Role role = new Role();
        user.setRole(role);

        assertEquals(role,user.getRole());
    }
}