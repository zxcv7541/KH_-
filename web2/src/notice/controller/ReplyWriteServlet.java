package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import notice.model.service.NoticeService;
import notice.model.vo.NoticeComment;

/**
 * Servlet implementation class ReplyWriteServlet
 */
@WebServlet(name = "ReplyWrite", urlPatterns = { "/replyWrite" })
public class ReplyWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		NoticeComment nc=new NoticeComment();
		
		nc.setUserId(request.getParameter("userId"));
		nc.setContent(request.getParameter("comment"));
		nc.setNoticeNo(Integer.parseInt(request.getParameter("noticeNo")));
		
	
		
		int result=new NoticeService().commentWrite(nc);
		
		if(result>0) {
			response.sendRedirect("/noticeSelect?noticeNo="+nc.getNoticeNo());
		}
		else {
			response.sendRedirect("/views/notice/Error.html");
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
