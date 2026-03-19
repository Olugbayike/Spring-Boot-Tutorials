package com.sot.userDetailsServiceImplementation.model;

import java.util.List;

public class UserProfile {
    private final Long id;
    private final String username;
    private final String password;
    private final List<String> roles;

    public UserProfile(Long id, String username, String password, List<String> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRoles() {
        return roles;
    }
}
