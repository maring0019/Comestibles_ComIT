package model;

public class Comestible {
	
	private String name;
	private String description;
	private double price;
	private String dueDate; //tipo fecha?
	private String tipo;// fruta, verdura, mercaderia, : capacidad, unidad de medida -> Enum
	private int id;
	
	public Comestible(String description, double price, String name, String dueDate,String tipo ){
		this.description=description;
		this.price=price;
		this.name=name;
		this.dueDate=dueDate;
		this.tipo=tipo;
		
	}

	
	/*para prueba*/
	public Comestible(int id, String name, String description) {
		this.id = id;
		this.name = name;/*lo tomo como precio para probar codigo del profe.*/
		this.description = description;
	}
	public Comestible(String name, String description) {
		this.id = id;
		this.name = name;/*lo tomo como precio para probar codigo del profe.*/
		this.description = description;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDueDate() {
		return dueDate;
	}


	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
