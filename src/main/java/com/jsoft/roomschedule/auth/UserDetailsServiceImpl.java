package com.jsoft.roomschedule.auth;

import com.jsoft.roomschedule.users.SystemUser;
import com.jsoft.roomschedule.users.SystemUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {
    public UserDetailsServiceImpl(SystemUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final SystemUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser user = userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found."));
        return new UserDetailsImpl(user);

    }
}
