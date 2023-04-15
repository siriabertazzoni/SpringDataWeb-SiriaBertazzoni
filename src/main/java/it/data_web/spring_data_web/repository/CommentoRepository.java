package it.data_web.spring_data_web.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.data_web.spring_data_web.model.Commento;

public interface CommentoRepository extends  JpaRepository<Commento, Long> {
    // public List<Commento> findByContains(String s);
    // findByNomeProprietà

    //* insert -> void   update -> int   delete -> int*/

    @Modifying
    @Query("DELETE FROM Commento c WHERE c.email LIKE 'ele'")
    void deleteEle();
}
