package SIC.Projetstylo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class connexionsql {
	
	Connection connection;
	
	public connexionsql() {
		try {
			String url = "jdbc:postgresql://bd-pedago.univ-lyon1.fr:5432/p2018870";
			 Properties props = new Properties();
			 props.setProperty("user","p2018870");
			 props.setProperty("password","Xt0nVpWCFxxq");
			 this.connection = DriverManager.getConnection(url, props);
			 System.out.println("Connecté à la base de données PostgreSQL!");
			 
			 } catch (SQLException e) {
			 System.out.println("Connection failure.");
			 e.printStackTrace();
			 }
	}
	
	public List getPID() throws SQLException {
		List<String> PID = new ArrayList<String>(); 
		Statement statement = this.connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT PID FROM Produit");
		while(resultSet.next())PID.add(resultSet.getString("PID"));
		return PID;
		 }
	
	public List getPNOM() throws SQLException {
		List<String> Pnom = new ArrayList<String>(); 
		Statement statement = this.connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Produit");
		 while(resultSet.next()) Pnom.add(resultSet.getString("PNOM"));
		 return Pnom;
		 }
	
	public List getPMAJEUR() throws SQLException {
		List<String> Pmajeur = new ArrayList<String>(); 
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM Composition");
		while(resultSet.next()) Pmajeur.add(resultSet.getString("PMajeur"));
		 return Pmajeur;
		 }
	
	public List getPMINEUR() throws SQLException {
		List<String> Pmineur =new ArrayList<String>();
		Statement statement = this.connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM composition");
		while(resultSet.next()) Pmineur.add(resultSet.getString("PMineur"));
		 return Pmineur;
		 }
}
