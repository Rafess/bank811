package com.santander.banco811.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class UserRequest {
    private String cpf;
    private String name;
    private String password;
}
