package fr.eni.encheres.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.dao.ConnexionProvider;
import fr.eni.encheres.erreurs.DALException;

/**
 * Servlet implementation class TestConnexionServlet
 */
@WebServlet("/TestConnexionServlet")
public class TestConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestConnexionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection cnx=null;
		try {
			cnx= ConnexionProvider.seConnecter();
			response.getWriter().append("connexion OK");
		} catch (DALException e) {
			response.getWriter().append("connexion KO").append("\n").append(e.getMessage());
		} finally {
			try {
				ConnexionProvider.seDeconnecter(cnx);
			} catch (DALException e) {
				response.getWriter().append("probleme liberation connexion").append("\n").append(e.getMessage());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
