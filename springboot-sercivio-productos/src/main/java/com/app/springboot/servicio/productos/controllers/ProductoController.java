package com.app.springboot.servicio.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.springboot.servicio.productos.models.entity.Producto;
import com.app.springboot.servicio.productos.models.service.IProductoService;

@RestController  // anotacion para controlador, es rest porque retorna un json
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")  // permite mapear a una ruta url
	public List<Producto> listar(){
		return productoService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {  // indica que el path varia
		return productoService.findById(id);
	}
	

}
