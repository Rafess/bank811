package com.santander.banco811.service.impl;

import com.santander.banco811.dto.UserRequest;
import com.santander.banco811.dto.UserResponse;
import com.santander.banco811.model.User;
import com.santander.banco811.repository.UserRepository;
import com.santander.banco811.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Page<User> getAll(String name, int page, int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "name"
        );
        if (name != null) {
            return userRepository.findByName(name, pageRequest);
        } else {
            return userRepository.findAll(pageRequest);
        }
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = new User(userRequest);
        userRepository.save(user);

        return new UserResponse(user);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User update(UserRequest userRequest, Integer id) {
        User user = userRepository.findById(id).orElseThrow();

        user.setName(userRequest.getName());
        user.setCpf(userRequest.getCpf());
        user.setPassword(userRequest.getPassword());

        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        var usuario = userRepository.findById(id).orElseThrow();

        userRepository.delete(usuario);
    }
}
