package com.codewithprojects.auth.service.impl;

import com.codewithprojects.auth.dto.SignUpRequest;
import com.codewithprojects.auth.dto.UserDetailsDto;
import com.codewithprojects.auth.enums.Role;
import com.codewithprojects.auth.mapper.UserMapper;
import com.codewithprojects.auth.model.User;
import com.codewithprojects.auth.repository.UserRepository;
import com.codewithprojects.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDetailsDto signup(SignUpRequest signUpRequest) {
        User user = userMapper.signUpToUser(signUpRequest);
        user.setRole(Role.USER);
        return userMapper.userToUserDetails(userRepository.save(user));
    }

}