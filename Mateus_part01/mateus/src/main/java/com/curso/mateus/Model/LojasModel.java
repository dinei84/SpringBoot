package com.curso.mateus.Model;

import com.curso.mateus.DTO.LojasDTO;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lojas")
@Getter
@Setter
public class LojasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnpj;
    private String endereco;
    private Double faturamento;

    public void updateFromDto(LojasDTO dto){
        this.nome = dto.nome();
        this.cnpj = dto.cnpj();
        this.endereco = dto.endereco();
    }

}
