package com.app.springboot.servicio.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.springboot.servicio.productos.models.entity.Producto;
import com.app.springboot.servicio.productos.models.service.IProductoService;

@RestController  // anotacion para controlador, es rest porque retorna un json
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	//@Autowired
	//private Environment env;
	
	@Value("${server.port}")  // inyecta valores de lo propertys
	private Integer port;
	
	@GetMapping("/listar")  // permite mapear a una ruta url
	public List<Producto> listar(){
		return productoService.findAll().stream().map(producto ->{
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) throws Exception {  // indica que el path varia
		Producto producto = productoService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		
		/*Thread.sleep(2000L);
		
		/*boolean ok = false;
		if(ok)
		{throw new Exception("no se encuentra el producto");}*/
		
		return producto;
	}
	

}
