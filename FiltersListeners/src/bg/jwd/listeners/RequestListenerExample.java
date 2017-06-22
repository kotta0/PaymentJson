package bg.jwd.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestListenerExample
 *
 */
@WebListener
public class RequestListenerExample implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public RequestListenerExample() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent event)  { 
        System.out.println("Address: " + event.getServletRequest().getLocalAddr());
    }
	
}
