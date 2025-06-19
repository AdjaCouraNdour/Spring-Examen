package com.project.gestion.web.dto.Response;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDetteResponse {
    private Long id;

    @Column(unique = true)
    private String tel;

    @NotBlank
    private String nom;

    @NotBlank
    private String telephone;

    @NotBlank
    private String adresse;

}
