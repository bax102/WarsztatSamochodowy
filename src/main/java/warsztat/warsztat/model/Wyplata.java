package warsztat.warsztat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Wyplata {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Funkcja Funkcja;

    private double wysokoscWyplaty;

    @CreationTimestamp
    private LocalDateTime dataDodania;

    @ManyToOne()
    private Pracownik pracownik;

    public Wyplata (Funkcja funkcja, double wysokoscWyplaty){
        this.Funkcja = funkcja;
        this.wysokoscWyplaty = wysokoscWyplaty;
    }
}
