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

public class AppartementDAO {
	
	private static List<Appartement> listeAppartement = null;	
	private static Appartement appartement = null;
	private static Connection cnx = null;
	private static Statement rqtS = null;
	private static PreparedStatement rqt = null;
	private static ResultSet rs = null;
	
	private static final String SELECT_BY_ID = "SELECT num_syndic, porte, etage, batiment FROM APPARTEMENTS WHERE num = ? ";
	
	private static final String SELECT_ALL = "SELECT num, num_syndic, porte, etage, batiment FROM APPARTEMENTS ";
	
		
	public static Appartement GetById(int num) throws SQLException{

		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SELECT_BY_ID);
			rqt.setInt(1, num);
			rs=rqt.executeQuery();
			
			if (rs.next()){
				appartement = new Appartement();
				appartement.setNum_syndic(rs.getString("num_syndic"));
				appartement.setPorte(rs.getInt("porte"));
				appartement.setEtage(rs.getInt("etage"));
				Batiment batiment = BatimentDAO.getById(rs.getString("batiment"));
				appartement.setBatiment(batiment);
				
			}
			// ...sinon on renvoie null
			else {
				appartement = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return appartement;
	}
	
	
	public static List<Appartement> getAll() throws SQLException{
			
			listeAppartement = new ArrayList<Appartement>(); 
			try {
				cnx = AccesBase.getConnection();
				rqtS = cnx.createStatement();
				rs = rqtS.executeQuery(SELECT_ALL);
				
				while (rs.next()){
					appartement = new Appartement();
					appartement.setNum_syndic(rs.getString("num_syndic"));
					appartement.setPorte(rs.getInt("porte"));
					appartement.setEtage(rs.getInt("etage"));
					Batiment batiment = BatimentDAO.getById(rs.getString("batiment"));
					appartement.setBatiment(batiment);
					listeAppartement.add(appartement);
				}

			}finally{
				if (rs != null)
					rs.close();
				if (rqtS != null)
					rqtS.close();
				if (cnx != null)
					cnx.close();
			}
			
			
			return listeAppartement;
		}	
		


}
