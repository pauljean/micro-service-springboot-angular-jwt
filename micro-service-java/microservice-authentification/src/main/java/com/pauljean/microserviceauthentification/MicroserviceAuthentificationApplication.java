package com.pauljean.microserviceauthentification;

import com.pauljean.microserviceauthentification.entity.Role;
import com.pauljean.microserviceauthentification.entity.RoleName;
import com.pauljean.microserviceauthentification.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MicroserviceAuthentificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAuthentificationApplication.class, args);
		
		
		 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		    String password = "manager";
		    String encodedPassword = passwordEncoder.encode(password);

		    System.out.println();
		    System.out.println("Password is         : " + password);
		    System.out.println("Encoded Password is : " + encodedPassword);
		    System.out.println();

		    boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		    System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
		    
	}

	@Bean
	CommandLineRunner start(RepositoryRestConfiguration restConfiguration, RoleRepository roleRepository)
	{
		return Args-> {
			restConfiguration.exposeIdsFor(Role.class);
			List<Role> roles=new ArrayList<>();
			roles.add(new Role(RoleName.ROLE_USER));
			roles.add(new Role(RoleName.ROLE_PM));
			roles.add(new Role(RoleName.ROLE_ADMIN));
			roleRepository.saveAll(roles);

		};
	}




}
