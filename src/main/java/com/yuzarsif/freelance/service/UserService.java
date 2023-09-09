package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.exceptioin.UserNotFoundException;
import com.yuzarsif.freelance.model.User;
import com.yuzarsif.freelance.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    protected User findUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException("User didnt find by id : " + id));

        return user;
    }
}
