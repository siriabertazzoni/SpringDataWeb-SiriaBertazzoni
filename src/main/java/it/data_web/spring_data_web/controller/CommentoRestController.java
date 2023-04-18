package it.data_web.spring_data_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.data_web.spring_data_web.model.Commento;
import it.data_web.spring_data_web.repository.CommentoRepository;

@RestController
@RequestMapping(value = "api/comments")
public class CommentoRestController {
    @Autowired
    private CommentoRepository commentoRepository;

    @GetMapping
    public List<Commento> getAll(){
        return commentoRepository.findAll();
    }
}
