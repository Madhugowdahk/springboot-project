package com.example.springbootproject.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfigure {
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
