package com.abcteam.customerservice.services;

import com.abcteam.customerservice.entity.UserCredentials;
import com.abcteam.customerservice.model.Credentials;
import com.abcteam.customerservice.repository.CredentialsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginService {

    CredentialsRepository credentialsRepository;

    LoginService(CredentialsRepository credentialsRepository){
        this.credentialsRepository = credentialsRepository;
    }

    public void login(Credentials credentials){
        UserCredentials userCredentials = UserCredentials.builder().id(1).username(credentials.getUsername())
                .password(credentials.getPassword()).build();
        credentialsRepository.save(userCredentials);
        System.out.println("User logged in is "+ credentials.getUsername() + "abd" + "xyz");
        log.error("User logged in is {}", credentials.getUsername());
    }

    public Credentials getUserDetails(String name){
        UserCredentials userCredentials = credentialsRepository.findByUsername(name);
        return Credentials.builder().username(userCredentials.getUsername())
                .password(userCredentials.getPassword()).build();
    }
}
