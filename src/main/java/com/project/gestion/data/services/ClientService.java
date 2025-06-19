package com.project.gestion.data.services;

import com.project.gestion.Config.Service;
import com.project.gestion.data.entities.Client;
import com.project.gestion.web.dto.Request.ClientSimpleCreateRequest;

public interface ClientService extends Service<Client> {
    Client create(ClientSimpleCreateRequest client) ;
}
