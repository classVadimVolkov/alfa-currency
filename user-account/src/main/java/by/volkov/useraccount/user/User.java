package by.volkov.useraccount.user;

import by.volkov.useraccount.account.model.Account;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1)
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(unique = true)
    String email;

    @Column(unique = true)
    String login;

    @Column
    String password;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    Role role;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    List<Account> accounts = new ArrayList<>();
}
