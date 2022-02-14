package com.api.user_comics.service;

import com.api.user_comics.model.Comic;
import com.api.user_comics.repository.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicService {

    private final ComicRepository comicRepository;

    @Autowired
    public ComicService(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    public Comic salvar(Comic comic){
        return comicRepository.save(comic);
    }

    public List<Comic> findAll(){
        return comicRepository.findAll();
    }

    public Comic comicFindById(long id){
        return comicRepository.findById(id).get();
    }
}
