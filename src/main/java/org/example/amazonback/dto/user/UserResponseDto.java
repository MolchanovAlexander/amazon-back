package org.example.amazonback.dto.user;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import org.example.amazonback.model.Role;

@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String shippingAddress;
    private Set<Role> roles = new HashSet<>();
}
