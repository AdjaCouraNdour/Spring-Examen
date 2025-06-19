package com.project.gestion.web.controllers.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.project.gestion.data.entities.Dette;
import com.project.gestion.data.services.DetteService;
import com.project.gestion.utils.mapper.DetteMapper;
import com.project.gestion.web.controllers.DetteController;
import com.project.gestion.web.dto.Request.DetteCreateRequest;
import com.project.gestion.web.dto.Response.ClientDetteResponse;
import com.project.gestion.web.dto.Response.RestResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DetteControllerImpl implements DetteController {
    
    private final DetteService detteService;
    private final DetteMapper detteMapper;
    
    @Override
    public ResponseEntity<Map<String, Object>> SelectAll(int page, int size) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> SelectdById(Long id) {
      return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> Create(DetteCreateRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, Object> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
            );
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            Dette createdDette = detteService.create(request, request.getClientId());
            return new ResponseEntity<>(
                RestResponse.response(
                    HttpStatus.CREATED,
                    createdDette, 
                    "Dettecreate"),
                HttpStatus.CREATED
            );
        }
    }


    @Override
    public ResponseEntity<Map<String, Object>> findAlldetteByClientId(Long id, int page, int size) {
       Pageable pageable = PageRequest.of(page, size);

        Page<Dette> dettesPage = detteService.findAllByClientId(id, pageable);
        Page<ClientDetteResponse> response = dettesPage.map(detteMapper::toDto);

        return new ResponseEntity<>(
                RestResponse.response(
                HttpStatus.OK,
                response,
                "Liste des dettes filtrée par dette et téléphone"
                ),
                HttpStatus.OK
        );
    }

   

}
