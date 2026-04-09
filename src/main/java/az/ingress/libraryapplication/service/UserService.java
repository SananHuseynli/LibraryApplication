package az.ingress.libraryapplication.service;


import az.ingress.libraryapplication.dto.UserRequestDto;
import az.ingress.libraryapplication.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    void createUser(UserRequestDto userRequest);

    UserResponseDto getUserById(Long id);

    List<UserResponseDto> getAllUsers();

    UserResponseDto updateUser(Long id, UserRequestDto userRequest);

    String deleteUser(Long id);
}



