package com.app.springboot.servicio.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.springboot.servicio.item.models.Item;
import com.app.springboot.servicio.item.models.Producto;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
		return productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
		// creamos un flujo y asignamos un mapa, funcion de flecha con el producto
		// collect para formar la lista y el arg pasamos a tolist
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String,String> pathVariables = new HashMap<String,String>();
		pathVariables.put("id", id.toString());
		Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class , pathVariables);
		return new Item(producto, cantidad);
	}
	

}