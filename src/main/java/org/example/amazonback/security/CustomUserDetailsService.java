package org.example.amazonback.security;

import java.util.Set;
import org.example.amazonback.model.Role;
import org.example.amazonback.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final User admin = new User();
    {
        admin.setId(1L);
        admin.setEmail("admin@admin.com");
        admin.setPassword("$2a$10$duEFuKqhT34aILFFxJYP0eGjtsiYBBtCJ48floHAXahw7ju4oaEpO");
        Role adminRole = new Role();
        adminRole.setId(1L);
        adminRole.setRole(Role.RoleName.ADMIN);
        admin.setRoles(Set.of(adminRole));
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        if (!email.equals(admin.getEmail())) {
            throw new UsernameNotFoundException("Can't find user by email: " + email);
        }
        return admin;
    }
}
