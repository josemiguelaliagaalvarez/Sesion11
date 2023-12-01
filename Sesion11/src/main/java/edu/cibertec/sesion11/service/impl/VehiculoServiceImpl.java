package edu.cibertec.sesion11.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import edu.cibertec.sesion11.entity.Vehiculo;
import edu.cibertec.sesion11.repository.VehiculoRepository;
import edu.cibertec.sesion11.service.VehiculoService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class VehiculoServiceImpl implements VehiculoService {
	@Autowired
	private VehiculoRepository repoVehiculo;

	@Override
	public List<Vehiculo> listarVehiculo() {
		// TODO Auto-generated method stub
		return repoVehiculo.findAll();
	}

	@Override
	public List<Vehiculo> listarVehiculoMarca(String marca) {
		// TODO Auto-generated method stub
		return repoVehiculo.findByMarca(marca);
	}

	@Override
	public JasperPrint exportReport() throws FileNotFoundException, JRException {
		// TODO Auto-generated method stub
		List<Vehiculo>listadoVehiculo=repoVehiculo.findAll();
		File archivo=ResourceUtils.getFile("classpath:reporteVehiculo.jrxml");
		JasperReport report=JasperCompileManager.compileReport(archivo.getAbsolutePath());
		JRBeanCollectionDataSource ds= new JRBeanCollectionDataSource(listadoVehiculo);
		Map<String, Object>parametros=new HashMap<>();
		parametros.put("Agencia", "Cercado de Lima");
		JasperPrint print=JasperFillManager.fillReport(report, parametros, ds);
		return print;
	}

}
