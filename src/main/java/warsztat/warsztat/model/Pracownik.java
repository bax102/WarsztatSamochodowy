package warsztat.warsztat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pracownik {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String imie;
    private String nazwisko;
    private boolean czyPije;
    private int wiek;

    @OneToMany (fetch = FetchType.EAGER, mappedBy = "pracownik")
    private List<Wyplata> listaPlac;

    }
