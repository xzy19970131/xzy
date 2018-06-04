package control.Listerer;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class QingqiuListener implements ServletRequestListener {
    public QingqiuListener() {
  
    }
    public void requestDestroyed(ServletRequestEvent arg0)  { 
    	System.out.println("请求完成后销毁");
     
    }

    public void requestInitialized(ServletRequestEvent arg0)  { 
       System.out.println("请求发起时创建");
    }
	
}
