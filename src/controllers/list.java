package controllers;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Comestible;
import repositories.Common;


@WebServlet("/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public list() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comestible[] comestible = Common.comestibleRepository.getAll();
		Writer writer=response.getWriter();
		//Se puede incluir tanto texto html como texto comun
		writer.append("<nav><a href='index.html'> Home </a><a href='add.html'> Agregar </a><a href='list.html'> Listar </a><a href='delete.html'> Eliminar </a>"+
			"<a href='modify.html'> Modificar </a></nav></br>");
		writer.append("<h1>Listado de comestibles - cantidad total: " + comestible.length + " </h1>");
		//Pasar el listado a una tabla
		for(int i=0; i<comestible.length;i++){
			writer.append("* Id: " + comestible[i].getId() + " - Nombre: " + comestible[i].getName() + " -  Descripción: " + comestible[i].getDescription()+ "</br>");
		}
	}
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bike[] bikes = Common.bikesRepository.getAll();
		
		
		response.setContentType("text/html;charset=UTF-8");
		Writer writer  = response.getWriter();
		writer.append("<h1>Cantidad de bicis " + bikes.length + " </h1>");
		
		
		String maxQuantityParam = request.getParameter("max-quantity");
		int maxQuantity = bikes.length;
		try {
			maxQuantity = Integer.parseInt(maxQuantityParam);
			if (maxQuantity > bikes.length) {
				System.out.println("Se trunco la cantidad a mostrar!");
				maxQuantity = bikes.length;
				writer.append("<i><b>Se trunco la cantidad a mostrar!</b></i>");
			}
		} catch (Exception e) {
			System.out.println("Hubo un errocito: " + e);
		}
		
		
		for (int index = 0; index < maxQuantity; index++) {
			Bike bike = bikes[index];
			writer.append("En posiciÃ³n " + index + " , Bici ID: " + bike.getId() + ", nombre: " + bike.getName() + ", price: " + bike.getPrice());
//			writer.append("<a href='delete-bike?id="+bike.getId()+"'><img src='https://fonts.gstatic.com/s/e/notoemoji/14.0/274c/32.png'></a>");
			writer.append("<form action='delete-bike'  method='POST' >"
					+ "<input type='number' value='"+bike.getId()+ "' name='id' readonly/>"
					+ "<input type='submit' value='Eliminar'/>"
					+ "</form>");
			writer.append("<br/>");
		}

		writer.append("<a href='list.html'>Volver</a>");
		
		response.setStatus(HttpServletResponse.SC_OK); 
	}

*/
	
}
