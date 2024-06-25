package org.example.amazonback.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.amazonback.dto.user.CreateUserRequestDto;

public class PasswordMatchesValidator
        implements ConstraintValidator<FieldMatch, CreateUserRequestDto> {

    @Override
    public boolean isValid(CreateUserRequestDto requestDto,
                           ConstraintValidatorContext context) {
        return requestDto.getPassword() != null
                && requestDto.getPassword().equals(requestDto.getRepeatedPassword());
    }
}
