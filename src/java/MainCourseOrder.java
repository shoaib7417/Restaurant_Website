import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/MainCourseOrder")
public class MainCourseOrder extends GenericServlet {
    public void service(ServletRequest rq, ServletResponse rs) throws IOException {
        try {
            int totalbill = 0;
            rs.setContentType("text/html");
            PrintWriter out = rs.getWriter();
            String[] items = rq.getParameterValues("c1");
            
            if (items != null) {
                for (String i : items) {
                    if (i.equals("Rosted Chicken")) {
                        totalbill += 250 * Integer.parseInt(rq.getParameter("q1"));
                    } else if (i.equals("Shahi Paneer")) {
                        totalbill += 180 * Integer.parseInt(rq.getParameter("q2"));
                    } else if (i.equals("Daal Makhni")) {
                        totalbill += 200 * Integer.parseInt(rq.getParameter("q3"));
                    } else if (i.equals("Mix Veg")) {
                        totalbill += 220 * Integer.parseInt(rq.getParameter("q4"));
                    } else if (i.equals("Chicken Tandoori")) {
                        totalbill += 250 * Integer.parseInt(rq.getParameter("q5"));
                    } else if (i.equals("Chilli Chicken")) {
                        totalbill += 220 * Integer.parseInt(rq.getParameter("q6"));
                    } else if (i.equals("Chicken Briyani")) {
                        totalbill += 250 * Integer.parseInt(rq.getParameter("q7"));
                    } else if (i.equals("Mutton Greavy")) {
                        totalbill += 450 *Integer.parseInt(rq.getParameter("q8"));
                    } else if (i.equals("Khubsa")) {
                        totalbill += 750 *Integer.parseInt(rq.getParameter("q9"));
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
