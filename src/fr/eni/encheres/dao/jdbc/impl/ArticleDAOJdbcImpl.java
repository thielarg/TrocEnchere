package fr.eni.encheres.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.beans.Article;
import fr.eni.encheres.beans.Utilisateur;
import fr.eni.encheres.dao.ArticleDAO;
import fr.eni.encheres.dao.ConnexionProvider;
import fr.eni.encheres.erreurs.DALException;

public class ArticleDAOJdbcImpl implements ArticleDAO{
	private static final String RECHERCHER = "SELECT nom_article, prix_initial, date_fin_encheres, pseudo "
			+ "FROM ARTICLES a "
			+ "INNER JOIN UTILISATEURS u ON a.no_utilisateur=u.no_utilisateur "
			+ "WHERE no_categorie=? and nom_article LIKE ?;";

	@Override
	public List<Article> rechercher(String likeArticle, int idCategorie) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Article> articles=new ArrayList<Article>();
		Article article=null;
		
		likeArticle = "%"+likeArticle+"%";
		cnx = ConnexionProvider.seConnecter();
		
		try {
			pstmt = cnx.prepareStatement(RECHERCHER);
			pstmt.setInt(1, idCategorie);
			pstmt.setString(2, likeArticle);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				article = new Article();
				article.setNomArticle(rs.getString("nom_article"));
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setDateFinEncheres(rs.getTimestamp("date_fin_encheres").toLocalDateTime().toLocalDate());
				article.setVendeur(new Utilisateur(rs.getString("pseudo"), null, null, null, null, null, null, null, 0, false));
				articles.add(article);
			}
			
		} catch (SQLException e) {
			throw new DALException("probleme methode rechercher()", e);
		} finally {
			ConnexionProvider.seDeconnecter(pstmt, cnx);
		}
		
		return articles;
	}

	@Override
	public ArrayList<Article> rechercher(String likeArticle, int idCategorie, String type, String[] encheres,
			String[] ventes) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
