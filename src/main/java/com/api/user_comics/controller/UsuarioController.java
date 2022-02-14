package com.api.user_comics.controller;

import com.api.user_comics.dto.Usuario.UsuarioDTO;
import com.api.user_comics.dto.Usuario.UsuarioRespostaDTO;
import com.api.user_comics.model.Usuario;
import com.api.user_comics.openfeign.MarvelConsumerFeign;
import com.api.user_comics.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/usuario")
@RestController
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final MarvelConsumerFeign comicConsumerFeign;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, MarvelConsumerFeign comicConsumerFeign) {
        this.usuarioService = usuarioService;
        this.comicConsumerFeign = comicConsumerFeign;
    }


    @PostMapping("/new")
    public ResponseEntity<UsuarioRespostaDTO> salvar(@RequestBody UsuarioDTO dto) {
        Usuario usuario = usuarioService.salvar(dto.transformaParaObjeto());
        return new ResponseEntity<>(UsuarioRespostaDTO.transformaEmDTO(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioRespostaDTO>> listUsuario(){
        List<Usuario> usuarios = usuarioService.findAll();
        return new ResponseEntity<>(UsuarioRespostaDTO.transformaEmListaDTO(usuarios),HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRespostaDTO> usuarioFindById(@PathVariable("id") long id){
        Usuario usuario = usuarioService.usuarioFindById(id);
        return new ResponseEntity<>(UsuarioRespostaDTO.transformaEmDTO(usuario),HttpStatus.ACCEPTED);
    }


}
