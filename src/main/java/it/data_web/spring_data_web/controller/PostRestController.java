package it.data_web.spring_data_web.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import it.data_web.spring_data_web.dto.CreatePostDTO;
import it.data_web.spring_data_web.dto.PostDTO;
import it.data_web.spring_data_web.model.Post;
import it.data_web.spring_data_web.repository.AutoreRepository;
import it.data_web.spring_data_web.repository.PostRepository;

public class PostRestController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<PostDTO> getAll() {
        List<PostDTO> dtos = new ArrayList<PostDTO>();

        for (Post p: postRepository.findAll()) {
            PostDTO map = modelMapper.map(p, PostDTO.class);
            dtos.add(map);
        }

        return dtos;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PostDTO post(@RequestBody CreatePostDTO createPostDto) {
        Post post = modelMapper.map(createPostDto, Post.class);
        post = postRepository.save(post);
        /*
         *
         *  Workaround fatto a lezione funziona solo se spring.jpa.open-in-view=false
         *  post = postRepository.findById(post.getId()).get();
         * 
         *  Il Workaround qui sotto funziona meglio perché mi lascia l'anti-pattern
         *  di cui facciamo uso in Jackson (spring.jpa.open-in-view), altrimenti non 
         *  vi funziona la serializzazione delle relazioni mappedBy
         *  
         */ 
        post.setAutore(autoreRepository.findById(post.getAutore().getId()).get());
        return modelMapper.map(post, PostDTO.class);
    }

}
