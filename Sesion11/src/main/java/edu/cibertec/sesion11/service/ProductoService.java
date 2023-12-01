package edu.cibertec.sesion11.service;

import java.io.IOException;
import java.util.List;

import edu.cibertec.sesion11.entity.Producto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface ProductoService {

	public List<Producto>listadoProducto();
	
	public JasperPrint repoProducto(String ciudad) throws IOException, JRException;
}
