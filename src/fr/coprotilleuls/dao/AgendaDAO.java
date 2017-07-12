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

public class AgendaDAO {

	private static List<Agenda> listeAgenda = null;
	private static Agenda agenda = null;
	private static Connection cnx = null;
	private static Statement rqtS = null;
	private static PreparedStatement rqt = null;
	private static ResultSet rs = null;

	private static final String SELECT_BY_ID = "SELECT libelle, annee, actif, activites FROM AGENDAS WHERE id = ? ";
	
	private static final String SELECT_ALL = "SELECT libelle, annee, actif, activites FROM AGENDAS";

	private static final String INSERT_ONE = "INSERT INTO AGENDAS (libelle, annee , actif, activites) VALUES (?, ?, ?) ";


	public static Agenda GetById(int num) throws SQLException {

		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SELECT_BY_ID);
			rqt.setInt(1, num);
			rs = rqt.executeQuery();

			if (rs.next()) {
				agenda = new Agenda();
				agenda.setLibelle(rs.getString("libelle"));
				agenda.setAnnee(rs.getInt("annee"));
				agenda.setActif(rs.getInt("actif") > 0 ? true : false);
				Activite activite = ActiviteDAO.GetById(rs.getInt("activites"));
				agenda.setActivite(activite);

			}
			// ...sinon on renvoie null
			else {
				agenda = null;
			}

		} finally {
			if (rs != null)
				rs.close();
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
		return agenda;
	}

	public static List<Agenda> getAllActif() throws SQLException {

		listeAgenda = new ArrayList<Agenda>();
		try {
			cnx = AccesBase.getConnection();
			rqtS = cnx.createStatement();
			rs = rqtS.executeQuery(SELECT_ALL);

			while (rs.next()) {
				agenda = new Agenda();
				agenda.setLibelle(rs.getString("libelle"));
				agenda.setAnnee(rs.getInt("annee"));
				agenda.setActif(rs.getInt("actif") > 0 ? true : false);
				Activite activite = ActiviteDAO.GetById(rs.getInt("activites"));
				agenda.setActivite(activite);
				listeAgenda.add(agenda);
			}

		} finally {
			if (rs != null)
				rs.close();
			if (rqtS != null)
				rqtS.close();
			if (cnx != null)
				cnx.close();
		}

		return listeAgenda;
	}

	public static Boolean insert(String libelle, int annee, int activite)	throws SQLException {

		boolean result;

		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(INSERT_ONE);
			rqt.setString(1, libelle);
			rqt.setInt(2, annee);
			rqt.setInt(3, activite);
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
