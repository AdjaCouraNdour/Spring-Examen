package com.project.gestion.utils.mapper;

import org.mapstruct.Mapper;

import com.project.gestion.data.entities.Paiement;
import com.project.gestion.web.dto.Request.PaiementCreateRequest;
import com.project.gestion.web.dto.Response.PaiementDetteResponse;

@Mapper(componentModel = "spring")
public interface PaiementMapper {


    PaiementDetteResponse toDto (Paiement Paiement);

    Paiement toEntity(PaiementCreateRequest Paiement);

  
}
