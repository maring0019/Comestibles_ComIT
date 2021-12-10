package repositories;

import java.sql.SQLException;

import model.Comestible;

public class Common {
	public static ComestiblesRepository comestibleRepository;
	

	static {
		 try {
			System.out.println("Iniciando base de datos");
			comestibleRepository = new DataBaseComestiblesRepository();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	
}
