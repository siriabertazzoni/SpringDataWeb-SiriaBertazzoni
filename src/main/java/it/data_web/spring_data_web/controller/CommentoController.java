package it.data_web.spring_data_web.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import it.data_web.spring_data_web.model.Commento;
import it.data_web.spring_data_web.repository.CommentoRepository;

@Controller
@RequestMapping(value = "commenti")
public class CommentoController {
    
    //injection repository
    @Autowired
    private CommentoRepository commentoRepository;

    @GetMapping
    public @ResponseBody List<Commento> getAll(){
        return commentoRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Commento postC(@RequestBody Commento commento){
        return commentoRepository.save(commento);
    }
}
