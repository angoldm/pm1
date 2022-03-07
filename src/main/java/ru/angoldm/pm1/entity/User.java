package ru.angoldm.pm1.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")  //не дает создать таблицу "user"
public class User {

    @Id
    @SequenceGenerator(name = "userIdSeq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "login", columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String login;

    @Column(name = "name", columnDefinition = "varchar(255)", nullable = false)
    private String name;

    @Column(name = "surname", columnDefinition = "varchar(255)", nullable = false)
    private String surname;

    @Column(name = "email", columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String email;

    @Column(name = "password", columnDefinition = "varchar(255)", nullable = false)
    private String password;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
