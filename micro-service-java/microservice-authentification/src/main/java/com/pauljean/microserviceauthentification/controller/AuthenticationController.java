package com.pauljean.microserviceauthentification.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import com.pauljean.microserviceauthentification.model.AddRoletoUserForm;
import com.pauljean.microserviceauthentification.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauljean.microserviceauthentification.config.jwt.JwtProvider;
import com.pauljean.microserviceauthentification.entity.Role;
import com.pauljean.microserviceauthentification.entity.RoleName;
import com.pauljean.microserviceauthentification.entity.User;
import com.pauljean.microserviceauthentification.model.JwtResponse;
import com.pauljean.microserviceauthentification.model.LoginForm;
import com.pauljean.microserviceauthentification.model.SignUpForm;
import com.pauljean.microserviceauthentification.repository.RoleRepository;
import com.pauljean.microserviceauthentification.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtProvider jwtProvider;
	@Autowired
	AccountServiceImpl accountService;



	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		return ResponseEntity.ok(new JwtResponse(jwt));
	}

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<String>("Fail -> Username is already taken!", HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<String>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		//Un  Utilisateur par defaut a un Role User, pas besion de l'entree dans la requette Post
		//String strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

			//Un  Utilisateur par defaut a un Role User et l'administrteur peut lui ajouter un role si besion
			/*switch (strRoles) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "pm":
				Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(pmRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}*/

		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok().body("User registered successfully!");
	}

	@PostMapping("/addRoleToUser")
	public ResponseEntity<String> addRoleToUser(@Valid @RequestBody AddRoletoUserForm addRoletoUserFormRequest)
	{
		if (!userRepository.existsByUsername(addRoletoUserFormRequest.getUsername())){
			return new ResponseEntity<String>("Fail -> Username don't exist!", HttpStatus.BAD_REQUEST);
		}

		Role role = null;
		//Un  Utilisateur par defaut a un Role User et l'administrteur peut lui ajouter un role si besion
			switch (addRoletoUserFormRequest.getRole()) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				role=adminRole;

				break;
			case "pm":
				Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				role=pmRole;
				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				role=userRole;
			}



		accountService.addRoleToUser(addRoletoUserFormRequest.getUsername(), role);

		return ResponseEntity.ok().body("Role to User added successfully!");

	}




}
