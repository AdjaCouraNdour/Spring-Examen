package com.project.gestion.utils.mapper;

import org.mapstruct.Mapper;

import com.project.gestion.data.entities.Dette;
import com.project.gestion.web.dto.Request.DetteCreateRequest;
import com.project.gestion.web.dto.Response.ClientDetteResponse;

@Mapper(componentModel = "spring")
public interface DetteMapper {


    ClientDetteResponse toDto(Dette dette);
    Dette toEntity(DetteCreateRequest Dette);

  
}
