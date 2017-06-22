package bg.jwd.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter(urlPatterns="/*")
public class SecurityFilter implements Filter {
	// good practice to init the variables so to avoid NullPointExceptions
	private static final String username = "admin";
	private static final String password = "1234";
	
	
    /**
     * Default constructor. 
     */
    public SecurityFilter() {
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
	
				String username = (String) request.getParameter("username");
				String password = (String) request.getParameter("password");
				
				if ((username!=null) && (password!=null)){
					if(SecurityFilter.username.equals(username)&&SecurityFilter.password.equals(password)) {
						((HttpServletRequest) request).getSession().setAttribute("username",username);
						((HttpServletResponse) response).sendRedirect("/FiltersHomeWork/pages/HomePage.jsp");
					}else {
						((HttpServletResponse) response).sendRedirect("/FiltersHomeWork/login.jsp");	
					}
				}else {
					username = (String) ((HttpServletRequest) request).getSession().getAttribute("username") ;
					if(username==null){
						((HttpServletResponse) response).sendRedirect("/FiltersHomeWork/login.jsp");
					}
				}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
