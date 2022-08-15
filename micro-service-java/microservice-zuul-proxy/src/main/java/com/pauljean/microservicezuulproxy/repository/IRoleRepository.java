package com.pauljean.microservicezuulproxy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauljean.microservicezuulproxy.entity.Role;
import com.pauljean.microservicezuulproxy.entity.RoleName;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
