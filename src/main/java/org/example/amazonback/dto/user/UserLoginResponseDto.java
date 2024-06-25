package org.example.amazonback.dto.user;

import jakarta.validation.constraints.NotEmpty;

public record UserLoginResponseDto(
        @NotEmpty
        String token
) {
}
