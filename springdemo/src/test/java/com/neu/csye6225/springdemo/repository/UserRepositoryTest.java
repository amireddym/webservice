package com.neu.csye6225.springdemo.repository;

import com.neu.csye6225.springdemo.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void findByUsernameTest() {

        User user = new User("manojreddy","amireddy","amireddy@gmail.com","123456");
        userRepository.save(user);
        User userFound = userRepository.findByUsername(user.getUsername());
        Assert.assertEquals(userFound,user);

    }

    @Test
    void findByUsernameNotExistsTest() {

        User userFound = userRepository.findByUsername("manoj");
        Assert.assertNull(userFound);

    }
}