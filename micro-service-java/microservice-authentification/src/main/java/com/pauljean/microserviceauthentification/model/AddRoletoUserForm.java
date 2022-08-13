package com.pauljean.microserviceauthentification.model;

import com.pauljean.microserviceauthentification.entity.RoleName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AddRoletoUserForm {
    @NotBlank
    @Size(min=3, max = 60)
    private String username;

    private String role;


}