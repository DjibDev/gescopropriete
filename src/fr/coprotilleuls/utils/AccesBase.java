package fr.coprotilleuls.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesBase {
	private static String connectionString;
	private static String userString;
	private static String passwordString;
	static {
		try{
			//chargement du driver pour MySQL (paramètres externalisés dans le fichier settings.xml)
			Class.forName(Settings.getProperty("driver"));
			connectionString = Settings.getProperty("url");
			userString = Settings.getProperty("user");
			passwordString = Settings.getProperty("password");
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static Connection getConnection() throws SQLException{
		
		Connection connexion =  DriverManager.getConnection(connectionString,userString,passwordString);
		
		return connexion;		
	}
}
