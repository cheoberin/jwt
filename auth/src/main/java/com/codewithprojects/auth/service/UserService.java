package com.codewithprojects.auth.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    public UserDetailsService userDetailsService();

}
