package com.Exam.ExamServer;

import com.Exam.ExamServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

			System.out.println("CODE RUNNING PROPERLY");

//			User user = new User();
//			user.setFirstName("Neha");
//			user.setLastName("Pisal");
//			user.setUsername("nehaaa10");
//			user.setPassword(this.bCryptPasswordEncoder.encode("1234"));
//			user.setEmail("neha10@abc.com");
//			user.setImage("default.png");
//
//			Role role1 = new Role();
//			role1.setRoleId(12L);
//			role1.setRoleName("ADMIN");
//
//			Set<UserRole> userRoleSet = new HashSet<>();
//			UserRole userRole = new UserRole();
//			userRole.setRole(role1);
//			userRole.setUser(user);
//			userRoleSet.add(userRole);
//
//			User user1 = this.userService.createUser(user, userRoleSet);
//			System.out.println(user1.getUsername());

	}
}
