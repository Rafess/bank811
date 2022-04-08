package com.santander.banco811.model;

import com.santander.banco811.dto.AccountRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "conta")
@Entity
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero")
    private Integer number;

    @Column(name = "agencia")
    private Integer agency;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime creationDate;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime updateDate;

    @Column(name = "saldo")
    private BigDecimal balance;

    @Column(name = "tipo_conta")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ususario_id")
    private User ususario;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    public Account(AccountRequest accountRequest, String username) {
        this.number = accountRequest.getNumber();
        this.agency = accountRequest.getAgency();
        this.accountType = accountRequest.getAccountType();
        this.user = accountRequest.getUser();
    }
}
