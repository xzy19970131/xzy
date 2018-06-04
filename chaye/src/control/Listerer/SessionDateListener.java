package control.Listerer;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionDateListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent arg0)  { 
      System.out.println(arg0.getSession().getId()+"新用户");
    }
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
        System.out.println(arg0.getSession().getId()+"退出了");
    }
	
}
