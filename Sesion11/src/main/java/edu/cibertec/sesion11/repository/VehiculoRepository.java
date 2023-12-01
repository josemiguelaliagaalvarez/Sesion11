package edu.cibertec.sesion11.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.sesion11.entity.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {
	List<Vehiculo>findByMarca(String marca);
}
