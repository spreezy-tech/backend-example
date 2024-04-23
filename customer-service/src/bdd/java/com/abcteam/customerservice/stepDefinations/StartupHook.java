package com.abcteam.customerservice.stepDefinations;


import com.abcteam.customerservice.CustomerServiceApplication;
import com.abcteam.customerservice.config.CustomerServiceTestConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = CustomerServiceApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles(value = "bdd")
@Import(CustomerServiceTestConfiguration.class)
public class StartupHook {
}
