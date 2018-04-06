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

import com.sun.net.httpserver.Authenticator.Result;

/**
 * Servlet implementation class Filter
 */

@WebServlet("/filter")
public class Cadastro extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastro() {
        super();    
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Statement stmt = null;
		Integer rs = null;
		
		String email = request.getParameter("email");
		String senha = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		out.println(email);
		out.println(senha);
		
		try {			
			String sql = "insert into Dados(email, senha)" + 
					"VALUES ('" + email + "', '"+senha+"')";
			stmt = ConFactory.getInstance().getConnection().createStatement();
			rs = stmt.executeUpdate(sql);
		}
	
		catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("Dados.html");	
	}
	
}
