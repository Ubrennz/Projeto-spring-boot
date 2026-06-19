package com.neiloalves.projetospringboot2.resource;

import com.neiloalves.projetospringboot2.model.Usuario;
import com.neiloalves.projetospringboot2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // para falar q essa classe é um recurso web q é implementado por um controlador rest
@RequestMapping(value = "/usuarios")// nome do recurso
public class UsuarioResource {
    @Autowired
    private  UsuarioService usuarioService;

    // metodo para ser um endpoint para acessar os usuários
    // ResponseEntity<T> q é um tipo especifico do spring para retornar respostas de requesição web
    // para indicar q esse metodo aqui q responde a requisição do tipo GET do HTTP, ai usa o @GetMapping
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = usuarioService.findAll();

        // ResponseEntity.ok() para retornar reposta com sucesso no http
        // ,body() para retornar o corpo da resposta
        return ResponseEntity.ok().body(usuarios);
    }

    // endpoint para pegar o usuario pelo id
    @GetMapping(value = "{id}") // aqui fala q vai aceitar um id dentro da URL
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        // para receber o id dentro do endpoint do controlador rest,
        // eu tenho q declarar aqui um argumento, q seria o Long id,
        // só q pra spring aceitar esse id e considerar ele como parametro
        // q vai chegar da URl, tem q colocar na frente o @PathVariable
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }
}
