package com.edson.AgendaTelefonicaAPI.mapper;

import com.edson.AgendaTelefonicaAPI.dto.TelefoneDTO;
import com.edson.AgendaTelefonicaAPI.model.Telefone;
import org.springframework.stereotype.Component;

@Component
public class TelefoneMapper {

    // Converte Telefone para TelefoneDTO
    public TelefoneDTO toDTO(Telefone telefone) {
        TelefoneDTO dto = new TelefoneDTO();
        dto.setId(telefone.getId()); // Inclui o ID
        dto.setNumero(telefone.getNumero()); // Mapeia o número de telefone
        return dto;
    }

    // Converte TelefoneDTO para Telefone
    public Telefone toEntity(TelefoneDTO telefoneDTO) {
        Telefone telefone = new Telefone();

        // Inclui o ID na conversão para a entidade, para operações de atualização
        telefone.setId(telefoneDTO.getId());
        telefone.setNumero(telefoneDTO.getNumero()); // Mapeia o número de telefone

        return telefone;
    }
}
