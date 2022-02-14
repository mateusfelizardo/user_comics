package com.api.user_comics.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import  javax.validation.constraints.NotBlank;

@Entity
@Table(name="TB_Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_usuario;

    @NotBlank
    private String nome;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(unique = true)
    private String cpf;


    private LocalDate data;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="TB_Usuario_has_Comics")
    private List<Comic> comics ;

    public Usuario(String nome, String email, String cpf, LocalDate data, List<Comic> comics) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.data = data;
        this.comics = comics;
    }

    public Usuario() {}

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Comic> getComics() {
        return comics;
    }

    public void setComics(List<Comic> comics) {
        this.comics = comics;
    }
}
