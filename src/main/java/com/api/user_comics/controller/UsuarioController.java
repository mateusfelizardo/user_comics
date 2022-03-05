package com.api.user_comics.controller;

import com.api.user_comics.dto.Usuario.UsuarioDTO;
import com.api.user_comics.dto.Usuario.UsuarioRespostaDTO;
import com.api.user_comics.error.ResourceNotFoundException;
import com.api.user_comics.error.SaveObjectException;
import com.api.user_comics.model.Usuario;
import com.api.user_comics.openfeign.MarvelConsumerFeign;
import com.api.user_comics.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(value = "api/usuario")
@RestController
@Api(value = "API Rest Usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final MarvelConsumerFeign comicConsumerFeign;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, MarvelConsumerFeign comicConsumerFeign) {
        this.usuarioService = usuarioService;
        this.comicConsumerFeign = comicConsumerFeign;
    }


    @PostMapping("/new")
    @ApiOperation(value = "Salva Usuario")
    public ResponseEntity<UsuarioRespostaDTO> salvar(@RequestBody UsuarioDTO dto) {
        try {
            Usuario usuario = usuarioService.salvar(dto.transformaParaObjeto());
            return new ResponseEntity<>(UsuarioRespostaDTO.transformaEmDTO(usuario), HttpStatus.CREATED);
        }catch (Exception e){
            throw  new SaveObjectException("Objeto User fora de padrão ou campos obrigatórios em branco OU ja cadastrados:");
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Retorna lista de Usuarios")
    public ResponseEntity<List<UsuarioRespostaDTO>> listUsuario(){
        List<Usuario> usuarios = usuarioService.findAll();
        return new ResponseEntity<>(UsuarioRespostaDTO.transformaEmListaDTO(usuarios),HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna Usuario Específico")
    public ResponseEntity<UsuarioRespostaDTO> usuarioFindById(@PathVariable("id") String id){
        try {
            Usuario usuario = usuarioService.usuarioFindById(validId(id));
            return new ResponseEntity<>(UsuarioRespostaDTO.transformaEmDTO(usuario), HttpStatus.ACCEPTED);
        }catch (Exception e){
            throw new ResourceNotFoundException("User não encontrado: id = "+id);
        }
    }

    private long validId(String id){
        return Long.parseLong(id);
    }
}
