package az.ingress.libraryapplication.service;

import az.ingress.libraryapplication.dto.UserRequestDto;
import az.ingress.libraryapplication.dto.UserResponseDto;
import az.ingress.libraryapplication.entity.User;
import az.ingress.libraryapplication.mapper.UserMapper;
import az.ingress.libraryapplication.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements  UserService{


    private  final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public void createUser(UserRequestDto userRequest) {
        User user = userMapper.toUser(userRequest);
        userRepo.save(user);


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
