package fr.eni.encheres.beans;

import java.io.Serializable;

/**
 * <font color="red">Classe <strong>JAVABEAN</strong> metier</font> Retrait permettant d'obtenir une instance de type Retrait
 * comprenant les attributs : <br>
 * <ul><li>article - identifiant principale</li><li>rue</li><li>codePostal</li><li>ville</li></ul>
 * @author Thierry
 *
 */
public class Retrait implements Serializable{

	private static final long serialVersionUID = 1L;
	//attributs
	private String rue;
	private String codePostal;
	private String ville;
	
	private Article article;

	/**
	 * <font color="green">Constructeur par defaut</font> permettant d'instancier un objet de type Retrait
	 */
	public Retrait() {
		super();
	}

	/**
	 * <font color="green">Constructeur surchargé</font> permettant d'instancier un objet de type Retrait et 
	 * d'hydrater ses attributs obligatoires
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param article
	 */
	public Retrait(String rue, String codePostal, String ville, Article article) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.article = article;
	}

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
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
	
	
}
