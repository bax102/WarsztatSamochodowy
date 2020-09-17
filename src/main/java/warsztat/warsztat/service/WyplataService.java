package warsztat.warsztat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warsztat.warsztat.model.Pracownik;
import warsztat.warsztat.model.Wyplata;
import warsztat.warsztat.repository.PracownikRepository;
import warsztat.warsztat.repository.WyplataRepository;

import java.util.Optional;

@Service
public class WyplataService {

    @Autowired
    private WyplataRepository wyplataRepository;

    @Autowired
    private PracownikRepository pracownikRepository;

    public void saveWyplata (Wyplata wyplata, Long pracownikId){
        Optional<Pracownik> pracownikOptional = pracownikRepository.findById(pracownikId);
        if(pracownikOptional.isPresent()){
            Pracownik pracownik = pracownikOptional.get();
            wyplata.setPracownik(pracownik);
            wyplataRepository.save(wyplata);
        }
    }

    public Optional<Wyplata> findById(Long wyplataId){
        return wyplataRepository.findById(wyplataId);
    }

}
