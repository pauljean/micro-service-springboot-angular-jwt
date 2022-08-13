package com.pauljean.microserviceauthentification.service;

import com.pauljean.microserviceauthentification.entity.Role;
import com.pauljean.microserviceauthentification.entity.RoleName;
import com.pauljean.microserviceauthentification.entity.User;
import com.pauljean.microserviceauthentification.repository.RoleRepository;
import com.pauljean.microserviceauthentification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User saveUser(String name, String userName, String email, String password) {

        if (userRepository.existsByUsername(userName)) throw new RuntimeException("User already exist");
        User user=new User();

        user.setName(name);
        user.setUsername(userName);
        user.setEmail(email);
        user.setActived(true);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(user);
        addRoleToUser(userName,RoleName.ROLE_USER);

        return user;
    }

    @Override
    public Optional<User> loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, RoleName rolename) {

        Optional<User> user=userRepository.findByUsername(username);
        Optional<Role> role=roleRepository.findByName(rolename);
        user.get().getRoles().add(role.get());

    }
}
