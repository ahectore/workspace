package com.app.springboot.servicio.productos.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity  // interface jpa
@Table(name="Productos") // nombre opcional si son iguales en la db
public class Producto implements Serializable{

	private static final long serialVersionUID = -4313817277972177476L;

		@Id //llave primaria
		@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincremental
		private Long id;
		
		private String nombre;
		private Double precio;
		
		@Column(name = "create_at") //se llama distinto el campo en la db
		@Temporal(TemporalType.DATE) // formato de fecha, solo dd/mm/aaaa
		private Date createAt;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public Double getPrecio() {
			return precio;
		}
		public void setPrecio(Double precio) {
			this.precio = precio;
		}
		public Date getCreateAt() {
			return createAt;
		}
		public void setCreateAt(Date createAt) {
			this.createAt = createAt;
		}
		
		

}
