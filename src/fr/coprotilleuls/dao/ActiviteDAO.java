package fr.coprotilleuls.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.coprotilleuls.bean.Activite;
import fr.coprotilleuls.bean.Agenda;
import fr.coprotilleuls.utils.AccesBase;

public class ActiviteDAO {

	private static List<Activite> listeActivite = null;
	private static Activite activite = null;
	private static Connection cnx = null;
	private static Statement rqtS = null;
	private static PreparedStatement rqt = null;
	private static ResultSet rs = null;

	private static final String SELECT_BY_ID = "SELECT libelle, actif FROM ACTIVITES WHERE id = ? ";
	
	private static final String SELECT_ALL = "SELECT id, libelle, actif FROM ACTIVITES";

	private static final String INSERT_ONE = "INSERT INTO ACTIVITES (libelle, actif) VALUES (?, ?) ";


	public static Activite GetById(int num) throws SQLException {

		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SELECT_BY_ID);
			rqt.setInt(1, num);
			rs = rqt.executeQuery();

			if (rs.next()) {
				activite = new Activite();
				activite.setLibelle(rs.getString("libelle"));
				activite.setActif(rs.getInt("actif") > 0 ? true : false);

			}
			// ...sinon on renvoie null
			else {
				activite = null;
			}

		} finally {
			if (rs != null)
				rs.close();
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
		return activite;
	}

	public static List<Activite> getAllActif() throws SQLException {

		listeActivite = new ArrayList<Activite>();
		try {
			cnx = AccesBase.getConnection();
			rqtS = cnx.createStatement();
			rs = rqtS.executeQuery(SELECT_ALL);

			while (rs.next()) {
				activite = new Activite();
				activite.setId(rs.getInt("id"));
				activite.setLibelle(rs.getString("libelle"));
				activite.setActif(rs.getInt("actif") > 0 ? true : false);
				listeActivite.add(activite);
			}

		} finally {
			if (rs != null)
				rs.close();
			if (rqtS != null)
				rqtS.close();
			if (cnx != null)
				cnx.close();
		}

		return listeActivite;
	}

	public static Boolean insert(String libelle) throws SQLException {

		boolean result;

		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(INSERT_ONE);
			rqt.setString(1, libelle);
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


}
