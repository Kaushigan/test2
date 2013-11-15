
public class Main {

	
	public static void main(String[] args) {
		Modele2 unModele= new Modele2 ();
		unModele.connexion();
		unModele.insererContact(9, "Hari", "Fari");
		unModele.afficherBase();
		unModele.fermerConnexion();
	}

}
