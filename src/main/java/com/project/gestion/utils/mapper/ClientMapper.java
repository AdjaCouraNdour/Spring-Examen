package com.project.gestion.utils.mapper;

import org.mapstruct.Mapper;
import com.project.gestion.data.entities.Client;
import com.project.gestion.web.dto.Request.ClientSimpleCreateRequest;
import com.project.gestion.web.dto.Response.ClientDetteResponse;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDetteResponse toDtoClientDette (Client client);

    Client toEntity(ClientSimpleCreateRequest client);

   
    

}
