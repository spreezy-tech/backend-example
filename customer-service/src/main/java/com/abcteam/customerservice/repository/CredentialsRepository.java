package com.abcteam.customerservice.repository;

import com.abcteam.customerservice.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsRepository extends JpaRepository<UserCredentials, Integer> {

    UserCredentials findByUsername(String name);
}
