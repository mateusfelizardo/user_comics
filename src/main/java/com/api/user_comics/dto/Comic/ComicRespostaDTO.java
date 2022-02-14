package com.api.user_comics.dto.Comic;

import com.api.user_comics.model.Comic;

import java.util.ArrayList;
import java.util.List;

public class ComicRespostaDTO {

    private Long id;
    private String titulo;
    private double preco;
    private String isbn;
    private String descricao;
    private String url_imagem;
    private boolean desconto;

    public static ComicRespostaDTO tranformaEmDTO(Comic comic){

        return new ComicRespostaDTO(comic.getId(),
                                    comic.getTitulo(),comic.getPreco(),
                                    comic.getIsbn(),comic.getDescricao(),
                                    comic.getUrl_imagem(),
                                    comic.isDesconto(comic.getIsbn()));
    }

    public static List<ComicRespostaDTO> tranformaEmListaDTO(List<Comic> comics){

        List<ComicRespostaDTO> comicRespostaDTOList = new ArrayList<>();

        for (int aux = 0; aux < comics.size(); aux++){
            comicRespostaDTOList.add(tranformaEmDTO(comics.get(aux)));
        }
        return comicRespostaDTOList;
    }

    private ComicRespostaDTO(Long id, String titulo, double preco, String isbn, String descricao,String url_imagem, boolean desconto) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.isbn = isbn;
        this.descricao = descricao;
        this.desconto = desconto;
        this.url_imagem = url_imagem;
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

    public boolean isDesconto() {
        return desconto;
    }
}
