package fr.coprotilleuls.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Array;

import fr.coprotilleuls.bean.UserTemp;
import fr.coprotilleuls.dao.UserTempDAO;
import fr.coprotilleuls.utils.Outils;

/**
 * Servlet implementation class GenererCompteTemp
 */
@WebServlet("/admin/generer_compte_temp")
public class GenererCompteTemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenererCompteTemp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int  nbrIdToGenerate = Integer.parseInt(request.getParameter("nbrIdToGenerate"));
		
		boolean retourInsert;
		List<Boolean> lstRetourInsert= new ArrayList<Boolean>();
		
		Outils o = new Outils();
		for (int i = 0; i < nbrIdToGenerate; i++) {
			String loginGen= o.GenererLogin();
			String mdpGen= o.GenererPassword();
			
			try {
				retourInsert= UserTempDAO.insert(loginGen, mdpGen, false);
				lstRetourInsert.add(retourInsert);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

		if (!lstRetourInsert.contains(false)){
			String reponse="Les comptes temporaires ont bien été générés !";
			request.setAttribute("generationCompteReussie",reponse);
		}
		else
		{
			String reponse="Les comptes temporaires n'ont pas pu être générés...";
			request.setAttribute("generationCompteEchouee",reponse);
		}
		
		List<UserTemp> listeUtilisateursTemporaires = null;
		
		try {
			listeUtilisateursTemporaires = UserTempDAO.getAllDispo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("listeUtilisateursTemporaires", listeUtilisateursTemporaires);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/gestion_users_jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
