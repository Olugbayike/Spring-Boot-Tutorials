package com.sot.userDetailsServiceImplementation.security;

import com.sot.userDetailsServiceImplementation.model.SecurityUser;
import com.sot.userDetailsServiceImplementation.model.UserProfile;
import com.sot.userDetailsServiceImplementation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: "+username);
        }

        return new SecurityUser(user);
    }
}
