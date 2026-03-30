package az.ingress.libraryapplication.service;

import az.ingress.libraryapplication.dto.UserRequestDto;
import az.ingress.libraryapplication.dto.UserResponseDto;
import az.ingress.libraryapplication.entity.User;
import az.ingress.libraryapplication.mapper.UserMapper;
import az.ingress.libraryapplication.repository.UserRepo;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements  UserService{


    private static UserRepo userRepo;
    private static UserMapper userMapper;
    @Override
    public String createUser(UserRequestDto userRequest) {
        User user = userMapper.toUser(userRequest);
        userRepo.save(user);
        return "User Created Successfully";

    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepo.findById(id).get();
        UserResponseDto userResponseDto = userMapper.toUserResponse(user);
        return userResponseDto;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        users.forEach(user -> userResponseDtos.add(userMapper.toUserResponse(user)));
        return userResponseDtos;
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequest) {
        User user=userRepo.findById(id).get();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        userRepo.save(user);
        UserResponseDto userResponseDto = userMapper.toUserResponse(user);
        return userResponseDto;

    }

    @Override
    public String deleteUser(Long id) {
        userRepo.deleteById(id);
        return "User deleted successfully";
    }
}
