package com.abcteam.customerservice.repository;

import com.abcteam.customerservice.entity.UserCredentials;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class CredentialsRepositoryTest {

    @Autowired
    private CredentialsRepository testCredentialsRepository;

    @BeforeEach
    void setup(){
        System.out.println("Before the test");
    }

    @AfterEach
    void tearDown(){
        System.out.println("After the test");
    }

    @Test
    void findByUsername() {
        //given
        String name = "Sarthak";
        UserCredentials expectedUserCredentials = new UserCredentials(1,"Sarthak","testpassword");
        testCredentialsRepository.save(expectedUserCredentials);

        //when
        UserCredentials resultUserCredentials = testCredentialsRepository.findByUsername(name);

        //then
        assertThat(resultUserCredentials).isEqualTo(expectedUserCredentials);
    }
}