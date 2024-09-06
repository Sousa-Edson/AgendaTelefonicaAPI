package com.edson.AgendaTelefonicaAPI.repository;

import com.edson.AgendaTelefonicaAPI.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}

