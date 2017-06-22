package com.javatesttask.george.payment;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.xml.internal.ws.api.ComponentFeature.Target;



@Path("/payment")
public class HelloService {
	@Context
	UriInfo uriInfo;
	
/*	@GET
	@Path("/")
	public String sayHello(){
		return "hello World from Rest";
	}

	@GET
	@Path("/{msgId}")
	@Produces(MediaType.TEXT_PLAIN)
    public String getMessage(@PathParam("msgId") String id){		
		return id;
	}*/
	
	PaymentMessage payMsg;
	@POST
	@Path("/objMessage")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PaymentMessage> savePayment(){
		payMsg = new PaymentMessage("EUR","ABCD123",10L);
		List<PaymentMessage> paymentList = new ArrayList<PaymentMessage>();
		paymentList.add(payMsg); 
		System.out.println(paymentList);
		return paymentList;
	}
	
/*	@POST
	@Path("/consumeMessage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<PaymentMessage> consumePayment(){
		payMsg = new PaymentMessage("EUR","ABCD123",10L);
		List<PaymentMessage> paymentList = new ArrayList<PaymentMessage>();
		paymentList.add(payMsg); 
		System.out.println(paymentList);
	//	JSONObject object = new JSONObject();
		
		
		return paymentList;
	}*/
	@POST
	@Path("/consumeMessage")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void generatePayment(
	 @FormParam("orderId") String orderId,
	 @FormParam("currency") String currency,
	 @FormParam("amount") Long amount,
	 @Context HttpServletResponse servletResponse) throws IOException {
	 PaymentMessage payMssg = new PaymentMessage(currency,orderId,amount);
	 URI uri = uriInfo.getAbsolutePathBuilder().path(orderId).build();
	 Response.created(uri).build();
	 servletResponse.sendRedirect("../pages/order.html");
	}
	
}
