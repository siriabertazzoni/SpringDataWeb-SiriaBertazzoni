package it.data_web.spring_data_web.util.mapper;

import org.modelmapper.PropertyMap;

import it.data_web.spring_data_web.dto.AutoreDTO;
import it.data_web.spring_data_web.model.Autore;

public class AutoreToAutoreDTOPropertyMap extends PropertyMap<Autore, AutoreDTO>{
    @Override
    protected void configure(){
        using(new ConvertCollectionToInteger()).map(source.getPosts()).setNumeroPost(null);
    }
}
