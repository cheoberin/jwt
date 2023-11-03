package com.codewithprojects.auth.controller;

import com.codewithprojects.auth.dto.SignUpRequest;
import com.codewithprojects.auth.dto.UserDetailsDto;
import com.codewithprojects.auth.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<UserDetailsDto> signup(@RequestBody @Valid SignUpRequest signUpRequest,
                                                 UriComponentsBuilder uriComponentsBuilder) {
        var user = authenticationService.signup(signUpRequest);
        var uri = uriComponentsBuilder.path("api/v1/user/" + user.id()).build().toUri();
        return ResponseEntity.created(uri).body(user);
    }

}
