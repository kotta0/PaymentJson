package bg.jwd.listeners;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListenerExample
 *
 */
@WebListener
public class SessionListenerExample implements HttpSessionListener {

    /**
     * Default constructor. 
     */
	@Override
   public void sessionCreated(HttpSessionEvent sessionEvent){
	   System.out.println("Session created. ID: " + sessionEvent.getSession().getId());
	   
   }
	@Override
	   public void sessionDestroyed(HttpSessionEvent sessionEvent){
		System.out.println("Session destroyed at: " + new Date().toLocaleString() + "ID" + sessionEvent.getSession().getId());

	   }
	
}
