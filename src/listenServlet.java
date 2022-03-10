import com.sun.xml.internal.ws.client.RequestContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "listenServlet", value = "/listenServlet")
public class listenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
         response.setContentType("text/html;charset=utf-8");
          ServletContext servletContext=request.getServletContext();
          int count=(int)servletContext.getAttribute("count");
          response.getWriter().write("当前观看人数为："+count);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request,response);
    }
}
