package fr.coprotilleuls.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.coprotilleuls.bean.Resident;
import fr.coprotilleuls.bean.Role;
import fr.coprotilleuls.dao.ResidentDAO;
import fr.coprotilleuls.dao.UserTempDAO;
import fr.coprotilleuls.utils.Outils;

/**
 * Servlet implementation class ValiderAcces
 */
@WebServlet("/login/valider_acces")
public class ValiderAcces extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValiderAcces() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession sessionPersonne = request.getSession(false);
		Resident residentConnecte;

		if (sessionPersonne != null
				&& sessionPersonne.getAttribute("residentConnecte") != null) {

			residentConnecte = (Resident) sessionPersonne
					.getAttribute("residentConnecte");
			Role role = residentConnecte.getRole();

			switch (role.getId()) {
			case "ADMIN":
				redirectionMenuAdministrateur(request, response);
				break;
			case "COPRO":
				redirectionMenuCoproprietaire(request, response);
				break;
			case "COSYN":
				redirectionMenuConseillerSyndical(request, response);
				break;
			case "GSACT":
				redirectionMenuGestionnaireActivites(request, response);
				break;
			case "LOCAT":
				redirectionMenuLocataire(request, response);
				break;
			default:
				redirectionMenuLocataire(request, response);
				break;
			}

		} else {
			String reponse = "Vous n'êtes pas identifié, veuillez saisir votre identifiant et mot de passe.";
			request.setAttribute("identificationEchouee", reponse);
			redirectionLogin(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Resident residentConnecte = null;

		String login = request.getParameter("login").trim();
		String password = request.getParameter("password");

		// s'il s'agit de la premiere connexion (id/mdp temporaire) alors on le
		// redirige vers l'inscription
		Boolean premiereConnexion;
		try {
			premiereConnexion = UserTempDAO.testFirstLogin(login, password);
			if (premiereConnexion) {
				request.setAttribute("idTemp", login);
				request.setAttribute("mdpTemp",password);
				
				redirectionInscription(request, response);
			} else {
				// chriffrement du mot de passe

				Outils o = new Outils();
				String passwordChiffre = o.Chiffrer(password);

				if (!("".equals(passwordChiffre))) {

					try {

						// on vérifie s'il s'agit de la premiere connexion
						// (login et mot de passe attribué,
						// dans ce cas on redirige l'utilisateur vers un
						// formulaire d'inscription

						Resident testConnexion = ResidentDAO.login(login,
								passwordChiffre);

						if (testConnexion != null) {

							residentConnecte = ResidentDAO
									.RecupProfil(testConnexion.getId());
							Role role = residentConnecte.getRole();

							// test si le resident est actif
							if (residentConnecte.isActif()) {
								// création de la session
								HttpSession sessionPersonne = request
										.getSession();
								sessionPersonne.setAttribute(
										"residentConnecte", residentConnecte);

								switch (role.getId()) {
								case "ADMIN":
									redirectionMenuAdministrateur(request,
											response);
									break;
								case "COPRO":
									redirectionMenuCoproprietaire(request,
											response);
									break;
								case "COSYN":
									redirectionMenuConseillerSyndical(request,
											response);
									break;
								case "GSACT":
									redirectionMenuGestionnaireActivites(
											request, response);
									break;
								case "LOCAT":
									redirectionMenuLocataire(request, response);
									break;
								default:
									redirectionMenuLocataire(request, response);
									break;
								}
							} else {
								String reponse = "Votre compte est résilié, veuillez contactez l'administrateur si vous pensez que c'est une erreur.";
								request.setAttribute("identificationEchouee",
										reponse);
								redirectionLogin(request, response);
							}

						} else {
							String reponse = "L'identification a échouée, veuillez resaisir votre identifiant et mot de passe.";
							request.setAttribute("identificationEchouee",
									reponse);
							redirectionLogin(request, response);
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {

					String reponse = "Le mot de passe n'a pas pu être chiffré, recommencez, si le problème persiste veuillez contacter l'administrateur.";
					request.setAttribute("identificationEchouee", reponse);
					redirectionLogin(request, response);
				}
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void redirectionInscription(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/login/inscription_jsp");
		dispatcher.forward(request, response);

	}

	private void redirectionMenuLocataire(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void redirectionMenuGestionnaireActivites(
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void redirectionMenuConseillerSyndical(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void redirectionMenuCoproprietaire(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void redirectionLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);

	}

	private void redirectionMenuAdministrateur(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Resident> listeResidents = null;

		try {
			listeResidents = ResidentDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("listeResidents", listeResidents);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/admin/accueil_admin_jsp");
		dispatcher.forward(request, response);
	}

}
