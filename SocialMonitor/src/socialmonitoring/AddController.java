package socialmonitoring;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class AddController
 */
@WebServlet("/AddController")

public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			

		
		try {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String name = request.getParameter("Input 1");
			String email = request.getParameter("Input 2");
			String phnno = request.getParameter("Input 3");
			String username = request.getParameter("Input 4");
			
			
			Contact c = new Contact();
			
			c.setName(name);
			c.setEmail(email);
			c.setPhnno(phnno);
			c.setUsername(username);
			
			int status = ContactDao.addUsers(c);
			
			if(status>0) {
				out.println("<p>successfully added!</p>");
				request.getRequestDispatcher("NewsFeed").forward(request, response);
			}else {
				out.println("<p>unable to add</p>");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	

}
