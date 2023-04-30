package by.volkov.useraccount.account.entity;

import by.volkov.useraccount.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_gen")
    @SequenceGenerator(name = "account_gen", sequenceName = "account_seq", allocationSize = 1)
    private Long id;

    @Column
    private BigDecimal balance = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
