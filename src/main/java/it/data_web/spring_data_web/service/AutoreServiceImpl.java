package it.data_web.spring_data_web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.data_web.spring_data_web.dto.AutoreDTO;
import it.data_web.spring_data_web.model.Autore;
import it.data_web.spring_data_web.model.Post;
import it.data_web.spring_data_web.repository.AutoreRepository;
import it.data_web.spring_data_web.repository.PostRepository;
import it.data_web.spring_data_web.util.exception.AutoreBadRequest;
import it.data_web.spring_data_web.util.exception.AutoreNotFound;


@Service
public class AutoreServiceImpl implements AutoreService {
    
    @Autowired
    AutoreRepository autoreRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    @Transactional
    public void transaction(){
        Autore a = new Autore();
        a.setNome("null");
        a.setCognome("null");
        a.setEmail("null");

        a = autoreRepository.save(a);


		Post p1 = new Post();
		p1.setAutore(a);
		p1.setBody("Ciao");
		p1.setTitle("Ciao ciao");
		p1.setPublishDate("12345678");

		postRepository.save(p1);

		Post p2 = new Post();
		p2.setAutore(a);
		p2.setBody("ciao 2");
		p2.setPublishDate("18042023");

		postRepository.save(p2);

    }

    @Override
    public void noTransaction(){
        Autore a = new Autore();
        a.setNome("null");
        a.setCognome("null");
        a.setEmail("null");

        a = autoreRepository.save(a);


		Post p1 = new Post();
		p1.setAutore(a);
		p1.setBody("Ciao");
		p1.setTitle("Ciao ciao");
		p1.setPublishDate("12345678");

		postRepository.save(p1);

		Post p2 = new Post();
		p2.setAutore(a);
		p2.setBody("ciao 2");
		p2.setPublishDate("18042023");

		postRepository.save(p2);

    }

    @Override
	public List<AutoreDTO> readAll() {
		List<AutoreDTO> dtos = new ArrayList<AutoreDTO>();

		for (Autore autore: autoreRepository.findAll()) {
			dtos.add(modelMapper.map(autore, AutoreDTO.class));
		}

		return dtos;
	}

	@Override
	public List<AutoreDTO> read(String nome, String cognome) {
		List<AutoreDTO> dtos = new ArrayList<AutoreDTO>();
		List<Autore> autori;

        if (nome != null && cognome != null) {
            autori = autoreRepository.findByNomeOrCognome(nome, cognome);
        } else
            autori = autoreRepository.findAll();
        
	


		for (Autore autore: autori) {
			dtos.add(modelMapper.map(autore, AutoreDTO.class));
		}

		return dtos;
	}



    @Override
	public AutoreDTO readOne(Long id) throws Exception {
		Optional<Autore> optionalAutore = autoreRepository.findById(id);
        if (optionalAutore.isPresent()) {
            return modelMapper.map(optionalAutore.get(), AutoreDTO.class);
        }
        throw new AutoreNotFound();
	}

    @Override
	public AutoreDTO create(Autore autore) throws Exception {
		// Validation
		if (autore.getNome() == null || autore.getCognome() == null || autore.getEmail() == null) {
			if (autore.getNome() == null)
				throw new AutoreBadRequest("Nome is required");
			if (autore.getCognome() == null)
				throw new AutoreBadRequest("Cognome is required");
			if (autore.getEmail() == null)
				throw new AutoreBadRequest("Email is required");
		}
		return modelMapper.map(autoreRepository.save(autore), AutoreDTO.class);
	}

	@Override
	public AutoreDTO update(Long id, Autore autore) throws Exception {
        Optional<Autore> dbOptionalAutore = autoreRepository.findById(id);
        if (dbOptionalAutore.isPresent()) {
            Autore dbAutore = dbOptionalAutore.get();
            dbAutore.setNome(autore.getNome());
            dbAutore.setCognome(autore.getCognome());
            dbAutore.setEmail(autore.getEmail());
            autoreRepository.save(dbAutore);
            return modelMapper.map(dbAutore, AutoreDTO.class);
        }
        throw new AutoreNotFound();
	}

	@Override
	public String delete(Long id) throws Exception {
		if (autoreRepository.findById(id).isPresent()) {
			autoreRepository.deleteById(id);
			return "OK";
		}
        throw new AutoreNotFound();
	}



}
