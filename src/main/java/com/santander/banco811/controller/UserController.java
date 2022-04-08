package com.santander.banco811.controller;

import com.santander.banco811.dto.UserRequest;
import com.santander.banco811.dto.UserResponse;
import com.santander.banco811.model.User;
import com.santander.banco811.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAll(@RequestParam(required = false) String nome) {
        return userService.getAll(nome);
    }

    @PostMapping
    public UserResponse create(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
        return userService.update(userRequest, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
