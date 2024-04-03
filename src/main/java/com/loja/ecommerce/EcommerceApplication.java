package com.loja.ecommerce;

import com.loja.ecommerce.model.Role;
import com.loja.ecommerce.model.User;
import com.loja.ecommerce.repository.RoleRepository;
import com.loja.ecommerce.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
		return args -> {
			var roleUser = roleRepository.save(new Role(1, "USER"));
			var roleAdmin =roleRepository.save(new Role(2, "ADMIN"));
			userRepository.save(new User(1L, "user",encoder.encode("pass"), new HashSet<>(Set.of(roleUser))));
			userRepository.save(new User(2L, "adm",encoder.encode("pass"), new HashSet<>(Set.of(roleUser, roleAdmin))));
		};
	}
}
