package socialmonitoring;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class NewsFeed
 */
@WebServlet("/NewsFeed")
public class NewsFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsFeed() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html");
		
		//Object[] filter =  (Object[]) request.getAttribute("values");
		
		PrintWriter out = response.getWriter();
		
		out.print("<a href='add.jsp'>Add Users</a>" + "   " + "<a href='delete.jsp'>Delete</a>" + "  " +
				"<a href='update.jsp'>update/edit</a>"+ "  " +
				"<a href='filter.jsp'>FilterUsers</a>");
				
				HashMap<String,String> myMap = ContactDao.getNamesAndUserNames();
				
				out.println("<p>friends list</p>");
				
				for(Map.Entry<String,String> m: myMap.entrySet()) {
					out.print("<a href=https://twitter.com/"+m.getValue()+">"+m.getKey()+"</a>" + "   ");
				}
				
				out.println("<p>news feed</p>");
				
					for(Map.Entry<String,String> m: myMap.entrySet()) {
						out.println("<a class=\"twitter-timeline\" href=\"https://twitter.com/"+m.getValue()+"\">A Twitter List by"+m.getKey() +"</a> <script async src=\"//platform.twitter.com/widgets.js\" charset=\"utf-8\"></script>" 
								);
					}
		}
		
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
