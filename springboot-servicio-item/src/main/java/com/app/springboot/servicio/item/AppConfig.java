package com.app.springboot.servicio.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  // nos permite crear objetos/componentes/beans de spring
public class AppConfig {
	
	@Bean("clienteRest")    // esto va a inyectar cuando lo llamemos
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}
