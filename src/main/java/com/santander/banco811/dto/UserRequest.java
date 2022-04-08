package com.santander.banco811.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequest {
    private String cpf;
    private String nome;
    private String senha;
}
