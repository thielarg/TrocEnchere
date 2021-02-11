package fr.eni.encheres.beans;

import java.io.Serializable;

/**
 * <font color="red">Classe <strong>JAVABEAN</strong> metier</font> Utilisateur permettant d'obtenir une instance de type Utilisateur
 * comprenant les attributs : <br>
 * <ul><li>noUtilisateur - identifiant principale</li><li>pseudo - identifiant secondaire permettant d'identifier un utilisateur de 
 * manière unique</li><li>nom</li><li>prenom</li><li>email - identifiant secondaire permettant d'identifier un utilisateur de 
 * manière unique</li><li>telephone - il n'est pas obligatoire</li><li>rue</li><li>codePostal</li><li>ville</li><li>motDePasse</li>
 * <li>credit - ce sont des points permettant de pouvoir faire des echanges</li><li>administrateur - <code>true</code> si administrateur, <code>false</code> si utilisateur</li></ul>
 * @author Thierry
 *
 */
public class Utilisateur implements Serializable{

	private static final long serialVersionUID = 1L;

	//attributs
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private boolean administrateur;

	
	/**
	 * <font color="green">Constructeur par defaut</font> permettant d'instancier un objet de type Utilisateur
	 */
	public Utilisateur() {
		super();
	}
	
	
	/**
	 * <font color="green">Constructeur surchargé</font> permettant d'instancier un objet de type Utilisateur et 
	 * d'hydrater ses attributs obligatoires
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur - booleen positionner à <code>vrai</code> pour identifier un utilisateur avec le role administrateur du site 
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, String rue, String codePostal,
			String ville, String motDePasse, int credit, boolean administrateur) {
		setPseudo(pseudo);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setMotDePasse(motDePasse);
		setCredit(credit);
		setAdministrateur(administrateur);
	}


	//accesseurs et mutateurs
	/**
	 * @return the noUtilisateur
	 */
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	/**
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}
	/**
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}
	/**
	 * @return the administrateur
	 */
	public boolean isAdministrateur() {
		return administrateur;
	}
	/**
	 * @param administrateur the administrateur to set
	 */
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}
	
	
}
