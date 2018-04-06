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

import com.sun.glass.ui.Application;
import com.sun.java.swing.plaf.windows.resources.windows;

import java.util.Scanner;

/**
 * Servlet implementation class CrudOperations
 */
@WebServlet("/SelectOperation")
public class SelectOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectOperation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String radio = request.getParameter("opcao");
		Statement stmt = null;
		Integer rs = null;

		if (radio.equals("insert")) {
			response.sendRedirect("Cadastro.html");
		}
		if (radio.equals("select")) {
			response.sendRedirect("SelectPage.html");
		}
		if (radio.equals("update")) {
			response.sendRedirect("UpdatePage.html");
		}
		if (radio.equals("delete")) {
			response.sendRedirect("DeletePage.html");
		}
		if (radio.equals("clearbanco")) {
			try {
				String sql = "truncate table Dados";
				stmt = ConFactory.getInstance().getConnection().createStatement();
				rs = stmt.executeUpdate(sql);
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				String sql = "truncate table informacoes";
				stmt = ConFactory.getInstance().getConnection().createStatement();
				rs = stmt.executeUpdate(sql);
			} catch (Exception e) {
				// TODO: handle exception
			}
			response.sendRedirect("CrudOperation.html");
		}
		 if(radio.equals("sair")) {
			 response.sendRedirect("ExitSystem.html");
		 }
	}
}
