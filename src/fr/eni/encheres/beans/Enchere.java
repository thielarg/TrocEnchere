package fr.eni.encheres.beans;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <font color="red">Classe <strong>JAVABEAN</strong> metier</font> Enchere permettant d'obtenir une instance de type Enchere
 * comprenant les attributs : <br>
 * <ul><li>article + utilisateur - identifiant principale</li><li>dateEnchere</li><li>montantEnchere</li></ul>
 * @author Thierry
 *
 */
public class Enchere implements Serializable{

	private static final long serialVersionUID = 1L;
	//attributs
	private LocalDate dateEnchere;
	private int montantEnchere;
	
	private Article article;
	private Utilisateur utilisateur;
	
	
	/**
	 * <font color="green">Constructeur par defaut</font> permettant d'instancier un objet de type Enchere
	 */
	public Enchere() {
		super();
	}
	/**
	 * <font color="green">Constructeur surchargé</font> permettant d'instancier un objet de type Enchere et 
	 * d'hydrater ses attributs obligatoires
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param article
	 * @param utilisateur
	 */
	public Enchere(LocalDate dateEnchere, int montantEnchere, Article article, Utilisateur utilisateur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.article = article;
		this.utilisateur = utilisateur;
	}
	/**
	 * @return the dateEnchere
	 */
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	/**
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}
	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}
	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}
	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
