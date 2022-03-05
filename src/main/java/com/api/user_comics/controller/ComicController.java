package com.api.user_comics.controller;

import com.api.user_comics.dto.Comic.ComicDTO;
import com.api.user_comics.dto.Comic.ComicRespostaDTO;
import com.api.user_comics.error.ResourceNotFoundException;
import com.api.user_comics.error.SaveObjectException;
import com.api.user_comics.model.Comic;
import com.api.user_comics.service.ComicService;
import com.api.user_comics.service.MarvelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("api/comic")
@RestController
@Api(value = "API Rest Comic")
public class ComicController {

    private final ComicService comicService;
    private final MarvelService marvelService;

    @Autowired
    public ComicController(ComicService comicService, MarvelService marvelService) {
        this.comicService = comicService;
        this.marvelService = marvelService;
    }

    @PostMapping("/new")
    @ApiOperation(value = "Salva Comic")
    public ResponseEntity<ComicRespostaDTO> salvar(@RequestBody ComicDTO dto){
        validComicDto(dto);
        Comic comic = comicService.salvar(dto.transformaParaObjeto());
        return new ResponseEntity<>(ComicRespostaDTO.tranformaEmDTO(comic),HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Retorna lista de Comics")
    public ResponseEntity<List<ComicRespostaDTO>> listComic(){
        List<Comic> comics = comicService.findAll();
        return new ResponseEntity<>(ComicRespostaDTO.tranformaEmListaDTO(comics), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Pesquisa Comic localmente e na API da Marvel e salva caso encontrada nova comic")
    public ResponseEntity<?> comicFindById(@PathVariable("id") String id){
        try{
            Comic comic = comicService.comicFindById(validId(id));

            return new ResponseEntity<>(ComicRespostaDTO.tranformaEmDTO(comic), HttpStatus.OK);

        }catch (Exception e) {
            try {
                ComicDTO comicDTO = marvelService.findById(validId(id)).transformaParaObjetoDTO();
                salvar(comicDTO);
                return new ResponseEntity<>(ComicRespostaDTO.tranformaEmDTO(comicDTO.transformaParaObjeto()), HttpStatus.CREATED);
            }catch (Exception f){
                throw new ResourceNotFoundException("Comic não encontrada: id = "+id);
            }
        }
    }
    private void validComicDto(ComicDTO comicDTO){
            if (comicDTO.getTitulo() == "" || comicDTO.getIsbn() == ""){
                throw new SaveObjectException("Objeto Comic fora de padrão ou campos obrigatórios em branco:");
        }
    }
    private long validId(String id){
            return Long.parseLong(id);
    }

}
