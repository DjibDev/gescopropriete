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

import fr.coprotilleuls.bean.Resident;
import fr.coprotilleuls.bean.Role;
import fr.coprotilleuls.dao.ResidentDAO;
import fr.coprotilleuls.dao.RoleDAO;

/**
 * Servlet implementation class EditUsers
 */
@WebServlet("/admin/edit_users")
public class EditUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			int idResident = Integer.parseInt(request.getParameter("idResident"));
			Resident residentSelected = ResidentDAO.RecupProfil(idResident);
			 if (residentSelected != null) {
				 			 
				 request.setAttribute("residentSelected", residentSelected);
				 
				 List<Role> listeRoles= RoleDAO.getAll();
				 request.setAttribute("listeRoles", listeRoles);
				 
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/edit_users_jsp");
				 dispatcher.forward(request, response);
			 }else{
					List<Resident> listeResidents = null;
					
					try {
						listeResidents = ResidentDAO.getAll();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					request.setAttribute("listeResidents", listeResidents);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/accueil_admin_jsp");
					dispatcher.forward(request, response);
			 }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
