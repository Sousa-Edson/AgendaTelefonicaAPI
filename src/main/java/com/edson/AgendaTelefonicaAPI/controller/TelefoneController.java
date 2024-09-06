package com.edson.AgendaTelefonicaAPI.controller;

import com.edson.AgendaTelefonicaAPI.dto.TelefoneDTO;
import com.edson.AgendaTelefonicaAPI.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/telefones")
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping
    public List<TelefoneDTO> getAllTelefones() {
        return telefoneService.getAllTelefones();
    }

    @PostMapping
    public ResponseEntity<TelefoneDTO> createTelefone(@RequestBody TelefoneDTO telefoneDTO) {
        TelefoneDTO newTelefone = telefoneService.createTelefone(telefoneDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTelefone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelefone(@PathVariable Long id) {
        telefoneService.deleteTelefone(id);
        return ResponseEntity.noContent().build();
    }
}
