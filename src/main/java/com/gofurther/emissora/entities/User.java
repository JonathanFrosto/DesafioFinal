package com.gofurther.emissora.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id_user")
    private Integer id;
    private String nome;
    private String email;
    private String senha;

    public User(Integer id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
