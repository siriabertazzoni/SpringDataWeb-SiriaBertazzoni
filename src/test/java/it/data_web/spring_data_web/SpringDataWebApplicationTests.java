package it.data_web.spring_data_web;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import it.data_web.spring_data_web.model.Autore;
import it.data_web.spring_data_web.model.Commento;
import it.data_web.spring_data_web.model.Post;
import it.data_web.spring_data_web.repository.AutoreRepository;
import it.data_web.spring_data_web.repository.CommentoRepository;
import it.data_web.spring_data_web.repository.PostRepository;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class SpringDataWebApplicationTests {
	
	@Autowired
	AutoreRepository autoreRepository;

	@Autowired
	CommentoRepository commentoRepository;

	@Autowired
	PostRepository postRepository;

	@BeforeEach
	public void createData(){

		Autore a = new Autore();
		a.setNome("Siria");
		a.setCognome("Bertazzoni");
		a.setEmail("siria@siria.it");

		autoreRepository.save(a);

		Autore b = new Autore();
		b.setNome("Nate");
		b.setCognome("Val");
		b.setEmail("nate@nate.it");

		autoreRepository.save(b);

		Autore c = new Autore();
		c.setNome("Siria");
		c.setCognome("Teodori");
		c.setEmail("siriaT@siria.it");
		
		autoreRepository.save(c);

		Post p1 = new Post();
		p1.setAutore(a);
		p1.setTitle("Il mio cane si chiama Numa");
		p1.setBody("Numa cana bianca");
		p1.setPublishDate("11042023");

		postRepository.save(p1);

		
		Post p2 = new Post();
		p2.setAutore(b);
		p2.setTitle("Il mio cane si chiama Oscar");
		p2.setBody("Oscar cane marrone");
		p2.setPublishDate("12042023");
		
		postRepository.save(p2);
		
		Post p3 = new Post();
		p3.setAutore(c);
		p3.setTitle("Il mio cane si chiama Numa");
		p3.setBody("Numa cana bianca");
		p3.setPublishDate("11042023");

		postRepository.save(p3);

		Commento c1 = new Commento();
		c1.setEmail("fra@fra.it");
		c1.setPost(p1);
		c1.setBody("L'amore della zia");
		c1.setDate("13042023");

		Commento c2 = new Commento();
		c2.setEmail("giorgia@giorgia.it");
		c2.setPost(p2);
		c2.setBody("Oscar bellone! Da migliorare la sintassi del post");
		c2.setDate("13042023");

		Commento c3 = new Commento();
		c3.setEmail("ele@ele.it");
		c3.setPost(p1);
		c3.setBody("Non vedo l'ora di conoscerla");
		c3.setDate("13042023");

		List<Commento> listaCommenti = new ArrayList<Commento>();
		listaCommenti.add(c1);
		listaCommenti.add(c2);
		listaCommenti.add(c3);
		commentoRepository.saveAll(listaCommenti);
	}

	@Test
	void customQuery() {
		
		// cerca tutti i post con l'autore di nome Mirko
		List<Post> posts = postRepository.findSiria();
		// controlla che il post sia 1
		assertThat(posts).hasSize(1);
		// estrai il campo autore, estrai da autore la proprietà nome
		assertThat(posts.get(0))
			.extracting("autore")
			.extracting("nome")
			.isEqualTo("Siria");
	}

	@Test
	void customQuery2(){
		List<Post> posts = postRepository.findByNomeAutore("Siria");
		assertThat(posts).hasSize(2);
		assertThat(posts)
			.extracting("autore")
			.extracting("nome")
			.contains("Siria", "Siria");
	}

	@Test
	void customQuery3(){
		List<Post> posts = postRepository.findByNomeAndCognomeAutore("Val", "Nate");
		assertThat(posts).hasSize(1);

		assertThat(posts.get(0))
			.extracting("autore")
			.extracting("nome")
			.isEqualTo("Nate");

		assertThat(posts.get(0))
			.extracting("autore")
			.extracting("cognome")
			.isEqualTo("Val");
	}

	@Test
	void customQuery4(){
		assertThat(commentoRepository.count()).isEqualTo(3);
		commentoRepository.deleteEle();
		assertThat(commentoRepository.count()).isEqualTo(3);

	}








}
