package fr.eni.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.beans.Utilisateur;
import fr.eni.encheres.dao.DAOFactory;
import fr.eni.encheres.erreurs.DALException;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/authentification.html")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("erreur", "");
		//delegation à la page d'authentification
		request.getRequestDispatcher("/WEB-INF/jsp/authentification.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant=null;
		String motDePasse=null;
		Utilisateur utilisateur = null;
		
		//verification si le pseudo et le mot de passe sont bien renseigné
		if (request.getParameter("identifiant").isEmpty()){
			request.setAttribute("erreur", "L'identifiant est obligatoire. Veuillez le renseigner.");
			request.getRequestDispatcher("/WEB-INF/jsp/authentification.jsp").forward(request, response);
		} else if (request.getParameter("motDePasse").isEmpty()){
				request.setAttribute("erreur", "Le mot de passe est obligatoire. Veuillez le renseigner");
				request.getRequestDispatcher("/WEB-INF/jsp/authentification.jsp").forward(request, response);
		} else {
			//recuperation du pseudo et du mot de passe
			identifiant = request.getParameter("identifiant");
			motDePasse = request.getParameter("motDePasse");
			//verification de l'existence du couple en BDD
			try {
				utilisateur = DAOFactory.getUtilisateurDAO().connexionUtilisateur(identifiant,motDePasse);
				if (utilisateur== null){
					request.setAttribute("erreur", "L'utilisateur est inexistant. Veuillez vous inscrire en créant votre compte.");
					request.getRequestDispatcher("/WEB-INF/jsp/authentification.jsp").forward(request, response);
				} else {
//Boolean first = (boolean) request.getSession().getAttribute("first");
//System.out.println(first);

					Utilisateur utilisateurConnecte = utilisateur;
					request.getSession().setAttribute("utilisateurConnecte", utilisateurConnecte);
					request.getSession().setAttribute("first", true);
					request.getRequestDispatcher("/accueil.html?likeArticle=&idCategorie=1").forward(request, response);
				}
			
			} catch (DALException e) {
				request.setAttribute("erreur", e);
				this.getServletContext().getRequestDispatcher("/WEB-INF/erreur/erreur.jsp").forward(request, response);
			}

		}
	}

}
