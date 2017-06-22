package com.javatesttask.george.payment;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;



/**
 * Servlet implementation class PaymentJsonServlet
 */
@WebServlet("/PaymentJsonServlet")
public class PaymentJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String URl_API_PAYMENT = "http://sandbox-pay.jeton.com/merchant/initiate-payment";
	private static final String URl_API_AOUTH = "http://sandbox-pay.jeton.com/merchant/authorize";
	private static final String API_KEY = "fec5b073762b4726af7d6a151f30b7ab";
	private static final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1MDAiLCJtZXJjaGFudElkIjo1MDAsInBheW1lbnRJZCI6ODA4NSwiZXhwIjoxNDk3OTc3MTkzLCJpYXQiOjE0OTc5NzM1OTN9.CgirY2m25FiW_MVdUc1od4XYI3aOEptjfrrvbtycjkDdj-CM009avXe26VfwrbrZ2BhNrhnijVZC1xhAKtvgyw";
	private static final String PAYMENT_ID = "8085";
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		Long amount = Long.parseLong( request.getParameter("amount"));
		String currency =  request.getParameter("currency");
		String orderId = request.getParameter("orderId");
		PaymentMessage paymentMessage = new PaymentMessage(currency,orderId,amount);
		paymentMessage.setPaymentAmount(amount);
		paymentMessage.setOrderId(orderId);
		paymentMessage.setCurrencyCode(currency);
		Writer writer = new PrintWriter(System.out);
		try {

			WebResource webResource = Client.create(new DefaultClientConfig()).resource(URl_API_PAYMENT);
			String jsonInput = "{\"paymentAmount\":\" " +paymentMessage.getPaymentAmount()+"\",\"currencyCode\":\""+paymentMessage.getCurrencyCode()+"\",\"orderId\":\""+paymentMessage.getOrderId()+"\",\"successRedirectUrl\":\"http://www.yourdomain.com?a=success\",\"cancelRedirectUrl\":\"http://www.yourdomain.com?a=cancel\",\"failRedirectUrl\":\"http://www.yourdomain.com?b=fail\"}";
			System.out.println(paymentMessage.toString());
			
			//	queryParams.add("json",jsonInput);	
        /*    WebResource.Builder builder =  webResource.queryParams(queryParams)
					.header("X-PAY-API-KEY",API_KEY)
					.header("Content-Type", "application/json")
					.accept("application/json")
					.type("application/json");
					builder.post(ClientResponse.class); */
            		
			ClientResponse clientResponse = webResource.header("X-PAY-API-KEY",API_KEY)
					.header("Content-Type", "application/json")
					.post(ClientResponse.class,jsonInput);							
														
			clientResponse.toString();
		//	client.addFilter(new com.sun.jersey.api.client.filter.LoggingFilter(System.out));
			if (clientResponse.getStatus() != 200)
                throw new RuntimeException("Failed : HTTP error code : " + clientResponse.getStatus());
			if (clientResponse.getStatus() == 500)
                throw new RuntimeException("Internal Server error : " + clientResponse.getStatus());
			String output = clientResponse.getEntity(String.class);
			String status = clientResponse.toString();
			System.out.println(status);
			System.out.println("Output from Server .... \n");
			System.out.println(output);
			response.getWriter().write(output.toString());
			
			

		  } catch (Exception e) {

			e.printStackTrace();

		  }
		
		
		((PrintWriter) writer).println("helloFromServlet");
	//	writer.flush();
	//	writer.close();
		doGet(request, response);
	}

}
