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

import fr.coprotilleuls.bean.Activite;
import fr.coprotilleuls.bean.Agenda;
import fr.coprotilleuls.bean.UserTemp;
import fr.coprotilleuls.dao.ActiviteDAO;
import fr.coprotilleuls.dao.AgendaDAO;
import fr.coprotilleuls.dao.UserTempDAO;

/**
 * Servlet implementation class GestionCalendriers
 */
@WebServlet("/admin/gestion_calendriers")
public class GestionCalendriers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCalendriers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Activite> listeActivites = null;
		try {
			listeActivites = ActiviteDAO.getAllActif();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("listeActivites", listeActivites);
			
		
		List<Agenda> listeCalendriers = null;
		try {
			listeCalendriers = AgendaDAO.getAllActif();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("listeCalendriers", listeCalendriers);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/gestion_calendriers_jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
