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

public class BatimentDAO {
	
	private static List<Batiment> listeBatiment = null;	
	private static Batiment batiment = null;
	private static Connection cnx = null;
	private static Statement rqtS = null;
	private static PreparedStatement rqt = null;
	private static ResultSet rs = null;
	
	private static final String SELECT_BY_ID = "SELECT adresse FROM BATIMENTS WHERE code = ? ";
	
	private static final String SELECT_ALL = "SELECT code, adresse FROM BATIMENTS ";
	
	public static Batiment getById(String code) throws SQLException{

		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SELECT_BY_ID);
			rqt.setString(1, code);
			rs=rqt.executeQuery();
			
			if (rs.next()){
				batiment = new Batiment();		
				batiment.setCode(code);
				batiment.setAdresse(rs.getString("adresse"));
			}
			// ...sinon on renvoie null
			else {
				batiment = null;
			}
			
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return batiment;
	}
	
	
	public static List<Batiment> getAll() throws SQLException{
			
			listeBatiment = new ArrayList<Batiment>(); 
			
			try {
				cnx = AccesBase.getConnection();
				rqtS = cnx.createStatement();
				rs = rqtS.executeQuery(SELECT_ALL);
				
				while (rs.next()){
					batiment = new Batiment();
					batiment.setCode(rs.getString("code"));
					batiment.setAdresse(rs.getString("adresse"));
					listeBatiment.add(batiment);
				}

			}finally{
				if (rs != null)
					rs.close();
				if (rqtS != null)
					rqtS.close();
				if (cnx != null)
					cnx.close();
			}
			
			
			return listeBatiment;
		}	
		

}
