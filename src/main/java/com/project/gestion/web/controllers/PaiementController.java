package com.project.gestion.web.controllers;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.gestion.Config.Controller;
import com.project.gestion.web.dto.Request.PaiementCreateRequest;

import jakarta.validation.Valid;

@RequestMapping("api/paiement")
public interface PaiementController extends Controller<PaiementCreateRequest> {

        @PostMapping("")
        ResponseEntity<Map<String, Object>> Create(@Valid @RequestBody PaiementCreateRequest paiement,
                        BindingResult bindingResult);

        @GetMapping("dette/{detteId}")
        ResponseEntity<Map<String, Object>> findAllPaiementByDetteIdAndTelephone(@PathVariable Long detteId,String tel,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "10") int size);
}
