package it.data_web.spring_data_web.util.mapper;

import org.modelmapper.AbstractConverter;

public class ConvertStringToInteger extends AbstractConverter<String, Integer>{
    @Override
    protected Integer convert(String source){
        return source.length();
    }
}
