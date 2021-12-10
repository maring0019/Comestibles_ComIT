package controllers;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.Common;
import model.Comestible;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public add() {
        super();
    
    }
    /*solo pone doPost ?*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		
		Writer writer=response.getWriter();//?
		
		Comestible comestible=new Comestible(name, description);
		//El problema era que no se puede poner comillas dobles "" dentro de otra "". Ej. del href="index.html". Lo cambiamos a comillas simples, ''.
		writer.append("<nav><a href='index.html'> Home </a><a href='add.html'> Agregar </a><a href='list.html'> Listar </a><a href='delete.html'> Eliminar </a>"+
				"<a href='modify.html'> Modificar </a></nav></br>");		
		Common.comestibleRepository.addNewComestible(comestible);
		//buscar mensaje similar en html que sea una ventana, alert
		writer.append("<h2>El comestible fue agregado con éxito</h2>");
		
		
	}
	
	/*Adaptar al mensaje anterior*/
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String priceParam = request.getParameter("price");
		
		String yearParam = request.getParameter("year");
		String monthParam = request.getParameter("month");
		String day = request.getParameter("day");
		
		System.out.println(yearParam + "/" + monthParam + "/" + day);
		
		Writer writer = response.getWriter();
		try {
			int price = Integer.parseInt(priceParam);
			
			Bike bike = new Bike(name,price);
			
			Common.bikesRepository.addNewBike(bike);
			
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/html;charset=UTF-8");
			writer.append("<div>"
					+	 "<b>OK</b>, agrege la bici con nombre " + bike.getName() + " y precio: " + bike.getPrice() + " con ID = " + bike.getId()
					+ "</div>");
			writer.append("<a href='add.html'>Volver</a>");
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
*/
}
