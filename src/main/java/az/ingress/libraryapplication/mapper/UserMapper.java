package az.ingress.libraryapplication.mapper;

import az.ingress.libraryapplication.dto.UserRequestDto;
import az.ingress.libraryapplication.dto.UserResponseDto;
import az.ingress.libraryapplication.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {

    public UserResponseDto toUserResponse(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setSurname(user.getSurname());
        userResponseDto.setBirthday(user.getBirthday());
        userResponseDto.setPhoto(user.getPhoto());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setRole(user.getRole());
        return userResponseDto;

    }

    public User toUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setSurname(userRequestDto.getSurname());
        user.setBirthday(userRequestDto.getBirthday());
        user.setPhoto(userRequestDto.getPhoto());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setRole(userRequestDto.getRole());
        user.setCreatedAt(LocalDateTime.now());
        return user;

    }
}
