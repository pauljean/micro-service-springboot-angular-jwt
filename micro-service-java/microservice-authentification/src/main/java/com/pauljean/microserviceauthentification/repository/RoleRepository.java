package com.pauljean.microserviceauthentification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pauljean.microserviceauthentification.entity.Role;
import com.pauljean.microserviceauthentification.entity.RoleName;
@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Optional<Role> findByName(RoleName roleName);
}
