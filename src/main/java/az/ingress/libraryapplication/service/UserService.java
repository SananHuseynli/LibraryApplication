package az.ingress.libraryapplication.service;


import az.ingress.libraryapplication.dto.UserRequestDto;
import az.ingress.libraryapplication.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    String createUser(UserRequestDto userRequest);

    UserResponseDto getUserById(Long id);

    List<UserResponseDto> getAllUsers();

    UserResponseDto updateUser(Long id, UserRequestDto userRequest);

    String deleteUser(Long id);
}



