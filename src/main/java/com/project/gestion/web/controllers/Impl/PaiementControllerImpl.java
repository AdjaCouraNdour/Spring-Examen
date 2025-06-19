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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.gestion.data.entities.Paiement;
import com.project.gestion.data.services.PaiementService;
import com.project.gestion.utils.mapper.PaiementMapper;
import com.project.gestion.web.controllers.PaiementController;
import com.project.gestion.web.dto.Request.PaiementCreateRequest;
import com.project.gestion.web.dto.Response.PaiementDetteResponse;
import com.project.gestion.web.dto.Response.RestResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/paiement")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class PaiementControllerImpl implements PaiementController {

    private final PaiementService paiementService;
    private final PaiementMapper paiementMapper;

    @Override
    public ResponseEntity<Map<String, Object>> SelectAll(int page, int size) {
        // À implémenter : récupération paginée des paiements
        throw new UnsupportedOperationException("Unimplemented method 'SelectAll'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> SelectdById(Long id) {
        // À implémenter : récupération paiement par ID
        throw new UnsupportedOperationException("Unimplemented method 'SelectdById'");
    }

    @Override
    public ResponseEntity<Map<String, Object>> Create(@Valid PaiementCreateRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, Object> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
            );
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            Paiement createdPaiement = paiementService.create(request, request.getDetteId());
            return new ResponseEntity<>(
                RestResponse.response(
                    HttpStatus.CREATED,
                    createdPaiement,
                    "Paiement créé"
                ),
                HttpStatus.CREATED
            );
        }
    }
        @Override
        public ResponseEntity<Map<String, Object>> findAllPaiementByDetteIdAndTelephone(Long detteId, String tel, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Paiement> paiementsPage = paiementService.findByClientTelephoneAndDetteId(tel, detteId, pageable);
        Page<PaiementDetteResponse> response = paiementsPage.map(paiementMapper::toDto);

        return new ResponseEntity<>(
                RestResponse.response(
                HttpStatus.OK,
                response,
                "Liste des paiements filtrée par dette et téléphone"
                ),
                HttpStatus.OK
        );
        }


   

}
