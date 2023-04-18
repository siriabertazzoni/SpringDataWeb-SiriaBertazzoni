package it.data_web.spring_data_web.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.data_web.spring_data_web.model.Autore;

public interface AutoreRepository extends JpaRepository<Autore, Long> {
    public List<Autore> findByNomeOrCognome(String a, String b);
    // findByNomeProprietàOrNomeAltraProprietà
    // findByNomeProprietàAndNomeAltraProprietà


}
