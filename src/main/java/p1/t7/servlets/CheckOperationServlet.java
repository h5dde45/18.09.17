package p1.t7.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CheckOperationServlet",urlPatterns = "/CheckOperationServlet")
public class CheckOperationServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);
            out.println("<h1>" + session.getId() + "</h1>");
            Object o= session.getAttribute("formula");

            if(o instanceof ArrayList) {
                ArrayList<String> list = (ArrayList<String>) o;

                out.println("<h3>" + list.size() + "</h3>");
                out.println("<h3>List operations:</h3>");

                for (String expr : list) {
                    out.println("<h3>" + expr + "</h3>");
                }
            }

        } catch (Exception e) {
            out.println("<h3>Not found operations <h3>");
        } finally {
            out.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
