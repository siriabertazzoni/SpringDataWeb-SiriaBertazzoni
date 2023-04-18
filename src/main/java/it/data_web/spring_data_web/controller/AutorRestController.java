package it.data_web.spring_data_web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import it.data_web.spring_data_web.dto.AutoreDTO;
import it.data_web.spring_data_web.model.Autore;
import it.data_web.spring_data_web.service.AutoreService;

public class AutorRestController {
    @Autowired
    private AutoreService autoreService;

    @GetMapping
    public List<AutoreDTO> getAll(
        @RequestParam(name = "nome", required = false) String nome,
        @RequestParam(name = "cognome", required = false) String cognome
    ){
        return autoreService.read(nome, cognome);
    }

    @GetMapping("{id}")
    public AutoreDTO getOne(
        @PathVariable("id") Long id
    ) throws Exception{
        return autoreService.readOne(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public AutoreDTO post(@RequestBody Autore autore) throws Exception {
        return autoreService.create(autore);
    }

    @PutMapping("{id}")
    public AutoreDTO put(@PathVariable("id") Long id, @RequestBody Autore autore) throws Exception {
        return autoreService.update(id, autore);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id) throws Exception {
        return autoreService.delete(id);
    }



}
