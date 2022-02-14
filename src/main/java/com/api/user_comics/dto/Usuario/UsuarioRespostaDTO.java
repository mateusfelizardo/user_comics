package com.api.user_comics.dto.Usuario;

import com.api.user_comics.model.Comic;
import com.api.user_comics.model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRespostaDTO {
    private String nome;
    private String email;
    private LocalDate data;
    private List<Comic> comics;

    private UsuarioRespostaDTO(String nome, String email, LocalDate data, List<Comic> comics) {
        this.nome = nome;
        this.email = email;
        this.data = data;
        this.comics = comics;
    }

    public static List<UsuarioRespostaDTO> transformaEmListaDTO(List<Usuario> usuario) {
        List<UsuarioRespostaDTO> usuarioRespostaDTOList = new ArrayList<>();

        for (int aux = 0; aux < usuario.size(); aux++){
            usuarioRespostaDTOList.add(transformaEmDTO(usuario.get(aux)));
        }
        return usuarioRespostaDTOList;

    }
    public static UsuarioRespostaDTO transformaEmDTO(Usuario usuario) {
        return new UsuarioRespostaDTO(usuario.getNome(), usuario.getEmail(), usuario.getData(), usuario.getComics());
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
}
