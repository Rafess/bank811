package com.santander.banco811.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.santander.banco811.dto.UserRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "usuario")
@Entity
@Getter  @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "senha")
    private String password;

    @Column(name = "nome")
    private String name;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime creationDate;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Account> accounts;

    public User(UserRequest userRequest) {
        this.cpf = userRequest.getCpf();
        this.name = userRequest.getName();
        this.password = userRequest.getPassword();
    }
}
