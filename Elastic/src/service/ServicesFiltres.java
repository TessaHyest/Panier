package service;

import java.util.ArrayList;
import java.util.List;

import modele.Famille;
import modele.SousFamille;
import modele.FamilleDAO;
import modele.SousFamilleDAO;

/**
 * 
 * @author bruno
 *
 *	Class regroupant les 3 filtres : Fam, SSFam, Marque
 *  remplir filtres, et lignes de CB
 *
 */
public class ServicesFiltres {
	
	public static final int FAMILLE   	= 0;
	public static final int SSFAMILLE 	= 1;
	public static final int MARQUE		= 2;
	
	private static List<BlocFiltre> filtres = new ArrayList<BlocFiltre>();
	
	public static void init() {
		
		// pr&épa du bloc de filtre famille
		BlocFiltre monBloc1 = new BlocFiltre("Famille");
		
		// remplir le bloc famille avec la BDD
		FamilleDAO famDAO = new FamilleDAO();
		List<Famille> lstFamilles = famDAO.findAll();
		
		// pour chaque elt de la liste 
		// foreach en java
		for (Famille familleEnCours : lstFamilles) {
			monBloc1.addLigne(
				new LigneFiltre(familleEnCours.getId(), 
								familleEnCours.getIntitule(),
								false
								)
							);
		}
		
		filtres.add(monBloc1);
		
		
		BlocFiltre monBloc2 = new BlocFiltre("SS-Famille");
		
		// remplir le bloc famille avec la BDD
		SousFamilleDAO ssfamDAO = new SousFamilleDAO();
		List<SousFamille> lstSSFamilles = ssfamDAO.findAll();
		
		//c pour chaque elt de la liste 
		// foreach en java
		for (SousFamille ssfamilleEnCours : lstSSFamilles) {
			monBloc2.addLigne(
				new LigneFiltre(ssfamilleEnCours.getId(), 
								ssfamilleEnCours.getIntitule_ssFamille(),
								true
								)
							);	
		}	
		filtres.add(monBloc2);
	}
	
	public static  List<BlocFiltre> getFiltres(){
		return filtres;
		
	}
}
