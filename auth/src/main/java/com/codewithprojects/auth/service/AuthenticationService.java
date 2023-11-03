package com.codewithprojects.auth.service;

import com.codewithprojects.auth.dto.SignUpRequest;
import com.codewithprojects.auth.dto.UserDetailsDto;

public interface AuthenticationService {
    UserDetailsDto signup(SignUpRequest signUpRequest);
}
