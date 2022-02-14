package com.api.user_comics.openfeign.MarvelObject;

import com.api.user_comics.dto.Comic.ComicDTO;


public class MarvelComicResponse{
    private DataResponse data;

    public  ComicDTO transformaParaObjetoDTO (){
        return new ComicDTO(data.getResults().get(0).getId(),
                            data.getResults().get(0).getTitle(),
                            data.getResults().get(0).getPrices().get(0).getPrice(),
                            data.getResults().get(0).getIsbn(),
                            data.getResults().get(0).getDescription(),
                            data.getResults().get(0).getThumbnail().getUrl());
    }
    public DataResponse getData() {
        return data;
    }
}
