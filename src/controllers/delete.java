package controllers;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.Common;

@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public delete() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Writer writer = response.getWriter();
		writer.append("<nav><a href='index.html'> Home </a><a href='add.html'> Agregar </a><a href='list.html'> Listar </a><a href='delete.html'> Eliminar </a>"+
				"<a href='modify.html'> Modificar </a></nav></br>");
		Common.comestibleRepository.deleteById(id);
		
		
				
		writer.append("El comestible fue eliminado con �xito.");
		
	}
	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		
		Writer writer = response.getWriter();
		
		try {
			int id = Integer.parseInt(idParam);
			
			Common.bikesRepository.deleteById(id);
			writer.append("La bici con id: " + id + "fue eliminada con éxito ");
			writer.append("<a href='delete.html'>Volver</a>");
			
			response.setContentType("text/html;charset=UTF-8");
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			writer.append("Estoy teniendo errores, perdón! " + e);
		}
	}*/

}
