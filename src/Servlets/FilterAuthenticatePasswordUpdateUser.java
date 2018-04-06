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

/**
 * Servlet Filter implementation class FilterAuthenticatePasswordUpdateUser
 */
@WebFilter("/FilterAuthenticatePasswordUpdateUser")
public class FilterAuthenticatePasswordUpdateUser implements Filter {

    /**
     * Default constructor. 
     */
    public FilterAuthenticatePasswordUpdateUser() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String senha = request.getParameter("NewPassword");
		String ConfirmarSenha = request.getParameter("confirmNewPassword");
		if (senha != null && senha.equals(ConfirmarSenha)) {
			chain.doFilter(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("Senhas não conferem, atualização bloqueada!");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
