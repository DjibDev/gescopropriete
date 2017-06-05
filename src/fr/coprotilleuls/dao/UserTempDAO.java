package fr.coprotilleuls.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.coprotilleuls.bean.Appartement;
import fr.coprotilleuls.bean.Batiment;
import fr.coprotilleuls.bean.Resident;
import fr.coprotilleuls.bean.Role;
import fr.coprotilleuls.bean.UserTemp;
import fr.coprotilleuls.utils.AccesBase;

public class UserTempDAO {

	private static List<UserTemp> listeUtilsateursTemporaires = null;
	private static UserTemp utilsateurTemporaire = null;
	private static Connection cnx = null;
	private static Statement rqtS = null;
	private static PreparedStatement rqt = null;
	private static ResultSet rs = null;
	
	private static final String TEST_PREMIERE_CONNEXION = "SELECT id FROM USERS_TEMP WHERE champs1=? AND champs2=? AND used = ?";
	
	private static final String LST_ID_TEMP_DISPO = "SELECT id, champs1, champs2 FROM USERS_TEMP WHERE used = ? ";
	
	private static final String INSERT_NEW_COMPTE ="INSERT INTO USERS_TEMP (champs1, champs2, used) VALUES (?, ?, ?) ";
	
	private static final String DELETE_COMPTE_TEMP ="DELETE FROM USERS_TEMP WHERE champs1 = ? AND champs2 = ? ";
	
	public static boolean testFirstLogin(String login, String password) throws SQLException{
		
		boolean firstLogin;
		
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(TEST_PREMIERE_CONNEXION);
			rqt.setString(1, login);
			rqt.setString(2, password);
			rqt.setBoolean(3, false);
			rs=rqt.executeQuery();
			
			if (rs.next()){
				firstLogin = true;
			}	
			// ...sinon on renvoie false
			else {
				firstLogin = false;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return firstLogin;
	}
	
	public static List<UserTemp> getAllDispo() throws SQLException{
		
		listeUtilsateursTemporaires = new ArrayList<UserTemp>(); 
		
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(LST_ID_TEMP_DISPO);
			rqt.setBoolean(1, false);
			rs = rqt.executeQuery();
			
			
			while (rs.next()){
				utilsateurTemporaire = new UserTemp();
				utilsateurTemporaire.setId(rs.getInt("id"));
				utilsateurTemporaire.setChamps1(rs.getString("champs1"));
				utilsateurTemporaire.setChamps2(rs.getString("champs2"));	
				listeUtilsateursTemporaires.add(utilsateurTemporaire);
					
			}

		}finally{
			if (rs != null)
				rs.close();
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
		
		
		return listeUtilsateursTemporaires;
	}	
	
	public static boolean insert(String champs1, String Champ2, Boolean used) throws SQLException{
		
		boolean result;
		
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(INSERT_NEW_COMPTE);
			rqt.setString(1,champs1);
			rqt.setString(2,Champ2);
			rqt.setBoolean(3, used);
			int retour = rqt.executeUpdate();
			
			if (retour == 1){
				result = true;
			}
			else
			{
				result = false;
			}

		}finally{
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
		
		return result;
	}

	public static boolean delete(String idTemp, String mdpTemp) throws SQLException {
	
		boolean result;
		
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(DELETE_COMPTE_TEMP);
			rqt.setString(1, idTemp);
			rqt.setString(2, mdpTemp);
			int retour = rqt.executeUpdate();
			
			if (retour == 1){
				result = true;
			}	
			else {
				result = false;
			}
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
		return result;
		
	}
}

