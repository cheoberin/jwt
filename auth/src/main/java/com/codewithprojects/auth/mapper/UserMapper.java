package com.codewithprojects.auth.mapper;

import com.codewithprojects.auth.dto.SignUpRequest;
import com.codewithprojects.auth.dto.UserDetailsDto;
import com.codewithprojects.auth.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public User signUpToUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setFirstName(signUpRequest.firstName());
        user.setLastName(signUpRequest.lastName());
        user.setEmail(signUpRequest.email());
        user.setPassword(passwordEncoder.encode(signUpRequest.password()));
        return user;
    }

    public UserDetailsDto userToUserDetails(User user) {
        return new UserDetailsDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
