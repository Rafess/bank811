package com.santander.banco811.dto;

import com.santander.banco811.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private Integer id;
    private String cpf;
    private String nome;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public UserResponse(User user) {
        this.id = user.getId();
        this.cpf = user.getCpf();
        this.dataCriacao = user.getDataCriacao();
        this.nome = user.getNome();
        this.dataAtualizacao = user.getDataAtualizacao();
    }

    public static List<UserResponse> toResponse(List<User> users){
        return  users.stream().map(UserResponse::new).collect(Collectors.toList());
    }
}
