package com.example.demo;

import com.example.demo.modal.Role;
import com.example.demo.modal.User;
import com.example.demo.securityConfiguration.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;


	//@Autowired
	//private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUserName("admin");
		user.setPassword("admin");

		Role role = new Role();
		role.setName("ADMIN");;

		Set<Role> roles = new HashSet<>();
		roles.add(role);

		List<User> users = new ArrayList<>();
		users.add(user);

		user.setRoles(roles);
		role.setUsers(users);

		//log.info("PASSWORD IS {} ",passwordEncoder.encode("admin"));







	}
}