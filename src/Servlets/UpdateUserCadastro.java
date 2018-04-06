package Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

///**
// * Servlet implementation class UpdateUser
// */
@WebServlet("/FilterAuthenticatePasswordUpdateUser")
public class UpdateUserCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserCadastro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double idUpdate = Double.parseDouble(request.getParameter("idUpdate"));
		String email = request.getParameter("NewEmail");
		String senha = request.getParameter("NewPassword");
		Double altura = Double.parseDouble(request.getParameter("NewAltura"));
		Double peso = Double.parseDouble(request.getParameter("NewPeso"));
		
		PrintWriter out = response.getWriter();
		out.println(idUpdate);
		out.println(email);
		out.println(senha);
		
		Statement stmt = null;
		Integer rs = null;
		
		
		try {			
			String sql = "update Dados set email ='"+ email +"', senha = '" + senha + "' where idDados = '" + idUpdate + "'";
			stmt = ConFactory.getInstance().getConnection().createStatement();
			rs = stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		Double tamIMC = Math.pow(altura, 2);
		Double imc = peso / tamIMC;
		
		try {			
			String sql = "update informacoes set peso ='"+ peso +"', altura = '" + altura + "', imc = '" + imc  + "' where id = '" + idUpdate + "'";
			stmt = ConFactory.getInstance().getConnection().createStatement();
			rs = stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("CrudOperation.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String email = request.getParameter("NewEmail");
//		String senha = request.getParameter("NewPassword");
//		Double altura = Double.parseDouble(request.getParameter("NewAltura"));
//		Double peso = Double.parseDouble(request.getParameter("NewPeso"));
		
		
		
//		Statement stmt = null;
//		Integer rs = null;
//		
//		
//		try {			
//			String sql = "update Dados set email ='"+ email +"', senha = '" + senha + "' where id = '" + idDoUsuario + "'";
//			stmt = ConFactory.getInstance().getConnection().createStatement();
//			rs = stmt.executeUpdate(sql);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		Double tamIMC = Math.pow(altura, 2);
//		Double imc = peso / tamIMC;
//		
//		try {			
//			String sql = "update informacoes set peso ='"+ peso +"', altura = '" + altura + "', imc = '" + imc + "' where id = '" + idDoUsuario + "'";
//			stmt = ConFactory.getInstance().getConnection().createStatement();
//			rs = stmt.executeUpdate(sql);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}	
//		response.sendRedirect("CrudOperation.html");
	}
}
