package repositories;

import model.Comestible;

public interface ComestiblesRepository {
	void addNewComestible(Comestible comestible);

	void modifyExisting(Comestible comestible);

	void deleteByIndex(int index);

	void deleteById(int id);

	Comestible[] getAll();


}

