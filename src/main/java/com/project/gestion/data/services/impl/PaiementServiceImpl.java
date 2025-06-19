package com.project.gestion.data.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.gestion.data.entities.Dette;
import com.project.gestion.data.entities.Paiement;
import com.project.gestion.data.repositories.DetteRepository;
import com.project.gestion.data.repositories.PaiementRepository;
import com.project.gestion.data.services.PaiementService;
import com.project.gestion.utils.exceptions.EntityNotFoundExecption;
import com.project.gestion.utils.mapper.PaiementMapper;
import com.project.gestion.web.dto.Request.PaiementCreateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository paiementRepository;
    private final PaiementMapper paiementMapper;
    private final DetteRepository detteRepository;
    @Override
    public Paiement create(PaiementCreateRequest request, Long detteId) {
        Dette dette = detteRepository.findById(detteId)
            .orElseThrow(() -> new EntityNotFoundExecption("Dette introuvable avec l'ID : " + detteId));

        Paiement paiement = paiementMapper.toEntity(request);

        paiement.setDette(dette);

        return paiementRepository.save(paiement);
    }


    @Override
    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }

    @Override
    public Page<Paiement> findAllPageable(Pageable pageable) {
        return paiementRepository.findAll(pageable);
    }


    @Override
    public Paiement findById(Long id) {
      return paiementRepository.findById(id)
      .orElseThrow(() -> new EntityNotFoundExecption("Paiement not found"));
    }


    @Override
    public Page<Paiement> findAllByClientId(Long clientId, Pageable pageable) {
     return paiementRepository.findByClientId(clientId, pageable);
    }


    @Override
    public Page<Paiement> findByClientTelephoneAndDetteId(String tel, Long detteId, Pageable pageable) {
       return paiementRepository.findByClientTelephoneAndDetteId(tel, detteId, pageable);
    }

    

   

}
