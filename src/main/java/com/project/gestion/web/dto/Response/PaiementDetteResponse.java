package com.project.gestion.web.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaiementDetteResponse {
  
    private Long paiementId;
    private String datePaiement;
    private double montantPaiement;

    private String dateDette;
    private double montantDette;
    private double montantPaye;
    private double montantRestant;

}
