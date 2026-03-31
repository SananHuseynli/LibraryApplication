package az.ingress.libraryapplication.controller;

import az.ingress.libraryapplication.dto.UserResponseDto;
import az.ingress.libraryapplication.entity.User;
import az.ingress.libraryapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor

public class UserController {

    private  UserService service;


    @GetMapping("/users")

    public List<UserResponseDto> getUsers(){
         return service.getAllUsers();
    }

}
