package com.project.gestion.web.dto.Request;

import com.project.gestion.data.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientSimpleCreateRequest {

    @NotBlank(message = "Name is required")
    private String nom;

    @NotBlank(message = "Tel is required")
    @Pattern(regexp = "^(77|78)[0-9]{7}", message = "Invalid phone number format")
    private String telephone;

    private String adresse;

    public Client ClientSimpleCreateToClient() {
        Client client = new Client();
        client.setNom(nom);
        client.setAdresse(adresse);
        client.setTelephone(telephone);
    
        return client;
    }

}
