package it.data_web.spring_data_web.controller;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.data_web.spring_data_web.dto.CreatePostDTO;
import it.data_web.spring_data_web.dto.PostDTO;
import it.data_web.spring_data_web.model.Post;
import it.data_web.spring_data_web.repository.PostRepository;

// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public @ResponseBody List<PostDTO> getAll(){
        List<PostDTO> dtos = new ArrayList<PostDTO>();

        for(Post p: postRepository.findAll()){
            PostDTO map = modelMapper.map(p, PostDTO.class);
            dtos.add(map);
        }
        return dtos;

    }
    


    @PostMapping
    public @ResponseBody PostDTO post(@RequestBody CreatePostDTO createPostDTO){
        Post post = modelMapper.map(createPostDTO, Post.class);    
        post = postRepository.save(post);
        post = postRepository.findById(post.getId()).get();
        return modelMapper.map(post, PostDTO.class);
    }
        

}

    // @PostMapping
    // public @ResponseBody Post post(@RequestBody Post post){
    //     return postRepository.save(post);
    // }

    

    
    

