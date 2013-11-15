import java.sql.*;

public class Connexion {

	public static void main(String[] args) {
		Connection connexion = null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver") ;
			
		}
		catch(ClassNotFoundException erreur){
			System.out.println("Driver non charg� !" + erreur);
		}
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/mabase", "root", "");
			
		}
		catch(SQLException erreur) {
			System.out.println("erreur de connexion" + erreur);
			}
		
		try{
			Statement st = connexion.createStatement();
			st.executeUpdate("INSERT INTO maTable ( nom, prenom) VALUES ( 'Ravichandran', 'Kaushigan');");
			ResultSet rs = st.executeQuery ("SELECT * FROM maTable");
			
			// Pour acc�der � chacune des lignes du r�sultat de la requ�te :
			while (rs.next()) {
			int num = rs.getInt("id");
			String nom = rs.getString(2);
			String prenom=rs.getString("prenom");
			System.out.println("Code =" + num + "\nNom:" +nom+ "\nprenom:" + prenom ) ;
			}
			rs.close() ; // Permet de lib�rer la m�moire utilis�e.
			connexion.close();
		}
		catch(SQLException erreur){
			System.out.println("erreur" + erreur);
			
		}
		
		}
	}


