package socialmonitoring;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
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
		try {
			String user = request.getParameter("Input 1");
			
				int status = ContactDao.deleteUsers(user);
			
			if(status>0) {
				out.println("<p>successfully deleted records!</p>");
				request.getRequestDispatcher("NewsFeed").forward(request, response);	
				
			}else{
				out.println("<p>invlaid record!</p>");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
