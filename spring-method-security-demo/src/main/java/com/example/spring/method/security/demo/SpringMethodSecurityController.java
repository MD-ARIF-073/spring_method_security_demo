package com.example.spring.method.security.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringMethodSecurityController {

    @GetMapping("/api/public")
    public String publicEndPoint(){
        return "This is a public endpoint";
    }
    // Restricted endpoint that requires ADMIN role
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/api/admin")
    public String adminEndpoint(){
        return "This is an admin endpoint, only accessible to users with ROLE_ADMIN";
    }
    // Restricted endpoint that requires specific authority
    @PreAuthorize("hasAuthority('ROLE_MANAGE_USERS')")
    @GetMapping("/api/manage_users")
    public String manageUsersEndpoint() {
        return "This is a manage users endpoint, only accessible to users with ROLE_MANAGE_USERS authority.";
    }

    // Restricted endpoint with dynamic parameter checks
    @PreAuthorize("hasRole('ROLE_USER') and #id == authentication.principal.id")
    @GetMapping("/api/user/{id}")
    public String userEndpoint(@PathVariable Long id){
        return "This is a user-specific endpoint, only accessible to users with ROLE_USER and their own ID.";
    }

}