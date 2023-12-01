package edu.cibertec.sesion11.service;

import java.io.FileNotFoundException;
import java.util.List;

import edu.cibertec.sesion11.entity.Vehiculo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface VehiculoService {
	public List<Vehiculo>listarVehiculo();
	public List<Vehiculo>listarVehiculoMarca(String marca);
	public JasperPrint exportReport()throws FileNotFoundException, JRException;
}
