package fr.eni.encheres.erreurs;

/**
 * <font color="red">Classe</font> DalException specialisant la classe Exception et permmettant 
 * de surcharger les constructeurs utilisees ainsi que la methode getMessage
 * @author Thierry
 *
 */
public class DALException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * <font color="green">Constructeur par defaut</font> permettant d'instancier un objet de type DALException
	 */
	public DALException() {
		super();
	}

	/**
	 * <font color="green">Constructeur surchargé</font> permettant d'instancier un objet de type DALException et 
	 * d'hydrater l'attribut message herité de la classe mere Exception
	 * @param message - message de l'exception
	 */
	public DALException(String message) {
		super(message);
	}

	/**
	 * <font color="green">Constructeur surchargé</font> permettant d'instancier un objet de type DALException et 
	 * d'hydrater les attributs message et cause herités de la classe mere Exception
	 * @param message - message de l'exception
	 * @param cause - cause de l'exception
	 */
	public DALException(String message, Throwable cause) {
		super(message, cause);
	}


	/**
	 * <font color="green">Methode</font> qui redefinie la methode getMessage() de la classe Throwable<br>
	 * permettant de specialiser l'affichage du message d'erreur 
	 */
	@Override
	public String getMessage() {
		StringBuffer sb =new StringBuffer();
		sb.append("Couche DAL - "+super.getMessage());
		return sb.toString();
	}
	
	
	
}





