package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calc
 */
@WebServlet(name = "calc", urlPatterns = { "/calc" })
public class calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html; charset=UTF-8");
		 String fir = (request.getParameter("firstValue"));
		 String sec = (request.getParameter("secondValue"));
		 String cho = (request.getParameter("choice"));
		 int num1 =0;
		 switch(cho)
		 {
		 case "+" :num1 = Integer.parseInt(fir) + Integer.parseInt(sec);break;
		 case "-" :num1 = Integer.parseInt(fir) - Integer.parseInt(sec);break;
		 case "*" :num1 = Integer.parseInt(fir) * Integer.parseInt(sec);break;
		 case "/" :num1 = Integer.parseInt(fir) / Integer.parseInt(sec);break;
	     }
		 PrintWriter out = response.getWriter();
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<title>");
		 out.println("계산결과");
		 out.println("</title>");
		 out.println("</head>");
		 out.println("<body>");
		 out.println(fir + cho + sec +"="+ num1);
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
