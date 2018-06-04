package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MyInfoServlet
 */
@WebServlet(name = "MyInfo", urlPatterns = { "/myInfo" })
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		String userPwd=request.getParameter("userPwd");
		
		HttpSession session=request.getSession(false);
		
		
		
		if(session.getAttribute("user") !=null) {
		Member m=(Member)session.getAttribute("user");
		
		Member infoM=new MemberService().selectOne(m.getUserId(),userPwd);
		
			if(infoM!=null)
			{
				RequestDispatcher view=request.getRequestDispatcher("/views/member/myInfo.jsp");
				request.setAttribute("info", infoM);
				view.forward(request, response);
			}else
			{	
				response.sendRedirect("/views/member/myInfoFailed.jsp");
			}
		}else
		{
			response.sendRedirect("views/member/Error.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
