package com.curso.mateus.controller;

import com.curso.mateus.DTO.LojasDTO;
import com.curso.mateus.Service.LojasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lojas")
public class LojasController {

    private final LojasService service;

    public LojasController(LojasService service) {
        this.service = service;
    }

    @GetMapping
    public List<LojasDTO> listarLojas() {
        return service.listarLojas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LojasDTO> buscarLojaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarLojaPorId(id));
    }

    @PostMapping
    public LojasDTO salvarLoja(@RequestBody LojasDTO loja) {
        return service.saveLoja(loja);
    }

}
