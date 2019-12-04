package com.app.springboot.servicio.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.springboot.servicio.item.models.Producto;

@FeignClient(name = "servicio-productos")  // cliente feign con el nombre 
public interface ProductoClienteRest {
	
	@GetMapping ("/listar") // tiene que ser el mismo del controlador del servicio
	public List<Producto> listar();
	
	@GetMapping("/ver/{id}") // igual que el controlador de producto "no item"
	public Producto detalle(@PathVariable Long id);

}
