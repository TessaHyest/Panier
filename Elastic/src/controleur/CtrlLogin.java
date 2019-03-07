package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utilisateur;
import service.ServicesFiltres;
import service.User;

/**
 * Servlet implementation class CtrlLogin
 * permet de verifier que le login et le mot-de-pass sont correct
 */
@WebServlet("/ctrllogin")
public class CtrlLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//recuperer les valeur user et pass dans l'objet client
		//creation d'un objet client
		Utilisateur cl = new Utilisateur();
		//je passe les parametre user et name du formulaire login.jsp dans le client
		cl.setUser(req.getParameter("user"));
		cl.setPass(req.getParameter("pass"));
		
			
		//verifier si le client est enregistré
		if((cl.getUser().equals("lana"))&&  ((cl.getPass().contentEquals("travail")))){
			//si user et pass ok
			//on passe le user et le mot de pass dans la page suivante
			req.setAttribute("user", cl.getUser());
			req.setAttribute("pass", cl.getPass());
			//creation d'une liste de filtre 'fam'
			//ArrayList fam= (ArrayList) Service.getListFiltreFamille();
			//req.getSession().setAttribute("filtreFamille", fam);
			
			req.getSession().setAttribute("user", cl);
			
			//je conserve l'objet client dans la session
			//req.getSession().setAttribute("cl", cl);
			//si c'est lana + travail : alors on affiche la jsp bienvenue
			
			
			//initialiser les filtres
			service.ServicesFiltres.init();
			// stocker dans la session les filtres
			
			req.getSession().setAttribute("tabfiltres", service.ServicesFiltres.getFiltres() );
			
			req.getRequestDispatcher("/WEB-INF/catatalogue.jsp").forward(req, res);
			
		}else {
			//si le user et le mot de pass ne correspondent pas
			//je renvoi en reponse un message de type html
			res.setContentType("text/html");
			//j'ecrit au travers d'un PrintWriter
			PrintWriter out = res.getWriter();
			out.println("met ton mot de passe et te plante pas");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//même chose pour le doPost
		doGet(request, response);
	}

}
