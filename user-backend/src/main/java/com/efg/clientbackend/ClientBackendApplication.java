package com.efg.clientbackend;

import static java.util.Arrays.asList;

import com.efg.clientbackend.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.efg.clientbackend.service.UserService;

@SpringBootApplication
public class ClientBackendApplication {

	private static final String ADMIN_GROUP_ID = "Admin";
	private static final String ANALYST_GROUP_ID = "Analyst";
	private static final String COUNSELOR_GROUP_ID = "Counselor";
	private static final String HR_GROUP_ID = "HR";
	private static final String CLIENT_GROUP_ID = "Client";

	public static void main(String[] args) {
		SpringApplication.run(ClientBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner init(final UserService userService) {
		return args -> userService.saveAll(asList(
				new User("Robert", ADMIN_GROUP_ID),
				new User("Félix", ANALYST_GROUP_ID),
				new User("Antonio", ANALYST_GROUP_ID),
				new User("Patrick", ANALYST_GROUP_ID),

				new User("Anna", COUNSELOR_GROUP_ID),
				new User("Mari-Luz", COUNSELOR_GROUP_ID),

				new User("Laure", HR_GROUP_ID),
				new User("Antoine", HR_GROUP_ID),

				new User("Mr Lecompte", CLIENT_GROUP_ID),
				new User("Mr Rochefoucauld", CLIENT_GROUP_ID),
				new User("Mr Destribois", CLIENT_GROUP_ID),
				new User("Mme Chappuis", CLIENT_GROUP_ID),
				new User("Mme Marie-Thérèse Porchet", CLIENT_GROUP_ID)));
	}
}