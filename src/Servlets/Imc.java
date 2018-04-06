package Servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Scanner;

/**
 * Servlet implementation class imc
 */
@WebServlet("/imc")
public class Imc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Imc() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Statement stmt = null;
		Integer rs = null;
		int id;

		String nome = request.getParameter("nome");
		double altura = Double.parseDouble(request.getParameter("altura"));
		double peso = Double.parseDouble(request.getParameter("peso"));
		
		PrintWriter out = response.getWriter();
		
		Double tamIMC = Math.pow(altura, 2);
		Double imc = peso / tamIMC;

		try {			
			String sql = "insert into informacoes(nome, peso, altura, imc)" + 
					"VALUES ('" + nome + "', '"+ peso +"', '" + altura +"', '" + imc + "')";
			stmt = ConFactory.getInstance().getConnection().createStatement();
			rs = stmt.executeUpdate(sql);
		}
	
		catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("CrudOperation.html");
	}
}

