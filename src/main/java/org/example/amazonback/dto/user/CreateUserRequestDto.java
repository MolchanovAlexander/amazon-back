package org.example.amazonback.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.amazonback.validation.FieldMatch;

@Data
@FieldMatch
public class CreateUserRequestDto {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 6, max = 55)
    private String password;
    @NotBlank
    @Size(min = 6, max = 55)
    private String repeatedPassword;
    @NotBlank
    @Size(min = 2, max = 55)
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 55)
    private String lastName;
    private String shippingAddress;
}
