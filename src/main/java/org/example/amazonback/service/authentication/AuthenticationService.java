package org.example.amazonback.service.authentication;


import org.example.amazonback.dto.user.UserLoginRequestDto;
import org.example.amazonback.dto.user.UserLoginResponseDto;
import org.example.amazonback.model.User;

public interface AuthenticationService {

    UserLoginResponseDto authenticate(UserLoginRequestDto requestDto);

    User findById(Long id);
}
