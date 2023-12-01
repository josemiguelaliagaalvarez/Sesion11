package edu.cibertec.sesion11.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import edu.cibertec.sesion11.entity.Producto;
import edu.cibertec.sesion11.repository.ProductoRepository;
import edu.cibertec.sesion11.service.ProductoService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository repoProducto;
	@Override
	public List<Producto> listadoProducto() {
		// TODO Auto-generated method stub
		return repoProducto.findAll();
	}

	@Override
	public JasperPrint repoProducto(String ciudad) throws IOException, JRException {
		// TODO Auto-generated method stub
		List<Producto>listadoProducto=repoProducto.findAll();
		File archivo=ResourceUtils.getFile("classpath:reporteProducto.jrxml");
		JasperReport report=JasperCompileManager.compileReport(archivo.getAbsolutePath());
		JRBeanCollectionDataSource ds=new JRBeanCollectionDataSource(listadoProducto);
		Map<String, Object>parametros=new HashMap<>();
		parametros.put("ciudad", ciudad);
		JasperPrint print=JasperFillManager.fillReport(report, parametros, ds);
		return print;
	}

}
