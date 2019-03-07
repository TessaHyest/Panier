package service;

import java.util.ArrayList;

import modele.Famille;
import modele.FamilleDAO;
import modele.SousFamille;
import modele.SousFamilleDAO;

public class CreateArrayListFiltre {
	
	//attributs
	//une array liste pour mon CreateArrayListFiltre et pour les famille et sousfamille
	private ArrayList filtre;
	private ArrayList <Famille> fam;
	private ArrayList <SousFamille> sFam;
	
	//constructeur
	public CreateArrayListFiltre() {
	}
	
	//methode init
	public ArrayList init() {
		//je recupere les elements de la table famille
		FamilleDAO famDAO = new FamilleDAO();
		fam = (ArrayList<Famille>) famDAO.findAll();
		
		SousFamilleDAO sFamDAO=new SousFamilleDAO();
		sFam = (ArrayList<SousFamille>) sFamDAO.findAll();
		
		filtre.add(famDAO);
		filtre.add(sFamDAO);
		
		return filtre;
		
	}
	
	

}
