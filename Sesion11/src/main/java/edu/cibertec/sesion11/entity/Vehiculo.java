package edu.cibertec.sesion11.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_vehiculo")
public class Vehiculo {
	@Id
	private String codvehiculo;
	private String modelo;
	private String marca;
	private String color;
	private String traccion;
	private String transmision;
	private int asiento;
	
	public Vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehiculo(String codvehiculo, String modelo, String marca, String color, String traccion, String transmision,
			int asiento) {
		super();
		this.codvehiculo = codvehiculo;
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
		this.traccion = traccion;
		this.transmision = transmision;
		this.asiento = asiento;
	}

	public String getCodvehiculo() {
		return codvehiculo;
	}

	public void setCodvehiculo(String codvehiculo) {
		this.codvehiculo = codvehiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTraccion() {
		return traccion;
	}

	public void setTraccion(String traccion) {
		this.traccion = traccion;
	}

	public String getTransmision() {
		return transmision;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}

	public int getAsiento() {
		return asiento;
	}

	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}
	
	
}
