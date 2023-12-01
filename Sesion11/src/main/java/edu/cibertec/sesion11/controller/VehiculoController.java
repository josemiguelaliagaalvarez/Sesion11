package edu.cibertec.sesion11.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.sesion11.service.VehiculoService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;

@Controller
@RequestMapping("/")
public class VehiculoController {
	@Autowired
	private VehiculoService servicioVehiculo;
	
	@GetMapping("lisVehiculo")
	public ModelAndView listarVehiculo() {
		ModelAndView mav=new ModelAndView("listadoVehiculo");
		mav.addObject("listaVehiculo", servicioVehiculo.listarVehiculo());
		return mav;
	}
	
	public ModelAndView listarVehiculoMarca(@RequestParam("marca")String marca) {
		ModelAndView mav=new ModelAndView("listadoVehiculoMarca");
		mav.addObject("listaVehiculo", servicioVehiculo.listarVehiculoMarca(marca));
		return mav;
	}
	@GetMapping("reportePDF")
	public void exportarPDF(HttpServletResponse response) throws JRException, IOException{
		response.addHeader("Content-disposition", "inline; filename"+"vehiculo.pdf");
		response.setContentType("application/pdf");
		ServletOutputStream outputStream=response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(servicioVehiculo.exportReport(), outputStream);
		outputStream.flush();
		outputStream.close();
	}

}
