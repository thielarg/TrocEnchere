package fr.eni.encheres.dao.jdbc.impl;

import java.util.ArrayList;

import fr.eni.encheres.beans.Article;
import fr.eni.encheres.dao.ArticleDAO;
import fr.eni.encheres.erreurs.DALException;

public class ArticleDAOJdbcImpl implements ArticleDAO{

	@Override
	public ArrayList<Article> rechercher(String likeArticle, int idCategorie) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Article> rechercher(String likeArticle, int idCategorie, String type, String[] encheres,
			String[] ventes) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
