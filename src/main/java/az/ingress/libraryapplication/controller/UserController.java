package az.ingress.libraryapplication.controller;

import az.ingress.libraryapplication.dto.UserRequestDto;
import az.ingress.libraryapplication.dto.UserResponseDto;
import az.ingress.libraryapplication.entity.User;
import az.ingress.libraryapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor

public class UserController {

    private final UserService service;

    @GetMapping("/users")
    public List<UserResponseDto> getUsers() {
        return service.getAllUsers();
    }


    @PostMapping(value = "/addUser",consumes = "application/json")
    public String createUser(@RequestBody UserRequestDto userRequest) {
        service.createUser(userRequest);
        return "user created successfully";

    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable long id) {
        UserResponseDto userById = service.getUserById(id);
        return userById;

    }

    @PutMapping("/updateUser")
    public String updateUser(Long id, @RequestBody UserRequestDto userRequestDto) {
        service.updateUser(id,userRequestDto);
        return "user updated successfully";
    }
}
