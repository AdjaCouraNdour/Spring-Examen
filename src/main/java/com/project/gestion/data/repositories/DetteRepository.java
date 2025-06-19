package com.project.gestion.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.gestion.data.entities.Dette;
import com.project.gestion.web.dto.Request.DetteCreateRequest;

public interface DetteRepository extends JpaRepository<Dette, Long> {

    Dette save(DetteCreateRequest object);
    Page<Dette> findByClientId(Long clientId, Pageable pageable);
    Page<Dette> findByClientTelephone(String telephone, Pageable pageable);

}
