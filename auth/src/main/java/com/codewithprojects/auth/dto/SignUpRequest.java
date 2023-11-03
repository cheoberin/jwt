package com.codewithprojects.auth.dto;

import jakarta.validation.constraints.*;

public record SignUpRequest(
        @NotNull(message = "First name must be filled")
        String firstName,
        @NotBlank(message = "Last name must be filled")
        String lastName,
        @NotBlank(message = "Email must be filled")
        @Email(message = "Insert a valid e-mail")
        String email,
        @NotBlank(message = "Password should not be empty")
        @Size(min = 8, max = 24, message = "Password must have between 8 and 24 characters")
        @Pattern(regexp = ".*[!@#$%^&*()].*", message = "Password must have at least one special character")
        @Pattern(regexp = ".*\\d.*", message = "Password must have at least one digit")
        @Pattern(regexp = ".*[a-z].*", message = "Password must have at least one lowercase letter")
        @Pattern(regexp = ".*[A-Z].*", message = "Password must have at least one uppercase letter")
        String password) {
}
