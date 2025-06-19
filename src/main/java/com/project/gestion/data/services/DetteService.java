package com.project.gestion.data.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.gestion.Config.Service;
import com.project.gestion.data.entities.Dette;
import com.project.gestion.web.dto.Request.DetteCreateRequest;

public interface DetteService extends Service<Dette> {

    Dette create(DetteCreateRequest object,Long clientId) ;
    Page<Dette> findAllByClientId(Long clientId, Pageable pageable);
}
