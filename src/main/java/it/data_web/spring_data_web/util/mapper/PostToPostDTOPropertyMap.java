package it.data_web.spring_data_web.util.mapper;

import org.modelmapper.PropertyMap;

import it.data_web.spring_data_web.dto.PostDTO;
import it.data_web.spring_data_web.model.Post;

public class PostToPostDTOPropertyMap extends PropertyMap<Post, PostDTO>{
    @Override
    protected void configure(){
        using(new ConvertStringToInteger()).map(source.getBody()).setBody(null);
    }
}
