package Servlets;

import java.io.IOException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Double id = Double.parseDouble(request.getParameter("idDelete"));

		Statement stmt = null;
		Integer rs = null;

		try {
			String sql = "DELETE FROM Dados WHERE (idDados = '" + id + "')";
			stmt = ConFactory.getInstance().getConnection().createStatement();
			rs = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String sql = "DELETE FROM informacoes WHERE (id = '" + id + "')";
			stmt = ConFactory.getInstance().getConnection().createStatement();
			rs = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("CrudOperation.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
