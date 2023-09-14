package com.yuzarsif.freelance;

import com.yuzarsif.freelance.dto.ConversationDto;
import com.yuzarsif.freelance.dto.MessageDto;
import com.yuzarsif.freelance.model.Conversation;
import com.yuzarsif.freelance.model.Employee;
import com.yuzarsif.freelance.model.Employer;
import com.yuzarsif.freelance.repository.ConversationRepository;
import com.yuzarsif.freelance.repository.EmployeeRepository;
import com.yuzarsif.freelance.repository.EmployerRepository;
import com.yuzarsif.freelance.request.CreateMessageRequest;
import com.yuzarsif.freelance.service.ConversationService;
import com.yuzarsif.freelance.service.MessageService;
import com.yuzarsif.freelance.service.UserService;
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
    public CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {

        userService.deleteUserById(6L);


        };
    }

}
