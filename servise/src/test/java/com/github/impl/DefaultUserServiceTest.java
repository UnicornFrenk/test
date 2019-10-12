package com.github.impl;


import Model.AuthUser;
import com.github.UserService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultUserServiceTest {



    @Mock
    private DefaultUserService userService;

    @Test
    public void createUserNameTest() {
        userService =  new DefaultUserService();

        AuthUser user = userService.getByLogin("Sofia");

        assertEquals("Sofia",user.getLogin());
//        assertEquals("CustomLastName",user.getLastName());

    }
}
