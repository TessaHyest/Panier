package model;

import java.util.Arrays;

/**
 * 
 * @authorjoris
 * class Filter pour construire des String[] de filtres
 *
 */
public class Filtre
{
	//attributs
	private int id;
	private String nom;
	private String[] Filtre; 
	
	public Filtre() {
		this.id=-1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String[] getFiltre() {
		return Filtre;
	}

	public void setFiltre(String[] filtre) {
		this.Filtre = filtre;
	}

	@Override
	public String toString() {
		return "Filter [id=" + id + ", Filtre=" + Arrays.toString(Filtre) + "]";
	}
	
	
	

}
