package com.curso.mateus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.mateus.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
