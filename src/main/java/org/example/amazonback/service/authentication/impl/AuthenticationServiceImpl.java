package org.example.amazonback.service.authentication.impl;


import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.example.amazonback.dto.user.UserLoginRequestDto;
import org.example.amazonback.dto.user.UserLoginResponseDto;
import org.example.amazonback.exception.EntityNotFoundException;
import org.example.amazonback.model.Role;
import org.example.amazonback.model.User;
import org.example.amazonback.security.JwtUtil;
import org.example.amazonback.service.authentication.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
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

    public UserLoginResponseDto authenticate(UserLoginRequestDto requestDto) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.email(), requestDto.password())
        );
        String token = jwtUtil.generateToken(authentication.getName());
        return new UserLoginResponseDto(token);
    }

    @Override
    public User findById(Long id) {
        if (!id.equals(admin.getId())) {
            throw new EntityNotFoundException("There is no user with id: " + id);
        }
        return admin;
    }
}
