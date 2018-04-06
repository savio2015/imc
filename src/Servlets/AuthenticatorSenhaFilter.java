package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet Filter implementation class AuthenticatorSenha
 */
@WebFilter("/filter")
public class AuthenticatorSenhaFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AuthenticatorSenhaFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String senha = request.getParameter("password");
		String ConfirmarSenha = request.getParameter("confirmPassword");
		if (senha != null && senha.equals(ConfirmarSenha)) {
			chain.doFilter(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("Senhas não conferem, cadastro bloqueado!");
			// por que não consegui colocar o comando response.sendRedirect("Dados.html");
			// aqui?
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
