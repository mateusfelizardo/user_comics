package com.api.user_comics.controller;

import com.api.user_comics.dto.Comic.ComicDTO;
import com.api.user_comics.dto.Comic.ComicRespostaDTO;
import com.api.user_comics.model.Comic;
import com.api.user_comics.service.ComicService;
import com.api.user_comics.service.MarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/comic")
@RestController
public class ComicController {

    private final ComicService comicService;
    private final MarvelService marvelService;

    @Autowired
    public ComicController(ComicService comicService, MarvelService marvelService) {
        this.comicService = comicService;
        this.marvelService = marvelService;
    }

    @PostMapping("/new")
    public ResponseEntity<ComicRespostaDTO> salvar(@RequestBody ComicDTO dto){
        Comic comic = comicService.salvar(dto.transformaParaObjeto());
        return new ResponseEntity<>(ComicRespostaDTO.tranformaEmDTO(comic),HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ComicRespostaDTO>> listComic(){
        List<Comic> comics = comicService.findAll();
        return new ResponseEntity<>(ComicRespostaDTO.tranformaEmListaDTO(comics), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComicRespostaDTO> comicFindById(@PathVariable("id") long id){
        try{
            Comic comic = comicService.comicFindById(id);

            return new ResponseEntity<>(ComicRespostaDTO.tranformaEmDTO(comic), HttpStatus.ACCEPTED);

        }catch (Exception e){

            System.out.println(e.getMessage());
            ComicDTO comicDTO = marvelService.findById(id).transformaParaObjetoDTO();
            salvar(comicDTO);
            return new ResponseEntity<>(ComicRespostaDTO.tranformaEmDTO(comicDTO.transformaParaObjeto()),HttpStatus.CREATED);
        }
    }

}
