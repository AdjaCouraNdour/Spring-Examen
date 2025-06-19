package com.project.gestion.web.dto.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

import com.project.gestion.data.entities.Dette;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetteCreateRequest {

    @NotBlank(message = "La date est obligatoire")
    private LocalDate date;

    @NotNull(message = "Le montant de la dette est obligatoire")
    @PositiveOrZero(message = "Le montant de la dette doit être positif ou nul")
    private Double montantDette;

    @NotNull(message = "Le montant payé est obligatoire")
    @PositiveOrZero(message = "Le montant payé doit être positif ou nul")
    private Double montantPaye;

    @NotNull(message = "Le montant restant est obligatoire")
    @PositiveOrZero(message = "Le montant restant doit être positif ou nul")
    private Double montantRestant;

    @NotNull(message = "L'id du client est obligatoire")
    private Long clientId;

    public DetteCreateRequest(Dette dette) {
        this.date = dette.getDate();
        this.montantDette = dette.getMontantDette();
        this.montantPaye = dette.getMontantPaye();
        this.montantRestant = dette.getMontantRestant();
        this.clientId = dette.getClient().getId();
    }
}
