package com.efg.clientbackend.service;

import com.efg.clientbackend.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import javax.security.auth.login.AccountNotFoundException;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks UserService userService;

    @Test(expected = AccountNotFoundException.class)
    public void findByIdTest() {
        final String id = "id";
        Mockito.when(userRepository.findById(id))
                .thenThrow(new AccountNotFoundException(id));
        userService.findById(id);
    }

    // TODO: Remaining functions in UserService
}
