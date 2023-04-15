package it.data_web.spring_data_web.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autori")
public class Autore {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(name = "nome", length = 100, nullable = false)
     private String nome;

     @Column(name = "cognome", length = 100, nullable = false)
     private String cognome;

     @Column(name = "email", length = 100, nullable = false)
     private String email;

     @OneToMany(mappedBy = "autore")
     private List<Post> p = new ArrayList<Post>();

     public Autore() {
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getNome() {
          return nome;
     }

     public void setNome(String nome) {
          this.nome = nome;
     }

     public String getCognome() {
          return cognome;
     }

     public void setCognome(String cognome) {
          this.cognome = cognome;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     

     
}
