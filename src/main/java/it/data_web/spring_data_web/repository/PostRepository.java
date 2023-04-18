package it.data_web.spring_data_web.repository;

import java.util.List;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.data_web.spring_data_web.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("Select p FROM Post p WHERE p.autore.nome = 'Siria'")
    List<Post> findSiria();

    @Query("Select p FROM Post p WHERE p.autore.nome = ?1")
    List<Post> findByNomeAutore(String nome);

    @Query("Select p FROM Post p WHERE p.autore.nome = :nome AND p.autore.cognome = :cognome")
    List<Post> findByNomeAndCognomeAutore(@Param("cognome")String cognome,
            @Param("nome")String nome);


}
