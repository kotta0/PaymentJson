package bg.jwd.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.jwd.bankejb.WebBank;
import bg.jwd.bankejb.WebBankImpl;

/**
 * Servlet implementation class BankOperation
 */
@WebServlet("/BankOperation")
public class BankOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankOperation() {
        super();
        // TODO Auto-generated constructor stub
    }
    @EJB
    private WebBank webBank;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String client = request.getParameter("client");
		String operation = request.getParameter("operation");
		Double amount = Double.parseDouble( request.getParameter("amount"));
		Double currentAmount;
		if ("deposit".equals(operation)){
			currentAmount = webBank.deposit(client,amount);
		}
		else{
			currentAmount = webBank.withdraw(client,amount);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Welcome.jsp");
		request.setAttribute("client", client);
		request.setAttribute("currentAmount", currentAmount);
		dispatcher.forward(request, response);
		//doGet(request, response);
	}

}
