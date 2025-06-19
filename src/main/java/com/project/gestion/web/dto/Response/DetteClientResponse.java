package com.project.gestion.web.dto.Response;
import java.util.List;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetteClientResponse {
    private Long id;

    private String date;
    private double montantDette;
    private double montantPaye;
    private double montantRestant;

    private String clientNom;
    private String clientTelephone;
    private String clientAdresse;
}
