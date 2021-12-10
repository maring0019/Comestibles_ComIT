package repositories;

import java.util.Arrays;
import java.util.Date;

import model.Comestible;

public class InMemoryComestiblesRepository implements ComestiblesRepository{

	private static int MAX_COMESTIBLES_COUNT = 2000;
	
	private Comestible[] comestibles;
	private int contadorDeComestiblesCreadas;
	
	private int addedComestiblesCount;
	
	@Override
	public void addNewComestible(Comestible comestible) {
		this.comestibles = new Comestible[MAX_COMESTIBLES_COUNT];
		this.contadorDeComestiblesCreadas = 0;
		this.addedComestiblesCount = 0;
		
	}

	@Override
	public void modifyExisting(Comestible comestible) {
		int index = searchById(comestible.getId());
		this.comestibles[index] = comestible;
		
	}

	@Override
	public void deleteByIndex(int index) {
		for (int i = index; i < this.comestibles.length-1; i++) {
			this.comestibles[i] = this.comestibles[i+1];
		}
		this.contadorDeComestiblesCreadas--;
		
	}

	@Override
	public void deleteById(int id) {
		Date date = new Date();
		
		int index = searchById(id);
		deleteByIndex(index);
		
	}
	
	private int searchById(int id) {
		int index = -1;
		for (int i = 0; i < this.comestibles.length-1 && index == -1; i++) {
			if (this.comestibles[i].getId() == id) {
				index = i;
			}
		}
		return index;
	}
	

	@Override
	public Comestible[] getAll() {
		return Arrays.copyOf(this.comestibles, this.contadorDeComestiblesCreadas);
	}

}
