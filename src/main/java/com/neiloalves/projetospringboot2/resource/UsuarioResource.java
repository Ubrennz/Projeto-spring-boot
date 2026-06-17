package com.neiloalves.projetospringboot2.resource;

import com.neiloalves.projetospringboot2.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // para falar q essa classe é um recurso web q é implementado por um controlador rest
@RequestMapping(value = "/usuarios")// nome do recurso
public class UsuarioResource {
    // metodo para ser um endpoint para acessar os usuários
    // ResponseEntity<T> q é um tipo especifico do spring para retornar respostas de requesição web
    // para indicar q esse metodo aqui q responde a requisição do tipo GET do HTTP, ai usa o @GetMapping
    @GetMapping
    public ResponseEntity<Usuario> findAll() {
        Usuario usuario = new Usuario(1L, "Brenno1", "ubrennz@gmail.com", "99999", "1234");

        // ResponseEntity.ok() para retornar reposta com sucesso no http
        // ,body() para retornar o corpo da resposta
        return ResponseEntity.ok().body(usuario);
    }
}
