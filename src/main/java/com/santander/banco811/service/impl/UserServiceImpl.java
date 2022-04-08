package com.santander.banco811.service.impl;

import com.santander.banco811.dto.UserRequest;
import com.santander.banco811.dto.UserResponse;
import com.santander.banco811.model.User;
import com.santander.banco811.repository.UserRepository;
import com.santander.banco811.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll(String nome) {

        if (nome != null) {
            return userRepository.findByNome(nome);
        } else {
            return userRepository.findAll();
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

        user.setNome(userRequest.getNome());
        user.setCpf(userRequest.getCpf());
        user.setSenha(userRequest.getSenha());

        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        var usuario = userRepository.findById(id).orElseThrow();

        userRepository.delete(usuario);
    }
}
