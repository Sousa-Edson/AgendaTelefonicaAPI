package com.edson.AgendaTelefonicaAPI.mapper;

import com.edson.AgendaTelefonicaAPI.dto.PessoaDTO;
import com.edson.AgendaTelefonicaAPI.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PessoaMapper {

    @Autowired
    private TelefoneMapper telefoneMapper;

    public PessoaDTO toDTO(Pessoa pessoa) {
        PessoaDTO dto = new PessoaDTO();
        dto.setId(pessoa.getId()); // Inclui o ID na conversão
        dto.setNome(pessoa.getNome());
        dto.setAniversario(pessoa.getAniversario());

        // Converte a lista de telefones, se não for nula
        if (pessoa.getTelefones() != null) {
            dto.setTelefones(pessoa.getTelefones().stream()
                    .map(telefoneMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public Pessoa toEntity(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaDTO.getId()); // Garante que o ID seja mantido em atualizações
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setAniversario(pessoaDTO.getAniversario());

        // Converte a lista de telefones, se não for nula
        if (pessoaDTO.getTelefones() != null) {
            pessoa.setTelefones(pessoaDTO.getTelefones().stream()
                    .map(telefoneMapper::toEntity)
                    .collect(Collectors.toList()));
        }

        return pessoa;
    }
}
