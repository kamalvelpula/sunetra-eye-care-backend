package com.yogeshwar.eyecare;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yogeshwar.eyecare.entity.Admin;
import com.yogeshwar.eyecare.repository.AdminRepository;

@Configuration
public class AdminDataInitializer {

    @Bean
    public CommandLineRunner createAdmin(
            AdminRepository adminRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            if (adminRepository.findByUsername("admin").isEmpty()) {

                Admin admin = new Admin();

                admin.setUsername("admin");

                // Temporary development password
                admin.setPassword(
                        passwordEncoder.encode("ChangeMe@12345"));

                admin.setRole("ADMIN");

                adminRepository.save(admin);

                System.out.println("Admin account created successfully!");
            }
        };
    }
}