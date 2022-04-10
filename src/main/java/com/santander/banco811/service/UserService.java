package com.santander.banco811.service;

import com.santander.banco811.dto.UserRequest;
import com.santander.banco811.dto.UserResponse;
import com.santander.banco811.model.User;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> getAll(String name, int page, int size);
    UserResponse create(UserRequest userRequest);
    User getById(Integer id);
    User update(UserRequest userRequest, Integer id);
    void delete(Integer id);
}
