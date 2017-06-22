package bg.jwd.servlets;

import java.io.IOException;
import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.jwd.ejb.SingletonBean;
import bg.jwd.ejb.StatefullHelloWorld;
import bg.jwd.ejb.StatelessHelloWorld;
import bg.jwd.ejb.StatelessHelloWorldImpl;

/**
 * Servlet implementation class EJBServletTest
 */
@WebServlet("/EJBServletTest")
public class EJBServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EJBServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }
    @EJB
    private StatelessHelloWorld statelessHelloWorld;
    @EJB
    private StatefullHelloWorld statefullHelloWorld;
    @EJB
    private SingletonBean singletonBean;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//StatelessHelloWorldImpl example = new StatelessHelloWorldImpl();
		String ipRequestAddress = ((ServletRequest ) request).getLocalAddr();
		 
		response.getWriter().println(statelessHelloWorld.helloStatelessEjb(ipRequestAddress));
		response.getWriter().println(statefullHelloWorld.helloStatefullEjb());
		System.out.println("");
		response.getWriter().println(singletonBean.singletonHelloWorld());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
