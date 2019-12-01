package com.app.springboot.servicio.productos.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.springboot.servicio.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {

}
