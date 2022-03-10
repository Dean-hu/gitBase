import javax.servlet.*;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

public class MyListen implements ServletContextListener, HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
           ServletContext servletContext=servletContextEvent.getServletContext();
           servletContext.setAttribute("count",0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
           System.out.println("销毁");
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session创建");
        ServletContext servletContext=httpSessionEvent.getSession().getServletContext();
      int count=(int)servletContext.getAttribute("count");
      count++;
      servletContext.setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session销毁");
        ServletContext servletContext=httpSessionEvent.getSession().getServletContext();
        int count=(int)servletContext.getAttribute("count");
         count--;
        servletContext.setAttribute("count",count);
    }
}
