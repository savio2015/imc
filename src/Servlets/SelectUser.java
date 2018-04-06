package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ExecuteSql
 */
@WebServlet("/SelectUser")
public class SelectUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Statement stmt = null;
		ResultSet rs = null;

		PrintWriter out = response.getWriter();
		
	//	Integer idUser = Integer.parseInt(request.getParameter("idSelect"));

		Double idUser = Double.parseDouble(request.getParameter("idSelect"));
		
//		try {
//			String sql = "SELECT idDados, email, senha FROM Dados WHERE idDados = '"+ idUser +"'";
//			stmt = ConFactory.getInstance().getConnection().createStatement();
//			rs = stmt.executeQuery(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			String sql = "SELECT id, nome, peso, altura, imc FROM informacoes WHERE id = '"+ idUser +"'";
//			stmt = ConFactory.getInstance().getConnection().createStatement();
//			rs = stmt.executeQuery(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		try {
//			String sql = "SELECT * FROM Dados WHERE (idDados = '" + idUser + "')";
//			stmt = ConFactory.getInstance().getConnection().createStatement();
//			rs = stmt.executeQuery(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			String sql = "SELECT * FROM informacoes WHERE (id = '" + idUser + "')";
//			stmt = ConFactory.getInstance().getConnection().createStatement();
//			rs = stmt.executeQuery(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		try {
			String sql = "select * from Dados where idDados = '" + idUser + "'";
			// ResultSet rs = stmt.executeQuery("SELECT *from Dados WHERE idDados = id");

			stmt = ConFactory.getInstance().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String sql = "select * from informacoes where id = '" + idUser + "'";
			stmt = ConFactory.getInstance().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
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
