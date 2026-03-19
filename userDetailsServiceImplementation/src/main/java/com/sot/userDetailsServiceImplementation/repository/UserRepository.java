package com.sot.userDetailsServiceImplementation.repository;

import com.sot.userDetailsServiceImplementation.model.UserProfile;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<String, UserProfile> userMap = new ConcurrentHashMap<>();

    public void addUser(UserProfile user) {
        userMap.put(user.getUsername(), user);
    }

    public UserProfile findByUsername(String username) {
        return userMap.get(username);
    }

    @PostConstruct
    public void init() {
        addUser(new UserProfile(1L, "username", "Aa123456789", List.of("ROLE_USER")));
    }
}
