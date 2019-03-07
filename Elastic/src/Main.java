import java.util.ArrayList;


import modele.Famille;
import modele.FamilleDAO;
import modele.SousFamille;
import modele.SousFamilleDAO;
import service.Filtre;

public class Main {

	public static void main(String[] args) {
		
		
		
		//creation d'une arraylist de Filtre
		ArrayList<Filtre> filterList = new ArrayList();
		
		//pour la famille--------------
		
		//creation et instanciation d'un nouvel objetFamilleDAO
		FamilleDAO famDAO = new FamilleDAO();
		//creation d'un objet liste pour recuperer les elements de la table famille
		ArrayList<Famille> famille = (ArrayList<Famille>) famDAO.findAll();
		
		//je recupere les elements 1 par 1 (de type famille donc un id (int) et un nom (String)
		for(Famille f:famille) {
			int i = 0;
			//je construit un objet filtre avec l'objet famille
			Filtre filtre = new Filtre();
			filtre.setId(i);
			filtre.setCategory("famille");
			//je n'affiche que l'intitulé pour le label
			filtre.setLabel(f.getIntitule());
			//par defaut unchecked
			filtre.setChecked(false);
			
			//j'ajoute cet objet dans ma liste de filtre
			filterList.add(filtre);
		}
		
		//on teste
		System.out.println(filterList);
		
		//pour la sous famille--------------
		
		//creation et instanciation d'un nouvel objetFamilleDAO
		SousFamilleDAO sousFamDAO = new SousFamilleDAO();
		//creation d'un objet liste pour recuperer les elements de la table famille
		ArrayList<SousFamille> SousFamille = (ArrayList<SousFamille>) sousFamDAO.findAll();
		
		for(SousFamille s:SousFamille) {
			int i = 0;
			//je construit un objet filtre avec l'objet famille
			Filtre filtre = new Filtre();
			filtre.setId(i);
			filtre.setCategory("sousFamille");
			//je n'affiche que l'intitulé pour le label
			filtre.setLabel(s.getIntitule_ssFamille());
			//par defaut unchecked
			filtre.setChecked(false);
			
			//j'ajoute cet objet dans ma liste de filtre
			filterList.add(filtre);
		}
		
		//on teste
		System.out.println(filterList);
		
		//methode pour afficher tous les label des filtres d'une category
		for(Filtre f:filterList)
			if(f.getCategory()=="famille") {
				System.out.println(f.getLabel());
			}else {
				System.out.println("");
			}
		
				
		
		
			
		
		
		
		
//		//pour la famille--------------
//		
//		//creation et instanciation d'un nouvel objetFamilleDAO
//		FamilleDAO famDAO = new FamilleDAO();
//		//creation d'un objet liste pour recuperer les elements de la table famille
//		ArrayList<Famille> famille = (ArrayList<Famille>) famDAO.findAll();
//		//on essai d'afficher le resultat
//		System.out.println(famille.toString());
//		//c'est ok on continue
//		
//		//je recupere les elements 1 par 1 (de type famille donc un id (int) et un nom (String)
//		
//		for(Famille f:famille) {
//			//je n'affiche que l'intitulé
//			System.out.println(f.getIntitule());
//		}
//		
//		//pour la sous-famille--------------
//		//creation et instanciation d'un nouvel objetSousFamilleDAO
//		SousFamilleDAO sFamDAO = new SousFamilleDAO();
//		//creation d'un objet liste pour recuperer les elements de la table sous famille
//		ArrayList<SousFamille> sFamille = (ArrayList<SousFamille>) sFamDAO.findAll();
//		//on essai d'afficher le resultat
//		System.out.println(sFamille.toString());
//		//c'est ok on continue
//		
//		//je recupere les elements 1 par 1 (de type sous famille donc un id (int) et un nom (String)
//		
//		for(SousFamille s :sFamille) {
//			//je n'affiche que l'intitulé
//			System.out.println(s.getIntitule_ssFamille());
//		}
//		
//		//je mets toutes mes array list dans une array list "Filtre"
//		ArrayList <Object>filtre = new ArrayList<Object>();
//		filtre.add(famille);
//		filtre.add(sFamille);		
//		
//		//on essai d'imprimer pour voir
//		System.out.println(filtre);
//		
//		//on passe une ligne sinon on voit rien
//		System.out.println("---------------------------------------------------------");
//		
//		//on imprime les élements un par un
//		for(Object o:filtre) {
//			//System.out.println(o);
//			ArrayList<Object> partie = new ArrayList();
//			partie=(ArrayList<Object>) o;
//			for( Object p:partie) {
//				System.out.println(p);
//				
//			}
//		}
//		
	}
	

}
