package edu.cibertec.sesion11.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.sesion11.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {

}
