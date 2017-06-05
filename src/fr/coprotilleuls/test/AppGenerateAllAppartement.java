package fr.coprotilleuls.test;

import java.sql.SQLException;

import fr.coprotilleuls.dao.AppartementDAO;

public class AppGenerateAllAppartement {

	public static void main(String[] args) {
		
		String batTilleuls[] = {"B1","B2"};
		String batCholiere[]= {"B3A","B3B","B3D","B3D","B3E"};
		
		for (String bat : batTilleuls) {
			// possibilité d'etage
			for (int i = 0; i <= 3; i++) {
				// possibilité de porte
				for (int j = 1; j <= 4; j++) {
					try {
						AppartementDAO.insert(j, i, bat);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		for (String bat : batCholiere) {
			// possibilité d'etage
			for (int i = 0; i <= 4; i++) {
				// possibilité de porte
				for (int j = 1; j <= 4; j++) {
					try {
						AppartementDAO.insert(j, i, bat);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
			
	}

}
