package com.app.springboot.servicio.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient  // se puede evitar porque se habilita automaticamente en el pom
@SpringBootApplication
public class SpringbootSercivioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSercivioProductosApplication.class, args);
	}

}
