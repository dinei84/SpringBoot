package com.curso.mateus.controller;

import com.curso.mateus.Model.ClienteModel;
import com.curso.mateus.Service.ClienteService;
import com.curso.mateus.exceptions.RecursoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service){
        this.service = service;
    }

    @GetMapping
    public List<ClienteModel> listarClientes(){
        return service.listarClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCliente(@PathVariable Long id){
         ClienteModel cliente = service.buscarCliente(id);
         return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ClienteModel salvarCliente(@RequestBody ClienteModel cliente){
        return service.salvarCliente(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizarCliente(@PathVariable Long id, @RequestBody ClienteModel cliente){
        return service.atualizarCliente(id, cliente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Void excluirCliente(@PathVariable Long id){
        service.deletarCliente(id);
        return null;
    }


}
