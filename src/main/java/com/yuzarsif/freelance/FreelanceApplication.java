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
    public CommandLineRunner commandLineRunner(MessageService messageService) {
        return args -> {


            List<MessageDto> messages = messageService.findMessages(2L, 1L);

            for (MessageDto messageDto: messages) {
                System.out.println(messageDto);
            }

            System.out.println("****");

            List<MessageDto> messages1 = messageService.findMessages(1L, 2L);

            for (MessageDto messageDto: messages1) {
                System.out.println(messageDto);
            }

            System.out.println("****");


            List<MessageDto> messages2 = messageService.findMessages(3L, 1L);

            for (MessageDto messageDto: messages2) {
                System.out.println(messageDto);
            }

        };
    }

}
