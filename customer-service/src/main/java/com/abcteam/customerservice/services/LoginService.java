package com.abcteam.customerservice.services;

import com.abcteam.customerservice.entity.UserCredentials;
import com.abcteam.customerservice.model.Credentials;
import com.abcteam.customerservice.repository.CredentialsRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    CredentialsRepository credentialsRepository;

    LoginService(CredentialsRepository credentialsRepository){
        this.credentialsRepository = credentialsRepository;
    }

    public void login(Credentials credentials){
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setId(1);
        userCredentials.setUsername(credentials.getUsername());
        userCredentials.setPassword(credentials.getPassword());
        credentialsRepository.save(userCredentials);
        System.out.println("User logged in is "+ credentials.getUsername());
    }

    public Credentials getUserDetails(String name){
        UserCredentials userCredentials = credentialsRepository.findByUsername(name);
        return Credentials.builder().username(userCredentials.getUsername())
                .password(userCredentials.getPassword()).build();
    }
}
