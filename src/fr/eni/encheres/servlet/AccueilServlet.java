package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.beans.Categorie;
import fr.eni.encheres.dao.DAOFactory;
import fr.eni.encheres.erreurs.DALException;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet(
		name="AccueilServlet",
		urlPatterns= {"/accueil.html","/accueil.html?likeArticle=&idCategorie=1"}
		)
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO traitement concernant l'affichage de la page d'accueil en mode deconnecté
		List<Categorie> categories = new ArrayList<>();
		//recupération des catégories
		try {
			categories = DAOFactory.getCategorieDAO().lister();
			request.getSession().setAttribute("first", true);						//à monter en session
			request.setAttribute("message", "");
			//passage de la liste des catégories en session
			request.getSession().setAttribute("categories", categories);
			request.setAttribute("idCategorie", 1);
			//delegation à la page d'accueil en mode deconnecté
			request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
		} catch (DALException e) {
			// TODO deleger à la page d'erreur
			e.printStackTrace();
		}
 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ?
	}

}
