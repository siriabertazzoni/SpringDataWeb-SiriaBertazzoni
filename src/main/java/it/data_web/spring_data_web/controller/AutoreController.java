package it.data_web.spring_data_web.controller;

// import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;


// import it.data_web.spring_data_web.dto.AutoreDTO;
import it.data_web.spring_data_web.model.Autore;
// import it.data_web.spring_data_web.repository.AutoreRepository;
import it.data_web.spring_data_web.service.AutoreService;

@Controller
@RequestMapping(value = "autori")
public class AutoreController {
    // @Autowired
    // private AutoreRepository autoreRepository;

     @Autowired
     private AutoreService autoreService;

     @GetMapping
     public String vistaAutore(Model model){
        model.addAttribute("title", "Autori");
        model.addAttribute("autori", autoreService.readAll());
        return "autori";
     }

     @GetMapping
    public String autoriView(Model model) {
        model.addAttribute("title", "Authors");
        model.addAttribute("authors", autoreService.readAll());
        return "autori";
    }

    @GetMapping("client")
    public String authorsViewClientSide(Model model) {
        model.addAttribute("title", "Authors");
        return "autori_csr";
    }

    @GetMapping("add")
    public String authorsAddView(Model model) {
        model.addAttribute("title", "Aggiungi autore");
        model.addAttribute("pippo", new Autore());
        return "nuovoAutore";
    }

    @PostMapping("save")
    public String authorsSave(@ModelAttribute("pippo") Autore autore) throws Exception {
        autoreService.create(autore);
        return "redirect:/autori";
    }

    @GetMapping("modify/{id}")
    public String authorModify(@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("title", "Update Author");
        model.addAttribute("pluto", autoreService.readOne(id));
        return "modifyAuthor";
    }

    @PostMapping("update")
    public String authorUpdate(@ModelAttribute("pluto") Autore autore) throws Exception {
        autoreService.update(autore.getId(), autore);
        return "redirect:/authors";
    }

    @PostMapping("update/{id}")
    public String authorUpdateWithId(@PathVariable("id") Long id, @ModelAttribute("pluto") Autore autore) throws Exception {
        autoreService.update(id, autore);
        return "redirect:/authors";
    }

     
    // @GetMapping
    // public @ResponseBody List<Autore> getAll(){
    //     return autoreRepository.findAll();
    // }

    // @PostMapping
    // public @ResponseBody Autore post(@RequestBody Autore autore){
    //     return autoreRepository.save(autore);
    // }

    // // @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    //  @DeleteMapping("{id}")
    // public @ResponseBody String delete(@PathVariable("id") Long id){
    //     autoreRepository.deleteById(id);;
    //     return "OK";
    // }

    // @PutMapping("{id}")
    // public @ResponseBody String put(@PathVariable("id") Long id, @RequestBody Autore autore) throws Exception{
    //     Optional<Autore> dbOptionalAutore = autoreRepository.findById(id);
    //     if(dbOptionalAutore.isPresent()){
    //         Autore dbAutore = dbOptionalAutore.get();
    //         dbAutore.setNome(autore.getNome());
    //         dbAutore.setCognome(autore.getCognome());
    //         dbAutore.setEmail(autore.getEmail());
    //         autoreRepository.save(dbAutore);
    //         return "OK";
    //     }
    //     throw new Exception();
    // }
}
