package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class gogo
 */
@WebServlet("/gogo")
public class gogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gogo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html; charset=UTF-8");
		 String select []  = request.getParameterValues("tra");
		 PrintWriter out = response.getWriter();
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<title>");
		 out.println("계산결과");
		 out.println("</title>");
		 out.println("</head>");
		 out.println("<body>");
		 for(int i=0;i<select.length;i++)
		 {
			 out.println(select[i]);
		 }
		 out.println("</body>");
		 out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
