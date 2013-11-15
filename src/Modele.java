import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Modele {
	
	static Connection connexion = null;
	
	
	
	public static Connection connexion(){

		try{
			
			Class.forName("com.mysql.jdbc.Driver") ;
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/mabase", "root", "");
			
		}
		catch(SQLException erreur) {
			System.out.println("erreur de connexion" + erreur);
			}
	
		catch(ClassNotFoundException erreur){
			System.out.println("Driver non chargé !" + erreur);
		}
		return connexion;
	}
	
	

	public static void fermerConnexion(){
		try{
			connexion.close();
		}
		catch(SQLException erreur){
			System.out.println("erreur" + erreur);
			
		}
	}
	public static void insererContact(int unId, String unNom, String unPrenom){
		try{
		Statement st = connexion.createStatement();
		st.executeUpdate("INSERT INTO maTable (id, nom, prenom) VALUES ('"+unId+"','"+ unNom+"','"+ unPrenom +"');");
		
		}
		
		catch(SQLException erreur){
			System.out.println("erreur d'insertion" + erreur);
			
		}
	}
	
	public static void afficherBase(){
		try{
			Statement st = connexion.createStatement();
			ResultSet rs = st.executeQuery ("SELECT * FROM maTable");
		
			while (rs.next()) {
				int num = rs.getInt("id");
				String nom = rs.getString(2);
				String prenom=rs.getString("prenom");
				System.out.println("Code =" + num + "\nNom:" +nom+ "\nprenom:" + prenom ) ;
		}
			

		}
		catch(SQLException erreur){
			System.out.println("erreur d'affichage" + erreur);
		}
	}
	
	public static void supprimerContact(int unId, String unNom, String unPrenom){
		try{
			Statement st = connexion.createStatement();
			st.executeUpdate("DELETE FROM maTable (id, nom, prenom) VALUES ('"+unId+"','"+ unNom+"','"+ unPrenom +"');");
		}
		
		catch(SQLException erreur){
			System.out.println("erreur de suppression" + erreur);
			
		}
		
	}
	
}

