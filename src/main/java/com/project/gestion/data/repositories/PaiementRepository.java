package com.project.gestion.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.gestion.data.entities.Paiement;
import com.project.gestion.web.dto.Request.PaiementCreateRequest;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    
    Paiement save(PaiementCreateRequest paiement);
    Page<Paiement> findAllPageable(Pageable pageable);
    Page<Paiement> findByClientTelephoneAndDetteId( String tel, Long detteId, Pageable pageable);
    Page<Paiement> findByClientId(Long clientId, Pageable pageable);
    Page<Paiement> findByDetteId(Long detteId, Pageable pageable);
}
