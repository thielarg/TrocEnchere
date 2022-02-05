package fr.eni.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.beans.Article;
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
		try {
			//recuperation des categories pour charger la liste des categories dans la JSP
			categories = DAOFactory.getCategorieDAO().lister();

			request.getSession().setAttribute("first", true);
			request.setAttribute("message", "");
			//passage dans le contexte de session de la liste des categories
			request.getSession().setAttribute("categories", categories);
			//passage dans la contexte de session de l'idCategorie pour afficher la premiere categorie dans la liste
			request.setAttribute("idCategorie", 1); 			
			//delegation a la page d'accueil en mode deconnecte
			request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
		} catch (DALException e) {
			//chargement du message d'erreur dans le contexte de requete
			request.setAttribute("erreur", e);
			//delegation a la page d'erreur
			request.getRequestDispatcher("/erreur.html").forward(request, response);
		}
 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String likeArticle = "";
		int idCategorie = 1;
		ArrayList<Categorie> categories = new ArrayList<>();
		List<Article> articles = new ArrayList<>();
		String message="";
		int nbre = 0;

//Utilisateur u = (Utilisateur) request.getSession().getAttribute("utilisateurConnecte");
//System.out.println(u.getPseudo());
//Boolean first = (boolean) request.getSession().getAttribute("first");
//System.out.println(first);


		//recuperation des donnees saisies pour le filtre
		likeArticle = request.getParameter("likeArticle");
		idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
		try {
			if ((request.getSession().getAttribute("utilisateurConnecte") == null)|| (request.getSession().getAttribute("utilisateurConnecte") != null && (boolean) request.getSession().getAttribute("first"))) {
				//recupération des articles selon le filtre
				articles = DAOFactory.getArticleDAO().rechercher(likeArticle, idCategorie);
			} else {
				String type = request.getParameter("type");
				request.setAttribute("type", type);
				if(type.equals("encheres")){
					String[] encheres = request.getParameterValues("encheres");
					request.setAttribute("encheres", encheres);
					request.setAttribute("ventes", null);
				} else {
					String[] ventes = request.getParameterValues("ventes");
					request.setAttribute("encheres", null);
					request.setAttribute("ventes", ventes);
				}

//TODO : faire les requetes DAO et implemente la methode surchargée
				//recupération des articles selon le filtre
				articles = DAOFactory.getArticleDAO().rechercher(likeArticle, idCategorie);
			}
			if(articles.isEmpty()){
				message = "La liste est vide";
				request.getSession().setAttribute("first", true);		//à monter en session
			} else {
				nbre =articles.size();
				request.getSession().setAttribute("first", false);		//à monter en session
			}
			request.setAttribute("message", message);
			request.setAttribute("articles", articles);
			request.setAttribute("nbre", nbre);
			request.setAttribute("idCategorie", idCategorie);
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);

		} catch (DALException e) {
System.out.println(e.getMessage());
			request.setAttribute("erreur", e);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/erreur.jsp").forward(request, response);
		}
	}

}
