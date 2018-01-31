package socialmonitoring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FilteredFeed
 */
@WebServlet("/FilteredFeed")
public class FilteredFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilteredFeed() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Object[] filterdusers = (Object[]) request.getAttribute("filterdusers");
		
		for(int i = 0;i<filterdusers.length;i++) {
			//response.getWriter().println("<a class=\"twitter-timeline\" href=\"https://twitter.com/"+filterdusers[i]+"\">A Twitter List by" +"</a> <script async src=\"//platform.twitter.com/widgets.js\" charset=\"utf-8\"></script>" 
			//		);
			
	out.println("<a class=\"twitter-timeline\" href=\"https://twitter.com/"+filterdusers[i]+"\">tweets</a> <script async src=\"//platform.twitter.com/widgets.js\" charset=\"utf-8\"></script>");
		
			//out.println("<a class=\"twitter-timeline\" href=\"https://twitter.com/"+filterdusers[i]+"\">A Twitter List by </a> <script async src=\"//platform.twitter.com/widgets.js\" charset=\"utf-8\"></script>" 
			//		);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
