package com.santander.banco811.dto;

import com.santander.banco811.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@RequiredArgsConstructor
public class UserResponse {
    private Integer id;
    private String cpf;
    private String name;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public UserResponse(User user) {
        this.id = user.getId();
        this.cpf = user.getCpf();
        this.name = user.getName();
        this.creationDate = user.getCreationDate();
        this.updateDate = user.getUpdateDate();
    }


    public static List<UserResponse> toResponse(List<User> users){
        return  users.stream().map(UserResponse::new).collect(Collectors.toList());
    }
}
