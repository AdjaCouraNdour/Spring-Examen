package com.project.gestion.data.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.gestion.data.entities.Client;
import com.project.gestion.data.entities.Dette;
import com.project.gestion.data.repositories.ClientRepository;
import com.project.gestion.data.repositories.DetteRepository;
import com.project.gestion.data.services.DetteService;
import com.project.gestion.utils.exceptions.EntityNotFoundExecption;
import com.project.gestion.utils.mapper.DetteMapper;
import com.project.gestion.web.dto.Request.DetteCreateRequest;
import com.project.gestion.web.dto.Response.DetteClientResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DetteServiceImpl implements DetteService {

    private final DetteRepository detteRepository;
    private final ClientRepository clientRepository;
    private final DetteMapper detteMapper;

    @Override
    public Dette create(DetteCreateRequest request, Long clientId) {
        Client existingClient = clientRepository.findById(clientId).orElse(null);
        if (existingClient == null) {
            throw new EntityNotFoundExecption("Aucun client trouvé avec cet ID");
        }
        Dette dette = detteMapper.toEntity(request);
        dette.setClient(existingClient);
        dette.setMontantRestant(dette.getMontantDette() - dette.getMontantPaye());
        return detteRepository.save(dette);
    }


    @Override
    public Dette findById(Long id) {
       return detteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dette> findAll() {
      return detteRepository.findAll();
    }

    @Override
    public Page<Dette> findAllPageable(Pageable pageable) {
       return detteRepository.findAll(pageable);
    }

    @Override
    public Page<DetteClientResponse> findAllByClientId(Long clientId, Pageable pageable) {
        Page<Dette> dettes = detteRepository.findByClientId(clientId, pageable);

        return dettes.map(e -> {
            DetteClientResponse dto = new DetteClientResponse();
            dto.setId(e.getId());
            dto.setDate(e.getDate().toString());
            dto.setMontantDette(e.getMontantDette());
            dto.setMontantPaye(e.getMontantPaye());
            dto.setMontantRestant(e.getMontantRestant());

            clientRepository.findById(e.getClient().getId()).ifPresent(u -> {
                dto.setNom(u.getNom());
                dto.setTelephone(u.getTelephone());
                dto.setAdresse(u.getAdresse());
            });

            return dto;
        });
    }




}
