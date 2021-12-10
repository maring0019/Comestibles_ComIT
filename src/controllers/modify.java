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

@WebServlet("/modify")
public class modify extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public modify() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		/*hacer que primero busque el id. Y luego recien permita hacer cambios.*/
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		Comestible comestible=new Comestible(name, description);
		comestible.setId(id);
		
		
		Writer writer=response.getWriter();
		//Se puede incluir tanto texto html como texto comun
		writer.append("<nav><a href='index.html'> Home </a><a href='add.html'> Agregar </a><a href='list.html'> Listar </a><a href='delete.html'> Eliminar </a>"+
			"<a href='modify.html'> Modificar </a></nav></br>");
		
		Common.comestibleRepository.modifyExisting(comestible);
		writer.append("<h2>El comestible fue modificado con éxito</h2>");

	}
	
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String priceParam = request.getParameter("price");
		String idParam = request.getParameter("id");
		
		Writer writer = response.getWriter();
		try {
			int price = Integer.parseInt(priceParam);
			int id = Integer.parseInt(idParam);
			Bike bike = new Bike(name,price);
			bike.setId(id);
			Common.bikesRepository.modifyExisting(bike);
			
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/html;charset=UTF-8");
			writer.append("<div>"
					+	 "<b>OK</b>, Modifique la bici con id " + bike.getId() + ", ahora tiene nombre " + bike.getName() + " y precio: " + bike.getPrice()
					+ "</div>");
			writer.append("<a href='modify.html'>Volver</a>");
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
*/
}
