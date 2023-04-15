package it.data_web.spring_data_web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.data_web.spring_data_web.model.Autore;
import it.data_web.spring_data_web.repository.AutoreRepository;

@Controller
@RequestMapping(value = "autori")
public class AutoreController {
    @Autowired
    private AutoreRepository autoreRepository;

    @GetMapping
    public @ResponseBody List<Autore> getAll(){
        return autoreRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Autore post(@RequestBody Autore autore){
        return autoreRepository.save(autore);
    }

    // @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
     @DeleteMapping("{id}")
    public @ResponseBody String delete(@PathVariable("id") Long id){
        autoreRepository.deleteById(id);;
        return "OK";
    }

    @PutMapping("{id}")
    public @ResponseBody String put(@PathVariable("id") Long id, @RequestBody Autore autore) throws Exception{
        Optional<Autore> dbOptionalAutore = autoreRepository.findById(id);
        if(dbOptionalAutore.isPresent()){
            Autore dbAutore = dbOptionalAutore.get();
            dbAutore.setNome(autore.getNome());
            dbAutore.setCognome(autore.getCognome());
            dbAutore.setEmail(autore.getEmail());
            autoreRepository.save(dbAutore);
            return "OK";
        }
        throw new Exception();
    }
}
