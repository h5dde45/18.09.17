package p1.t6;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class SecondServlet extends HttpServlet {
    String initP;
    private int count;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        initP=config.getInitParameter("init1");
        System.out.println(initP);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Enumeration enumeration=request.getParameterNames();
        count++;
        request.getSession().setAttribute("count",count);

        try(PrintWriter out=response.getWriter()){
            out.println("<h3>"+request.getParameter("p1")+"</h3>");
            out.println("<h3>"+request.getParameter("p2")+"</h3>");
            out.println("<h3>"+initP+"</h3>");
            out.println("<h3>"+request.getSession().getAttribute("count")+"</h3>");
            while (enumeration.hasMoreElements()){
                String s= enumeration.nextElement().toString();
                out.println("<h3>"+s+request.getParameter(s)+"</h3>");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
