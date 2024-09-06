package com.edson.AgendaTelefonicaAPI.service;

import com.edson.AgendaTelefonicaAPI.dto.PessoaDTO;
import com.edson.AgendaTelefonicaAPI.exception.NotFoundException;
import com.edson.AgendaTelefonicaAPI.mapper.PessoaMapper;
import com.edson.AgendaTelefonicaAPI.model.Pessoa;
import com.edson.AgendaTelefonicaAPI.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaMapper pessoaMapper;

    public List<PessoaDTO> getAllPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas.stream().map(pessoaMapper::toDTO).collect(Collectors.toList());
    }

    public PessoaDTO getPessoaById(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada com o id " + id));
        return pessoaMapper.toDTO(pessoa);
    }

    public PessoaDTO createPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaMapper.toEntity(pessoaDTO);
        Pessoa savedPessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.toDTO(savedPessoa);
    }

    public PessoaDTO updatePessoa(Long id, PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada com o id " + id));
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setAniversario(pessoaDTO.getAniversario());
        // Atualizar outros campos e telefones se necessário
        Pessoa updatedPessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.toDTO(updatedPessoa);
    }

    public void deletePessoa(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada com o id " + id));
        pessoaRepository.delete(pessoa);
    }
}
