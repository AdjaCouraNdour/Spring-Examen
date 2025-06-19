package com.project.gestion.data.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.gestion.Config.Service;
import com.project.gestion.data.entities.Paiement;
import com.project.gestion.web.dto.Request.PaiementCreateRequest;

public interface PaiementService extends Service<Paiement> {
     Paiement create(PaiementCreateRequest paiement,Long detteId);
    Page<Paiement> findAllByClientId(Long clientId, Pageable pageable);
    Page<Paiement> findByClientTelephoneAndDetteId( String tel, Long detteId, Pageable pageable);}
