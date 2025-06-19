package com.project.gestion.data.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.gestion.data.entities.Client;
import com.project.gestion.web.dto.Request.ClientSimpleCreateRequest;

public interface ClientRepository extends JpaRepository<Client, Long> {

    ClientSimpleCreateRequest save(ClientSimpleCreateRequest client);
    Page<Client> findAllPageable(Pageable pageable);
    Optional<Client> findByTelephone(String telephone);
}
