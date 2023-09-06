package com.yuzarsif.freelance;

import com.yuzarsif.freelance.dto.EmployeeDto;
import com.yuzarsif.freelance.dto.RatingDto;
import com.yuzarsif.freelance.model.Employee;
import com.yuzarsif.freelance.model.Employer;
import com.yuzarsif.freelance.model.Rating;
import com.yuzarsif.freelance.repository.EmployeeRepository;
import com.yuzarsif.freelance.repository.EmployerRepository;
import com.yuzarsif.freelance.repository.RatingRepository;
import com.yuzarsif.freelance.request.CreateEmployeeRequest;
import com.yuzarsif.freelance.service.EmployeeService;
import com.yuzarsif.freelance.service.EmployerService;
import com.yuzarsif.freelance.service.RatingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FreelanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreelanceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {

        };
    }

}
