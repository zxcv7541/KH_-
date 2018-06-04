package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class radiooo
 */
@WebServlet("/radiooo")
public class radiooo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public radiooo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html; charset=UTF-8");
		 String sex [] = request.getParameterValues("sex");
		 String email [] = request.getParameterValues("mail");
		 String hi = request.getParameter("hi");
		 PrintWriter out = response.getWriter();
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<title>");
		 out.println("계산결과");
		 out.println("</title>");
		 out.println("</head>");
		 out.println("<body>");
		 out.println("클라이언트 입력 정보<br><hr><br><br>");
		 out.println("성별:"+sex[0]+"<br><br>");
		 out.println("메인 수신 여부:"+email[0]+"<br><br>");
		 out.println("가입인사:"+hi+"<br><br>");
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
