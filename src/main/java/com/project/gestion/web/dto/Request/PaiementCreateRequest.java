package com.project.gestion.web.dto.Request;

import java.time.LocalDate;

import com.project.gestion.data.entities.Paiement;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaiementCreateRequest {

    @NotBlank(message = "La date est obligatoire")
    private LocalDate date;

    @NotNull(message = "Le montant est obligatoire")
    @PositiveOrZero(message = "Le montant doit être positif ou nul")
    private Double montant;

    @NotNull(message = "L'identifiant de la dette est obligatoire")
    private Long detteId;
   
    public PaiementCreateRequest(Paiement paiement) {
        this.date = paiement.getDate();
        this.montant = paiement.getMontant();
        this.detteId = paiement.getDette().getId();
    }
}
