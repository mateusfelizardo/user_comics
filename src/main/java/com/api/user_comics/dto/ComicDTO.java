package com.api.user_comics.dto;


import com.api.user_comics.model.Comic;


public class ComicDTO {

    private Long id_comic;
    private String titulo;
    private double preco;
    private String isbn;
    private String descricao;
    private String url_imagem;

    public Comic transformaParaObjeto(){
        return new Comic(id_comic,titulo,preco,isbn,descricao,url_imagem);
    }

    public Long getId_comic() {
        return id_comic;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPreco() {
        return preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrl_imagem() {
        return url_imagem;
    }
}
