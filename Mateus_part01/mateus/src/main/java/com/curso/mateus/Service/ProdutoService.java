package com.curso.mateus.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.curso.mateus.Model.Produto;
import com.curso.mateus.Repository.ProdutoRepository;

import javax.swing.text.html.Option;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }

    public List<Produto> listarProdutos(){
        return repository.findAll();
    }

    public Optional<Produto> buscarProduto(Long id){
        return repository.findById(id);
    }

    public Produto salvarProduto(Produto produto){
        return repository.save(produto);
    }

    public Optional<Produto> atualizarProduto(Long id, Produto produto){
        return repository.findById(id)
                .map(produtoAtual -> {
                    produtoAtual.setNome(produto.getNome());
                    produtoAtual.setDescricao(produto.getDescricao());
                    produtoAtual.setPreco(produto.getPreco());
                    return repository.save(produtoAtual);
                });
    }

    public void excluirProduto(Long id){
        Optional<Produto> produto = buscarProduto(id);
        if(produto.isPresent()){
            repository.delete(produto.get());
        }
    }

}
