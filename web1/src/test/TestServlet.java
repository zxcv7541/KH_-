package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(name = "Test", urlPatterns = { "/test" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("호출  " );
		// 서블릿에서 데이터를 처리할때에는 크게 4가지를 꼭 진행 해야함
		/*
		 * 1. 전송값에 한글이 있는 경우 인코딩 처리
		 * 2. 웹에서 보내준 전송값을 꺼내어 변수에 저장(request)
		 * 3. 비즈니스 로직 작동(Model 작업)
		 * 4. 처리 완료후 결과 응답(response)
		 */ 
		
//		 //1. 인코딩
//		  request.setCharacterEncoding("utf-8");
//		  
//		  //2. 보내준 데이터 꺼내서 변수에 저장
//		  String str = request.getParameter("str");
//		  
//		  // 3.출력 테스트
//		  System.out.println("요청한 값 : " + str);
		  //4번 
		  // 출력 -> 내 시스템이 아닌 상대방(Client) 에게 HTML 코드를 줄것
		  //. 서블릿에서 클라이언트에게 데이터를 전송하려면
		  // response 객체를 이용하여 출력 스트림을 생성 해야함
		 request.setCharacterEncoding("utf-8");
		 String fir = (request.getParameter("firstValue"));
		 String sec = (request.getParameter("secondValue"));
		 int result = (Integer.parseInt(fir) + Integer.parseInt(sec));
		 response.setContentType("text/html; charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 out.println("<html>");
		 out.println("<head>");
		 
		 out.println("<title>");
		 out.println("계산결과");
		 out.println("</title>");
		 out.println("</head>");
		 out.println("<body>");
		 out.println(fir + " + " + sec +"="+ result);
		 out.println("</body>");
		 out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
//		System.out.println("post 방식으로 호출 하였습니다.");
	}

}
