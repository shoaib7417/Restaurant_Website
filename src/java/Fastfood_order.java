import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Fastfoodorder")
public class Fastfood_order extends GenericServlet {
    public void service(ServletRequest rq, ServletResponse rs) throws IOException {
        try {
            int totalbill = 0;
            rs.setContentType("text/html");
            PrintWriter out = rs.getWriter();
            String[] items = rq.getParameterValues("c1");
            
            if (items != null) {
                for (String i : items) {
                    if (i.equals("pizza")) {
                        totalbill += 40 * Integer.parseInt(rq.getParameter("q1"));
                    } else if (i.equals("burger")) {
                        totalbill += 50 * Integer.parseInt(rq.getParameter("q2"));
                    } else if (i.equals("garlicbread")) {
                        totalbill += 120 * Integer.parseInt(rq.getParameter("q3"));
                    } else if (i.equals("whitesausepasta")) {
                        totalbill += 80 * Integer.parseInt(rq.getParameter("q4"));
                    } else if (i.equals("maggi")) {
                        totalbill += 60 * Integer.parseInt(rq.getParameter("q5"));
                    } else if (i.equals("frenchfries")) {
                        totalbill += 40 * Integer.parseInt(rq.getParameter("q6"));
                    } else if (i.equals("chillipotato")) {
                        totalbill += 80 * Integer.parseInt(rq.getParameter("q7"));
                    } else if (i.equals("samosa")) {
                        totalbill += 50 *Integer.parseInt(rq.getParameter("q8"));
                    } else {
                        out.println("Invalid item: " + i);
                    }
                }
                out.println("Total Bill = " + totalbill);
            }
            else {
                out.println("Please select at least one item from the menu...");
            }
        } catch (NumberFormatException e) {
            rs.getWriter().println("Invalid quantity format.");
        }
    }
}
