package com.api.user_comics.controller;

import com.api.user_comics.dto.ComicDTO;
import com.api.user_comics.dto.ComicRespostaDTO;
import com.api.user_comics.model.Comic;
import com.api.user_comics.model.Usuario;
import com.api.user_comics.service.ComicService;
import org.apache.coyote.Response;
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

    @Autowired
    public ComicController(ComicService comicService) {
        this.comicService = comicService;
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

        Comic comic = comicService.comicFindById(id);

        return new ResponseEntity<>(ComicRespostaDTO.tranformaEmDTO(comic),HttpStatus.ACCEPTED);

    }
}
