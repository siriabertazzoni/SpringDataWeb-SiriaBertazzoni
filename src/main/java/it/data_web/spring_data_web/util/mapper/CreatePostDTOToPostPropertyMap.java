package it.data_web.spring_data_web.util.mapper;

import org.modelmapper.PropertyMap;

import it.data_web.spring_data_web.dto.CreatePostDTO;
import it.data_web.spring_data_web.model.Post;

public class CreatePostDTOToPostPropertyMap extends PropertyMap<CreatePostDTO, Post>{

    @Override
    protected void configure(){
        // quando converte da CreatePostDTO a Post, sa che deve mappare l'id null e autoreId deve metterlo al posto dell'id del campo Autor.
        map().setId(null);
        map().getAutore().setId(source.getAutoriId());
    }

}
