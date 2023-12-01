package edu.cibertec.sesion11.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.sesion11.service.ProductoService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;

@Controller
@RequestMapping("/")
public class ProductoController {
	@Autowired
	private ProductoService servicioProducto;
	
	@GetMapping("lisProducto")
	public ModelAndView listarProducto() {
		ModelAndView mav=new ModelAndView("listadoProducto");
		mav.addObject("listado", servicioProducto.listadoProducto());
		return mav;
	}
	
	@GetMapping("repoProduto")
	public void reporteProducto(HttpServletResponse response, @RequestParam(name = "ciudad")String ciudad) throws IOException, JRException{
		response.addHeader("content-disposition", "inline; filename="+"repoProducto.pdf");
		response.setContentType("application/pdf");
		ServletOutputStream outputStream=response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(servicioProducto.repoProducto(ciudad), outputStream);
		outputStream.flush();
		outputStream.close();
	}
}
