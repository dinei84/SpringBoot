package com.curso.mateus.Repository;

import com.curso.mateus.Model.LojasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojasRepository extends JpaRepository<LojasModel, Long> {
}
