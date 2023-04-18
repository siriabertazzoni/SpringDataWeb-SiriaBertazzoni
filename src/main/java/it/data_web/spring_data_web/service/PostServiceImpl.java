package it.data_web.spring_data_web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import it.data_web.spring_data_web.dto.CreatePostDTO;
import it.data_web.spring_data_web.dto.PostDTO;
import it.data_web.spring_data_web.model.Autore;
import it.data_web.spring_data_web.model.Post;
import it.data_web.spring_data_web.repository.AutoreRepository;
import it.data_web.spring_data_web.repository.PostRepository;
import it.data_web.spring_data_web.util.exception.AutoreNotFound;

public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PostDTO> readAll() {
        List<PostDTO> dtos = new ArrayList<PostDTO>();

        for(Post p: postRepository.findAll()) {
            dtos.add(modelMapper.map(p, PostDTO.class));
        }

        return dtos;
    }

    @Override
    public PostDTO create(CreatePostDTO createPostDTO) throws Exception {
        Post p = modelMapper.map(createPostDTO, Post.class);
        postRepository.save(p);
        Optional<Autore> optionalAutore = autoreRepository.findById(createPostDTO.getAutoriId());
        if (optionalAutore.isPresent()) {
            p.setAutore(optionalAutore.get());
            return modelMapper.map(p, PostDTO.class);
        }
        throw new AutoreNotFound();
    }

}
