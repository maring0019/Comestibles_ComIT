package repositories;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import db.ConcreteDBMSHandler;
import db.DbFacade;
import model.Comestible;

public class DataBaseComestiblesRepository implements ComestiblesRepository {

	private DbFacade dbFacade;
	
	public DataBaseComestiblesRepository() throws SQLException {
		ConcreteDBMSHandler dbmsHandler = new ConcreteDBMSHandler();
		dbmsHandler.startup();
		this.dbFacade = new DbFacade(dbmsHandler);
	}
	
	@Override
	public void addNewComestible(Comestible comestible) {
		int id = 0;
		try {
			String insertionQuery = "INSERT INTO comestible(name, description) VALUES ('"+ comestible.getName()+"','"+comestible.getDescription()+"');";                     
			id = dbFacade.executeInsertionQuery(insertionQuery);
			comestible.setId(id);
		} catch (SQLException e) {
			System.err.println("Error al insertar: " + e.getMessage());
		}

	}

	@Override
	public void modifyExisting(Comestible comestible) {
		try {
			String updateQuery = "UPDATE Comestible SET description = '"+ comestible.getDescription()+"', name='"+comestible.getName()+"' WHERE id = '"+ comestible.getId() +"';";                     
			int value = dbFacade.executeDeleteOrUpdateQuery(updateQuery);
			System.out.println("Resultado: " + value);
		} catch (SQLException e) {
			System.err.println("Error al actualizar: " + e.getMessage());
		}

	}

	@Override
	public void deleteByIndex(int index) {
		throw new RuntimeException("Método deleteByIndex no implementado para DataBase");
	}

	@Override
	public void deleteById(int id) {
		try {
			String deletionQuery = "delete from comestible WHERE id = " + id;
			int value = dbFacade.executeDeleteOrUpdateQuery(deletionQuery);
			System.out.println("Resultado: " + value);
		} catch (SQLException e) {
			System.err.println("Error al borrar: " + e.getMessage());
		}

	}

	@Override
	public Comestible[] getAll() {
		try {
			List<HashMap<String,Object>> rows = this.dbFacade.executeQueryReturningSet("SELECT id, name, description FROM comestible");
			int rowCount = rows.size();
			Comestible[] comestibles = new Comestible[rowCount];
			for (int i = 0; i < rows.size(); i++) {
				Comestible comestible = toComestible(rows.get(i));
				comestibles[i] = comestible;
			}
			return comestibles;
		} catch(Exception e) {
			System.err.println("Error al recuperar: " + e.getMessage());
			return new Comestible[0];
		}
		
	}
	
	
	public Comestible toComestible(HashMap<String, Object> valueByColumnName) {
		int id = (Integer) valueByColumnName.get("id");
		String name = (String) valueByColumnName.get("name");
		String description = (String) valueByColumnName.get("description");
		
		Comestible comestible = new Comestible(id, name, description);
		return comestible;
	}

}
