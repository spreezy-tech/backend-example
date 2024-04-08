package com.abcteam.customerservice.stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.Closeable;
import java.net.http.HttpClient;

@Slf4j
public class CustomerServiceStepDefinations extends StartupHook {


    @Given("User calls login endpoint fail")
    public void userCallsLoginEndpoint() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity response = restTemplate.getForEntity("http://localhost:8083/test1",ResponseEntity.class);
        Serenity.setSessionVariable("response").to(response.getBody().toString());
    }

    @When("System processes login request")
    public void systemProcessesLoginRequest() {
    }

    @Then("Validate response from the login endpoint")
    public void validateResponseFromTheLoginEndpoint() {
        Assertions.assertEquals("User created successfully", Serenity.getCurrentSession().get("response"));
    }
}
