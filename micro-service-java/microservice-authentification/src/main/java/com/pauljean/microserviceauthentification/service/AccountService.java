package com.pauljean.microserviceauthentification.service;

import com.pauljean.microserviceauthentification.entity.RoleName;
import com.pauljean.microserviceauthentification.entity.User;

import java.util.Optional;

public interface AccountService {

    //enregistrer un User
    public User saveUser(String name,String userName,String email,String password);

    // sauvegarder un User connaissant son Username
    public Optional<User> loadUserByUsername(String username);

    // ajoutr un role a un user
    public void addRoleToUser(String username, RoleName rolename);

}
