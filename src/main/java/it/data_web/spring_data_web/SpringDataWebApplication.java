package it.data_web.spring_data_web;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import it.data_web.spring_data_web.dto.CreatePostDTO;
import it.data_web.spring_data_web.model.Autore;
import it.data_web.spring_data_web.model.Post;
import it.data_web.spring_data_web.util.mapper.CreatePostDTOToPostPropertyMap;

@SpringBootApplication
public class SpringDataWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataWebApplication.class, args);
	}

	// oggetto singleton
	@Bean
	public ModelMapper modelMapper(){
		ModelMapper mapper = new ModelMapper();
		// PropertyMap<CreatePostDTO, Post> createPostDtoToPostMapping = new PropertyMap<CreatePostDTO,Post>() {
		// 	protected void configure(){
		// 		map().setId(null);
		// 		// prendi l'autore e settalo con l'id
		// 		map().getAutore().setId(source.getAutoriId());
		// 	}
		// };
		// mapper.addMappings(createPostDtoToPostMapping);

		CreatePostDTOToPostPropertyMap createPostDTOToPostPropertyMap = new CreatePostDTOToPostPropertyMap();
		mapper.addMappings(createPostDTOToPostPropertyMap);
		return mapper;
	}

}
