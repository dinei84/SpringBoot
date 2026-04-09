package com.curso.mateus.Service;

import com.curso.mateus.Model.ClienteModel;
import com.curso.mateus.Repository.ClienteRepository;
import com.curso.mateus.exceptions.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public List<ClienteModel> listarClientes(){
        return repository.findAll();
    }

    public ClienteModel salvarCliente(ClienteModel cliente){
        return repository.save(cliente);
    }

    public ClienteModel buscarCliente(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente com id " + id + " nao encontrado"));
    }

    public Optional<ClienteModel> atualizarCliente(Long id, ClienteModel cliente){
        return repository.findById(id)
                .map(novoCliente -> {
                    novoCliente.setNome(cliente.getNome());
                    novoCliente.setEmail(cliente.getEmail());
                    novoCliente.setTelefone(cliente.getTelefone());
                    return repository.save(novoCliente);
                });
    }

    public void deletarCliente(Long id){
        if(!repository.existsById(id)){
            throw new RecursoNaoEncontradoException("Cliente com id " + id + " nao encontrado");
        }
        repository.deleteById(id);
    }

}
