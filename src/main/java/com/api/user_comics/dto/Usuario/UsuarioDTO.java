package com.api.user_comics.dto.Usuario;

import com.api.user_comics.model.Comic;
import com.api.user_comics.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public class UsuarioDTO {

    private String nome;
    private String email;
    private String cpf;
    private LocalDate data;
    private List<Comic> comics;


    public Usuario transformaParaObjeto(){
        return new Usuario(nome, email, cpf, data, comics);
    }
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getData() {
        return data;
    }

    public List<Comic> getComics() {
        return comics;
    }

    public String getCpf() {
        return cpf;
    }
}
