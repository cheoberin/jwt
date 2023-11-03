package com.codewithprojects.auth;

import com.codewithprojects.auth.enums.Role;
import com.codewithprojects.auth.model.User;
import com.codewithprojects.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AuthApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.findByRole(Role.ADMIN);
        if (user == null) {
            User newUser = new User();
            newUser.setEmail("admin@admin.com");
            newUser.setFirstName("admin");
            newUser.setLastName("admin");
            newUser.setRole(Role.ADMIN);
            newUser.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(newUser);
        }
    }
}
