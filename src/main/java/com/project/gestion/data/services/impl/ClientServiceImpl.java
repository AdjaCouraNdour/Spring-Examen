package com.project.gestion.data.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.gestion.data.entities.Client;
import com.project.gestion.data.repositories.ClientRepository;
import com.project.gestion.data.services.ClientService;
import com.project.gestion.utils.exceptions.EntityNotFoundExecption;
import com.project.gestion.utils.mapper.ClientMapper;
import com.project.gestion.web.dto.Request.ClientSimpleCreateRequest;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public Client create(ClientSimpleCreateRequest clientSimpleCreateRequest) {
        var existingClient = clientRepository.findByTelephone(clientSimpleCreateRequest.getTelephone());
      
        if (existingClient.isPresent()) {
            throw new EntityNotFoundExecption("Un client avec ce téléphone existe déjà");
        }

        Client etudiantCreate = clientMapper.toEntity(clientSimpleCreateRequest);
        return clientRepository.save(etudiantCreate);
    } 

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Page<Client> findAllPageable(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

}
