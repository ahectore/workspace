package com.app.springboot.servicio.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.springboot.servicio.productos.dao.ProductoDao;
import com.app.springboot.servicio.productos.models.entity.Producto;

@Service  //marca la clase como un beans/componente en spring, se pueden inyectar despues
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private ProductoDao productoDao; //inyectamos el dao

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll(); // cast porque nos devuelve un iterable
	}

	@Override
	@Transactional(readOnly = true) // con esto esta sincronizada con la db
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null); // si no lo encuentra retorna null
	}

}
