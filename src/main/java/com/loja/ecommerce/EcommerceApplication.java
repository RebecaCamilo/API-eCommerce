package com.loja.ecommerce;

import com.loja.ecommerce.model.User;
import com.loja.ecommerce.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository users, PasswordEncoder encoder) {
		return args -> {
			users.save(new User(1L, "user",encoder.encode("pass"),"ROLE_USER"));
			users.save(new User(2L, "adm",encoder.encode("pass"),"ROLE_USER,ROLE_ADMIN"));
		};
	}
}
