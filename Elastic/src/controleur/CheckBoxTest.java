package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SystFiltre;
import model.Utilisateur;

/**
 * Servlet implementation class CheckBoxTest
 */
@WebServlet("/checkboxtest")
public class CheckBoxTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// je conserve l'objet client dans la session
		Utilisateur cl = (Utilisateur) request.getSession().getAttribute("cl");
		// je verifie si le client est toujours connecté
		if (cl != null) {

			// recuperer via la request les checkbox
			String[] filtresFamSelectionne = request.getParameterValues("valueFamille");

			List<SystFiltre> listeFiltresFam = (List<SystFiltre>) request.getSession().getAttribute("filtreFamille");

			// pour chaques elements de cette liste
			for (SystFiltre o : listeFiltresFam) {
				// on le met non-checker par defaut
				o.setChecked(false);

				if (filtresFamSelectionne != null) {
					// si y'a qqchose de selectionner dans les checkbox
					// on recupere dans la session notre liste de filtreFamille
					// si on trouve dans la listefamille des famille checker, on les passe en checker = true
					for (int i = 0; i < filtresFamSelectionne.length; i++) {
						if (o.getId() == Integer.parseInt(filtresFamSelectionne[i])) {
							o.setChecked(true);
						}
					}
				}

			}
			// on remet la liste modifiée dans la session
			request.getSession().setAttribute("filtreFamille", listeFiltresFam);

			// si c'est lana + travail : alors on affiche la jsp bienvenue
			request.getRequestDispatcher("/WEB-INF/bienvenue.jsp").forward(request, response);
		} else {
			// si l'utilisateur n'est pas declarer donc pas connecté :
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

}
