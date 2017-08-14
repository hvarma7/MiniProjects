package map;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RouteDirections")
public class RouteDirections extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String lattitude_one = request.getParameter("lat1");
		String longitude_one = request.getParameter("long1");
		String lattitude_two = request.getParameter("lat2");
		String longitude_two = request.getParameter("long2");
		
		
		out.print("	<iframe\n" + 
				"  width=\"600\"\n" + 
				"  height=\"450\"\n" + 
				"  frameborder=\"0\" style=\"border:0\"\n" + 
				"  src=\"https://www.google.com/maps/embed/v1/directions?key=AIzaSyACq9fIqeOsYzz2izh_86NVAvB_ELAosnk\n" + 
				"    &origin="+lattitude_one+","+longitude_one+"\n" + 
				"    &destination="+lattitude_two+","+longitude_two+"\"\n" + 
				"     allowfullscreen>\n" + 
				"</iframe>");
	}

}
