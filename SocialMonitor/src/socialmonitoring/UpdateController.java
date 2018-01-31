package socialmonitoring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
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
		
		int status = ContactDao.updateOrEditUsers(c);
		
		if(status>0) {
			out.println("<p>invalid username!</p>");
		}else {
			out.println("<p>successfully updated!</p>");
			request.getRequestDispatcher("NewsFeed").forward(request, response);	
		}
		
		
	}

}
