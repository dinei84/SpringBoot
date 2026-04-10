package com.curso.mateus.Service;

import com.curso.mateus.DTO.LojasDTO;
import com.curso.mateus.Model.LojasModel;
import com.curso.mateus.Repository.LojasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LojasService {

    private final LojasRepository repository;

    public LojasService(LojasRepository repository) {
        this.repository = repository;
    }

    public LojasDTO saveLoja(LojasDTO dto) {
        LojasModel model = new LojasModel();
        model.setNome(dto.nome());
        model.setCnpj(dto.cnpj());
        model.setEndereco(dto.endereco());

        LojasModel modeloSalvo = repository.save(model);

        return new LojasDTO(modeloSalvo);
    }

    public List<LojasDTO> listarLojas() {
        List<LojasModel> lojas = repository.findAll();
        return lojas.stream().map(loja -> new LojasDTO(loja.getId(), loja.getNome(), loja.getCnpj(), loja.getEndereco())).toList();
    }

    public LojasDTO buscarLojaPorId(Long id) {
        LojasModel loja = repository.findById(id).orElseThrow(() -> new RuntimeException("Loja não encontrada"));
        return new LojasDTO(loja.getId(), loja.getNome(), loja.getCnpj(), loja.getEndereco());
    }

    public Optional<LojasDTO> atualizarLoja(Long id, LojasDTO dadosNovosDTO) {
        return repository.findById(id)
                .map(lojaBanco -> {
                    lojaBanco.setNome(dadosNovosDTO.nome());
                    lojaBanco.setCnpj(dadosNovosDTO.cnpj());
                    lojaBanco.setEndereco(dadosNovosDTO.endereco());

                    LojasModel lojaSalva = repository.save(lojaBanco);

                    return new LojasDTO(lojaSalva);
                });
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
