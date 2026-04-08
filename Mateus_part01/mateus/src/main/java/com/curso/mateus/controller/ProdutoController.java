package com.curso.mateus.controller;

import com.curso.mateus.Model.Produto;
import com.curso.mateus.Service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service){
        this.service = service;
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return service.listarProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarProduto(@PathVariable Long id){
        return service.buscarProduto(id);
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto){
        return service.salvarProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id){
        return service.atualizarProduto(id);
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Long id){
        service.excluirProduto(id);
    }

}
