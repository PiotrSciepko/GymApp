package pl.coderslab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class GymAppSbApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymAppSbApplication.class, args);
    }
}
