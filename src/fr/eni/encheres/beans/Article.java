package fr.eni.encheres.beans;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <font color="red">Classe <strong>JAVABEAN</strong> metier</font> Article permettant d'obtenir une instance de type Article
 * comprenant les attributs : <br>
 * <ul><li>noArticle - identifiant principale</li><li>nomArticle</li><li>description</li><li>dateDebutEncheres</li><li>dateFinEncheres</li>
 * <li>miseAPrix : prix initial</li><li>prixVente</li></ul>
 * @author Thierry
 *
 */
public class Article implements Serializable{

	private static final long serialVersionUID = 1L;
	//attributs
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres; 
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	
	private Utilisateur acheteur;
	private Utilisateur vendeur;
	
	private Categorie categorie;

	
	/**
	 * <font color="green">Constructeur par defaut</font> permettant d'instancier un objet de type Article
	 */
	public Article() {
		super();
	}

	/**
	 * <font color="green">Constructeur surchargé</font> permettant d'instancier un objet de type Article et 
	 * d'hydrater ses attributs obligatoires
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEncheres
	 * @param dateFinEncheres
	 * @param vendeur
	 * @param categorie
	 */
	public Article(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Utilisateur vendeur, Categorie categorie) {
		setNomArticle(nomArticle);
		setDescription(description);
		setDateDebutEncheres(dateDebutEncheres);
		setDateFinEncheres(dateFinEncheres);
		setVendeur(vendeur);
		setCategorie(categorie);
	}

	/**
	 * @return the nomArticle
	 */
	public String getNomArticle() {
		return nomArticle;
	}

	/**
	 * @param nomArticle the nomArticle to set
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the dateDebutEncheres
	 */
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	/**
	 * @param dateDebutEncheres the dateDebutEncheres to set
	 */
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	/**
	 * @return the dateFinEncheres
	 */
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	/**
	 * @param dateFinEncheres the dateFinEncheres to set
	 */
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	/**
	 * @return the miseAPrix
	 */
	public int getMiseAPrix() {
		return miseAPrix;
	}

	/**
	 * @param miseAPrix the miseAPrix to set
	 */
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	/**
	 * @return the prixVente
	 */
	public int getPrixVente() {
		return prixVente;
	}

	/**
	 * @param prixVente the prixVente to set
	 */
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	/**
	 * @return the acheteur
	 */
	public Utilisateur getAcheteur() {
		return acheteur;
	}

	/**
	 * @param acheteur the acheteur to set
	 */
	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}

	/**
	 * @return the vendeur
	 */
	public Utilisateur getVendeur() {
		return vendeur;
	}

	/**
	 * @param vendeur the vendeur to set
	 */
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the noArticle
	 */
	public int getNoArticle() {
		return noArticle;
	}

	
}
