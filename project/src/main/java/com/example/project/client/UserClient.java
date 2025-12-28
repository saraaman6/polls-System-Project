package com.example.project.client;

import com.example.project.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@FeignClient(
        name = "user-service",
        url = "${users.service.url}")
public interface UserClient {

    @GetMapping("/users/{id}")
    UserDto getUserById(@PathVariable Long id);

    @GetMapping("/users/all")
    List<UserDto> getAllUsers();


    @DeleteMapping("/users/delete/{id}")
    void deleteUser(@PathVariable("id") Long id);
}


