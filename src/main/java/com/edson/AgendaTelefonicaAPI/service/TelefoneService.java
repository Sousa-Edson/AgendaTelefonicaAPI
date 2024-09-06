package com.edson.AgendaTelefonicaAPI.service;
import com.edson.AgendaTelefonicaAPI.dto.TelefoneDTO;
import com.edson.AgendaTelefonicaAPI.exception.NotFoundException;
import com.edson.AgendaTelefonicaAPI.mapper.TelefoneMapper;
import com.edson.AgendaTelefonicaAPI.model.Telefone;
import com.edson.AgendaTelefonicaAPI.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private TelefoneMapper telefoneMapper;

    public List<TelefoneDTO> getAllTelefones() {
        List<Telefone> telefones = telefoneRepository.findAll();
        return telefones.stream().map(telefoneMapper::toDTO).collect(Collectors.toList());
    }

    public TelefoneDTO createTelefone(TelefoneDTO telefoneDTO) {
        Telefone telefone = telefoneMapper.toEntity(telefoneDTO);
        Telefone savedTelefone = telefoneRepository.save(telefone);
        return telefoneMapper.toDTO(savedTelefone);
    }

    public void deleteTelefone(Long id) {
        Telefone telefone = telefoneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Telefone não encontrado com o id " + id));
        telefoneRepository.delete(telefone);
    }
}
