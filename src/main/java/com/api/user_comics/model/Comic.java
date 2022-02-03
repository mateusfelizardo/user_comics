package com.api.user_comics.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_Comic")
public class Comic {

    @Id
    private Long id_comic;

    @NotBlank
    private String titulo;

    private double preco;

    @NotBlank
    private String isbn;

    @Lob
    private String descricao;

    private String url_imagem;

    public Long getId_comic() {
        return id_comic;
    }

    public Comic(Long id_comic, String titulo, double preco, String isbn, String descricao, String url_imagem) {
        this.id_comic = id_comic;
        this.titulo = titulo;
        this.preco = preco;
        this.isbn = isbn;
        this.descricao = descricao;
        this.url_imagem = url_imagem;
    }

    public Comic() {}


    public boolean isDesconto(String isbn){
        return true;
    }


    public void setId_comic(Long id_comic) {
        this.id_comic = id_comic;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl_imagem() {
        return url_imagem;
    }

    public void setUrl_imagem(String url_imagem) {
        this.url_imagem = url_imagem;
    }
}
