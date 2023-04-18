package it.data_web.spring_data_web.service;

import java.util.List;

import it.data_web.spring_data_web.dto.AutoreDTO;
import it.data_web.spring_data_web.model.Autore;

public interface AutoreService {
    List<AutoreDTO> readAll();
    List<AutoreDTO> read(String nome, String cognome);
    AutoreDTO readOne(Long id) throws Exception;
    AutoreDTO create(Autore autore) throws Exception;
    AutoreDTO update(Long id, Autore autore) throws Exception;
    String delete(Long id) throws Exception;

    
    void transaction();
    void noTransaction();

}
