package service;

public class Filtre {
	//attributs
	private String category,label;
	private int id;
	private boolean isChecked;
	
	//constructeur
	public Filtre() {
		super();
	}
	//G & S
	

	public String getCategory() {
		return category;
	}
	

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}


	@Override
	public String toString() {
		return "Filtre [category=" + category + ", label=" + label + ", id=" + id + ", isChecked=" + isChecked + "]";
	}
	
	
	
	
	

}
