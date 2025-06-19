package com.project.gestion.web.controllers.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.project.gestion.data.entities.Client;
import com.project.gestion.data.services.ClientService;
import com.project.gestion.web.controllers.ClientController;
import com.project.gestion.web.dto.Request.ClientSimpleCreateRequest;
import com.project.gestion.web.dto.Response.RestResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;

    @Override
    public ResponseEntity<Map<String, Object>> SelectAll(int page, int size) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> SelectdById(Long id) {


        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> Create(ClientSimpleCreateRequest client, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, Object> errors = new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            Client clientCreated = clientService.create(client);
            return new ResponseEntity<>(RestResponse.response(
                HttpStatus.CREATED, 
                clientCreated,
                "Clientcreate"),
            HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> findDetteByClientId(Long clientId, int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findDetteByClientId'");
    }

}
