package fr.eni.encheres.beans;

import java.io.Serializable;

/**
 * <font color="red">Classe <strong>JAVABEAN</strong> metier</font> Categorie permettant d'obtenir une instance de type Categorie
 * comprenant les attributs : <br>
 * <ul><li>noCategorie - identifiant principale</li><li>libelle</li></ul>
 * @author Thierry
 *
 */
public class Categorie implements Serializable{

	private static final long serialVersionUID = 1L;
	//attributs
	private int noCategorie;
	private String libelle;
	
	
	/**
	 * <font color="green">Constructeur par defaut</font> permettant d'instancier un objet de type Categorie
	 */
	public Categorie() {
		super();
	}
	
	
	/**
	 * <font color="green">Constructeur surchargé</font> permettant d'instancier un objet de type Categorie et 
	 * d'hydrater son attribut obligatoire
	 * @param libelle
	 */
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}


	/**
	 * @return the noCategorie
	 */
	public int getNoCategorie() {
		return noCategorie;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
