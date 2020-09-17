package warsztat.warsztat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import warsztat.warsztat.model.Pracownik;

public interface PracownikRepository extends JpaRepository <Pracownik, Long> {
}
