package fr.coprotilleuls.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.coprotilleuls.bean.Appartement;
import fr.coprotilleuls.bean.Batiment;
import fr.coprotilleuls.utils.AccesBase;

public class AppartementDAO {

	private static List<Appartement> listeAppartement = null;
	private static Appartement appartement = null;
	private static Connection cnx = null;
	private static Statement rqtS = null;
	private static PreparedStatement rqt = null;
	private static ResultSet rs = null;

	private static final String SELECT_BY_ID = "SELECT num_syndic, porte, etage, batiment FROM APPARTEMENTS WHERE num = ? ";

	private static final String RECUPERER_NUM = "SELECT num FROM APPARTEMENTS WHERE porte = ? AND etage = ? AND batiment = ? "; 
	
	private static final String SELECT_ALL = "SELECT num, num_syndic, porte, etage, batiment FROM APPARTEMENTS ";

	private static final String INSERT_ONE = "INSERT INTO APPARTEMENTS (porte, etage , batiment) "
			+ "VALUES (?, ?, ?) ";

	private static final String LIER_RESIDENT_APPARTEMENTS = "INSERT INTO RESIDENTS_APPARTEMENTS (residents, appartements) "
			+ " VALUES (? ,?) ";

	public static Appartement GetById(int num) throws SQLException {

		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SELECT_BY_ID);
			rqt.setInt(1, num);
			rs = rqt.executeQuery();

			if (rs.next()) {
				appartement = new Appartement();
				appartement.setNum_syndic(rs.getString("num_syndic"));
				appartement.setPorte(rs.getInt("porte"));
				appartement.setEtage(rs.getInt("etage"));
				Batiment batiment = BatimentDAO.getById(rs
						.getString("batiment"));
				appartement.setBatiment(batiment);

			}
			// ...sinon on renvoie null
			else {
				appartement = null;
			}

		} finally {
			if (rs != null)
				rs.close();
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
		return appartement;
	}

	public static List<Appartement> getAll() throws SQLException {

		listeAppartement = new ArrayList<Appartement>();
		try {
			cnx = AccesBase.getConnection();
			rqtS = cnx.createStatement();
			rs = rqtS.executeQuery(SELECT_ALL);

			while (rs.next()) {
				appartement = new Appartement();
				appartement.setNum_syndic(rs.getString("num_syndic"));
				appartement.setPorte(rs.getInt("porte"));
				appartement.setEtage(rs.getInt("etage"));
				Batiment batiment = BatimentDAO.getById(rs
						.getString("batiment"));
				appartement.setBatiment(batiment);
				listeAppartement.add(appartement);
			}

		} finally {
			if (rs != null)
				rs.close();
			if (rqtS != null)
				rqtS.close();
			if (cnx != null)
				cnx.close();
		}

		return listeAppartement;
	}

	public static Boolean insert(int porte, int etage, String batiment)	throws SQLException {

		boolean result;

		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(INSERT_ONE);
			rqt.setInt(1, porte);
			rqt.setInt(2, etage);
			rqt.setString(3, batiment);
			int retour = rqt.executeUpdate();

			if (retour == 1) {
				result = true;
			} else {
				result = false;
			}

		} finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}

		return result;
	}

	public static Boolean lierResidentAppartement(int idResident,int numAppart) throws SQLException {

		boolean result;

		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(LIER_RESIDENT_APPARTEMENTS);
			rqt.setInt(1, idResident);
			rqt.setInt(2, numAppart);
			int retour = rqt.executeUpdate();

			if (retour == 1) {
				result = true;
			} else {
				result = false;
			}

		} finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}

		return result;
	}


	public static int recupererNum(int porte, int etage, String batiment) throws SQLException {
		
		int numAppart = 0;
		
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(RECUPERER_NUM);
			rqt.setInt(1, porte);
			rqt.setInt(2, etage);
			rqt.setString(3, batiment);
			rs = rqt.executeQuery();

			rs.next();
			numAppart = rs.getInt("num");
			
		} finally {
			if (rs != null)
				rs.close();
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
		
				
		return numAppart;
	}

}
