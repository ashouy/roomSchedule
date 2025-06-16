package com.jsoft.roomschedule.users;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private SystemUserRepository userRepository;

    public UserService(SystemUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<SystemUser> findByEmail(String subject) {
        return userRepository.findByEmail(subject);
    }
}
