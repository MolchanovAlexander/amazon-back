package org.example.amazonback.dto.user;

import jakarta.validation.constraints.Min;

public record LimitDto(
        @Min(value = 10, message = "Limit must be more than 10") Integer limit
) {

}
