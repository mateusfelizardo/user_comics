package com.api.user_comics.dto.Comic;
import com.api.user_comics.model.Comic;


public class ComicDTO {

    private Long id;
    private String titulo;
    private double preco;
    private String isbn;
    private String descricao;
    private String url_imagem;

    public ComicDTO(Long id, String titulo, double preco, String isbn, String descricao, String url_imagem) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.isbn = isbn;
        this.descricao = descricao;
        this.url_imagem = url_imagem;
    }

    public Comic transformaParaObjeto(){
        return new Comic(id,titulo,preco,isbn,descricao,url_imagem);
    }

    public Long getId() {
        return id;
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
