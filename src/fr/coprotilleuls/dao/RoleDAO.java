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

public class RoleDAO {

	private static List<Role> listeRoles = null;
	private static Role role = null;
	private static Connection cnx = null;
	private static Statement rqtS = null;
	private static PreparedStatement rqt = null;
	private static ResultSet rs = null;
	
	private static final String SELECT_ALL = "SELECT id, libelle FROM ROLES";
		
	public static List<Role> getAll() throws SQLException{
		
		listeRoles = new ArrayList<Role>(); 
		
		try {
			cnx = AccesBase.getConnection();
			rqtS = cnx.createStatement();
			rs = rqtS.executeQuery(SELECT_ALL);
			
			
			while (rs.next()){
				role = new Role();
				role.setId(rs.getString("id"));
				role.setLibelle(rs.getString("libelle"));
				listeRoles.add(role);
					
			}

		}finally{
			if (rs != null)
				rs.close();
			if (rqtS != null)
				rqtS.close();
			if (cnx != null)
				cnx.close();
		}
		
		
		return listeRoles;
	}	
	

}

