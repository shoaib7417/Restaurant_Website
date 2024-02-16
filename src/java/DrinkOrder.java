import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/DrinkOrder")
public class DrinkOrder extends GenericServlet {
    public void service(ServletRequest rq, ServletResponse rs) throws IOException {
        try {
            int totalbill = 0;
            rs.setContentType("text/html");
            PrintWriter out = rs.getWriter();
            String[] items = rq.getParameterValues("c1");
            
            if (items != null) {
                for (String i : items) {
                    if (i.equals("Chai")) {
                        totalbill += 40 * Integer.parseInt(rq.getParameter("q1"));
                    } else if (i.equals("Coffee")) {
                        totalbill += 50 * Integer.parseInt(rq.getParameter("q2"));
                    } else if (i.equals("Cold Drink")) {
                        totalbill += 100 * Integer.parseInt(rq.getParameter("q3"));
                    } else if (i.equals("Mojito")) {
                        totalbill += 150 * Integer.parseInt(rq.getParameter("q4"));
                    } else if (i.equals("Soft Drink")) {
                        totalbill += 80 * Integer.parseInt(rq.getParameter("q5"));
                    } else if (i.equals("Water")) {
                        totalbill += 40 * Integer.parseInt(rq.getParameter("q6"));
                    } else if (i.equals("Juice")) {
                        totalbill += 80 * Integer.parseInt(rq.getParameter("q7"));
                    } else if (i.equals("Milk Shake")) {
                        totalbill += 100 *Integer.parseInt(rq.getParameter("q8"));
                    } else if (i.equals("Lemonda")) {
                        totalbill += 100 *Integer.parseInt(rq.getParameter("q9"));
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
