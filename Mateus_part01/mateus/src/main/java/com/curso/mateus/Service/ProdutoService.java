package com.curso.mateus.Service;

import java.util.List;
import java.util.Optional;

import com.curso.mateus.exceptions.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;

import com.curso.mateus.Model.Produto;
import com.curso.mateus.Repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }

    public List<Produto> listarProdutos(){
        return repository.findAll();
    }

    public Produto buscarProduto(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com id " + id + " nao encontrado"));
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
        if(repository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com id " + id + ", não encontrado");
        }
        repository.deleteById(id);
    }

}
