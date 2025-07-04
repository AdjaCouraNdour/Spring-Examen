package com.project.gestion.data.entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private Double montantDette;

    private Double montantPaye;

    private Double montantRestant;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "dette", cascade = CascadeType.ALL)
    private List<Paiement> paiements = new ArrayList<>();


}
