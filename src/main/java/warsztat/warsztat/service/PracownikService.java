package warsztat.warsztat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import warsztat.warsztat.model.Pracownik;
import warsztat.warsztat.repository.PracownikRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PracownikService {

    @Autowired
    private PracownikRepository pracownikRepository;

    public void add (Pracownik pracownik){

        pracownikRepository.save(pracownik);
    }

    public List<Pracownik> getBazaDanych (){

        return pracownikRepository.findAll();
    }

    public Optional<Pracownik> findPracownik (Long id){

        return pracownikRepository.findById(id);
    }

    public void deleteById (Long studentIdentifier){
        pracownikRepository.deleteById(studentIdentifier);
    }


    }


