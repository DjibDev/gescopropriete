	package fr.coprotilleuls.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.coprotilleuls.bean.Resident;
import fr.coprotilleuls.bean.Role;
import fr.coprotilleuls.dao.AppartementDAO;
import fr.coprotilleuls.dao.ResidentDAO;
import fr.coprotilleuls.dao.UserTempDAO;
import fr.coprotilleuls.utils.Outils;

/**
 * Servlet implementation class ValiderInscription
 */
@WebServlet("/login/valider_inscription")
public class ValiderInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValiderInscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// récupération des champs du formulaire

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String tel = request.getParameter("telephone");
		String type_res = request.getParameter("type_res");
		String identifiant = request.getParameter("identifiant");
		String password = request.getParameter("password");

		// chiffrement du password
		Outils o = new Outils();
		String passwordChiffre = o.Chiffrer(password);

		// creation du résident pour insertion
		Resident newR = new Resident();
		newR.setNom(nom);
		newR.setPrenom(prenom);
		newR.setEmail(email);
		newR.setTel(tel);

		switch (type_res) {
		case "1":
			type_res = "Locataire";
			break;
		case "2":
			type_res = "Propriétaire résident";
			break;
		case "3":
			type_res = "Propriétaire non-résident";
			break;

		}

		newR.setType_res(type_res);
		newR.setLogin(identifiant);	
				
		newR.setMot_de_passe(passwordChiffre);
		// on lui assigne le role minimum au debut
		Role role = new Role();
		role.setId("LOCAT");
		newR.setRole(role);

		// recuperation des elements appartements
		int porte = Integer.parseInt(request.getParameter("porte"));
		int etage = Integer.parseInt(request.getParameter("etage"));
		String batiment = request.getParameter("batiment");

		String idTemp = request.getParameter("idTemp");
		String mdpTemp = request.getParameter("mdpTemp");

		try {
			
			int idGenerated; 
			// insertion du résident et retour de l'id généré
			idGenerated= ResidentDAO.insert(newR);
			if (idGenerated != 0)
			{	
				 // recuperation l'appartement
				int numAppart = AppartementDAO.recupererNum(porte, etage, batiment);
				// lie appartement resident
				AppartementDAO.lierResidentAppartement(idGenerated, numAppart);
	
				// suppression des id Mdp temporaires
				UserTempDAO.delete(idTemp, mdpTemp);
	
				String reponse = "Votre inscription a bien été enregistrée, vous pouvez désormais vous connecter avec votre identifiant et votre mot de passe.";
				request.setAttribute("inscriptionReussie", reponse);
			 }


		} catch (SQLException e) {
			e.printStackTrace();
			String reponse = "Votre inscription a échouée, veuillez recommencer ultérieurement";
			request.setAttribute("identificationEchouee", reponse);
		}

		redirectionLogin(request, response);

	}

	private void redirectionLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);

	}
}
