package com.project.gestion.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.gestion.Config.Controller;
import com.project.gestion.data.entities.Dette;
import com.project.gestion.web.dto.Request.DetteCreateRequest;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("api/dettes")
public interface DetteController extends Controller<Dette> {

    @PostMapping("")
    ResponseEntity<Map<String, Object>> Create(@RequestBody DetteCreateRequest dette,
                        BindingResult bindingResult);

    @GetMapping("/client/{id}")
    ResponseEntity<Map<String, Object>> findAlldetteByClientId(@PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size);
}
