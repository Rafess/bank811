package com.santander.banco811.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.santander.banco811.dto.AccountRequest;
import com.santander.banco811.dto.UserRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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


    @JsonIgnore
    @OneToMany(mappedBy = "accountId", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public Account(AccountRequest accountRequest) {
        this.number = accountRequest.getNumber();
        this.agency = accountRequest.getAgency();
        this.accountType = accountRequest.getAccountType();
        this.user = accountRequest.getUser();
    }


}
