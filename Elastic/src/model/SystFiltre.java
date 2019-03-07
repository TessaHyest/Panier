package model;

public class SystFiltre {
	//attributs
	private int id;
	private String TypeFamille;
	private boolean checked;
	
	/**
	 * 
	 */
	//constructeur 0 parametres
	public SystFiltre() {
		
		this.TypeFamille="";
		this.checked = false;
	}
	/**
	 * 
	 * @param v
	 * valeur
	 * @param t
	 * type de famille
	 * @param b
	 * est coché ou non
	 */
	//constructeur 3 parametres
	public SystFiltre(int v, String t, boolean b) {
		this.id= v;
		this.TypeFamille = t;
		this.checked = false;
	}
	
	//methodes
	
	/**
	 * 
	 * @return
	 * value 
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param value
	 */
	public void setId(int i) {
		this.id = i;
	}
	/**
	 *
	 * @return
	 * type de famille (famille, ssoufamille ou marque)
	 */
	public String getTypeFamille() {
		return TypeFamille;
	}
	/**
	 * 
	 * @param typeFamille
	 */
	public void setTypeFamille(String typeFamille) {
		TypeFamille = typeFamille;
	}
	/**
	 * 
	 * @return
	 */
	public boolean Ischecked() {
		return checked;
	}
	/**
	 * 
	 * @param isChecked
	 */
	public void setChecked(boolean isChecked) {
		checked = isChecked;
	}
	
	public String getValueChecked() {
		if( Ischecked()==false) {
			return "";
		}else {
			return "checked";
		}
	}
	
	
	

}
