package p1.t7.servlets;

import p1.t7.calc.CalcOperations;
import p1.t7.calc.OperationType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CalcServlet", urlPatterns = "/CalcServlet")
public class CalcServlet extends HttpServlet {



    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<String> listOperation;

        PrintWriter out = response.getWriter();
        try {
            double one = Double.parseDouble(request.getParameter("one"));
            double two = Double.parseDouble(request.getParameter("two"));
            String operation = request.getParameter("operation");
            OperationType operationType = OperationType.valueOf(operation.toUpperCase());
            double result = calcresult(operationType, one, two);

            HttpSession session = request.getSession(true);

            if (session.isNew()) {
                listOperation=new ArrayList<>();
            }else {
                listOperation= (List<String>) session.getAttribute("formula");
            }

            listOperation.add(one + " " + operationType.getValue() + " "+two + " = " + result);
            session.setAttribute("formula",listOperation);

            out.println("<h1>" + session.getId() + "</h1>");
            out.println("<h3>" + listOperation.size() + "</h3>");

            for (String expr : listOperation) {
                out.println("<h3>" + expr + "</h3>");
            }

        } catch (Exception e) {
            out.println("<h3>Error <h3>");
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

    private double calcresult(OperationType operationType, double one, double two) {
        double result = 0;
        switch (operationType) {
            case ADD: {
                result = CalcOperations.add(one, two);
                break;
            }
            case SUBTRACT: {
                result = CalcOperations.subtract(one, two);
                break;
            }
            case MULTIPLY: {
                result = CalcOperations.multiply(one, two);
                break;
            }
            case DIVIDE: {
                result = CalcOperations.divide(one, two);
            }
        }
        return result;
    }
}
