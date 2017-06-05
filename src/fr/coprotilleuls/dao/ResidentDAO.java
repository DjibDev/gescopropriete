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
import fr.coprotilleuls.utils.AccesBase;

public class ResidentDAO {
	
	private static List<Resident> listeResident = null;	
	private static Resident resident = null;
	private static Appartement appartement = null;
	private static Connection cnx = null;
	private static Statement rqtS = null;
	private static PreparedStatement rqt = null;
	private static ResultSet rs = null;
	
	private static final String TEST_ACCES_RESIDENT = "SELECT id FROM RESIDENTS WHERE login=? AND mot_de_passe=? ";
	
	private static final String SELECT_ALL = "SELECT res.id as Rid, nom, prenom, login, tel, email, date_inscription, type_res, actif, "
			+ "r.id as idRole, libelle, ra.appartements as numAppart, "
			+ "etage, porte, num_syndic, b.code as bcode, adresse "
			+ "FROM RESIDENTS res INNER JOIN RESIDENTS_APPARTEMENTS ra ON res.id = ra.residents "
			+ "INNER JOIN APPARTEMENTS a ON ra.appartements = a.num	"
			+ "INNER JOIN BATIMENTS b ON a.batiment = b.code "
			+ "INNER JOIN ROLES r ON res.role = r.id "
			+ "ORDER BY nom ASC ";
	
	private static final String SELECT_APPARTS_UN_RESIDENT = "SELECT  res.id as Rid, nom, prenom, login, tel, email, date_inscription, type_res, actif, "
			+ "r.id as idRole, libelle, ra.appartements as numAppart, "
			+ "etage, porte, num_syndic, b.code as bcode, adresse "
			+ "FROM RESIDENTS res INNER JOIN RESIDENTS_APPARTEMENTS ra ON res.id = ra.residents "
			+ "INNER JOIN APPARTEMENTS a ON ra.appartements = a.num	"
			+ "INNER JOIN BATIMENTS b ON a.batiment = b.code "
			+ "INNER JOIN ROLES r ON res.role = r.id "
			+ "WHERE res.id = ? ";
	
	private static final String INSERT_ONE = "INSERT INTO RESIDENTS (nom, prenom, login, mot_de_passe, tel, email, date_inscription, type_res, actif, role) "
			+ "VALUES (?, ?, ?, ?, ?, ?, NOW(), ?, 1, ?) ";
	
	public static Resident login(String login, String password) throws SQLException{

		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(TEST_ACCES_RESIDENT);
			rqt.setString(1, login);
			rqt.setString(2, password);
			rs=rqt.executeQuery();
			// SI on trouve au moins 1 résultat, on prend le 1er pour mettre à jour les informations de du proprietaire utilisé pour la recherche.
			if (rs.next()){
				resident = new Resident();
				resident.setId(rs.getInt("id"));
			}	
			// ...sinon on renvoie null
			else {
				resident = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return resident;
	}
	
	public static List<Resident> getAll() throws SQLException{
			
			listeResident = new ArrayList<Resident>(); 
			try {
				cnx = AccesBase.getConnection();
				rqtS = cnx.createStatement();
				rs = rqtS.executeQuery(SELECT_ALL);
				
				while (rs.next()){
					resident = new Resident();
						resident.setId(rs.getInt("Rid"));
						resident.setNom(rs.getString("nom"));
						resident.setPrenom(rs.getString("prenom"));
						resident.setEmail(rs.getString("email"));
						resident.setLogin(rs.getString("login"));
						Date dateInscription = new Date();
						resident.setDate_inscription(new java.util.Date(rs.getDate("date_inscription").getTime()));
						resident.setTel(rs.getString("tel"));
						resident.setType_res(rs.getString("type_res"));
						Role role = new Role();
						role.setId(rs.getString("idRole"));
						role.setLibelle(rs.getString("libelle"));
						resident.setRole(role);
						resident.setActif(rs.getInt("actif") > 0 ? true : false);
						

										
						Batiment batiment = new Batiment();
						batiment.setCode(rs.getString("bcode"));
						batiment.setAdresse(rs.getString("adresse"));
						
						Appartement appartement= new Appartement();
						appartement.setBatiment(batiment);
						appartement.setEtage(rs.getInt("etage"));
						appartement.setPorte(rs.getInt("porte"));
						appartement.setNum(rs.getInt("numAppart"));
						appartement.setNum_syndic(rs.getString("num_syndic"));

						resident.setAppartement(appartement);
						
						listeResident.add(resident);
						
				}

			}finally{
				if (rs != null)
					rs.close();
				if (rqtS != null)
					rqtS.close();
				if (cnx != null)
					cnx.close();
			}
			
			
			return listeResident;
		}	
		
	public static Resident RecupProfil(int id) throws SQLException{
		
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SELECT_APPARTS_UN_RESIDENT);
			rqt.setInt(1, id);
			rs=rqt.executeQuery();
			// SI on trouve au moins 1 résultat, on prend le 1er pour mettre à jour les informations de du proprietaire utilisé pour la recherche.
			if (rs.next()){
				resident = new Resident();
				resident.setId(rs.getInt("Rid"));
				resident.setNom(rs.getString("nom"));
				resident.setPrenom(rs.getString("prenom"));
				resident.setEmail(rs.getString("email"));
				resident.setLogin(rs.getString("login"));
				Date dateInscription = new Date();
				resident.setDate_inscription(new java.util.Date(rs.getDate("date_inscription").getTime()));
				resident.setTel(rs.getString("tel"));
				resident.setType_res(rs.getString("type_res"));
				resident.setActif(rs.getInt("actif") > 0 ? true : false);
				
				Role role = new Role();
				role.setId(rs.getString("idRole"));
				role.setLibelle(rs.getString("libelle"));
				resident.setRole(role);
								
				Batiment batiment = new Batiment();
				batiment.setCode(rs.getString("bcode"));
				batiment.setAdresse(rs.getString("adresse"));
				
				Appartement appartement= new Appartement();
				appartement.setBatiment(batiment);
				appartement.setEtage(rs.getInt("etage"));
				appartement.setPorte(rs.getInt("porte"));
				appartement.setNum(rs.getInt("numAppart"));
				appartement.setNum_syndic(rs.getString("num_syndic"));

				resident.setAppartement(appartement);
				
			}
			// ...sinon on renvoie null
			else {
				resident = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return resident;
	}

	public static Boolean insert(Resident resident)	throws SQLException {
		boolean result;

		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(INSERT_ONE);
			rqt.setString(1, resident.getNom());
			rqt.setString(2, resident.getPrenom());
			rqt.setString(3, resident.getLogin());
			rqt.setString(4, resident.getMot_de_passe());
			rqt.setString(5, resident.getTel());
			rqt.setString(6, resident.getEmail());
			rqt.setString(7, resident.getType_res());
			rqt.setString(8, resident.getRole().getId());
			
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
