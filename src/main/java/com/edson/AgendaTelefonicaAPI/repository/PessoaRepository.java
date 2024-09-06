package com.edson.AgendaTelefonicaAPI.repository;

import com.edson.AgendaTelefonicaAPI.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
