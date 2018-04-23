package controller;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements  HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	public void sessionCreated(HttpSessionEvent event) {
		HttpSession ses = event.getSession();   
		String id=ses.getId()+ses.getCreationTime(); 
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession ses = event.getSession();   
		String id=ses.getId()+ses.getCreationTime();   
		synchronized (this) {   
			System.out.println("session失效"+id);//失效时输出 	
		}
	}
}
