package it.data_web.spring_data_web.service;

import java.util.List;

import it.data_web.spring_data_web.dto.CreatePostDTO;
import it.data_web.spring_data_web.dto.PostDTO;

public interface PostService {
    List<PostDTO> readAll();
    PostDTO create(CreatePostDTO post) throws Exception;
}
