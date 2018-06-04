package jquery.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import jquery.test.vo.User;

/**
 * Servlet implementation class Test5Servlet
 */
@WebServlet(name = "Test5", urlPatterns = { "/test5" })
public class Test5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<User> list=new ArrayList<User>();
		 list.add(new User("홍길동",20,"경기도"));
		 list.add(new User("김길동",30,"경기도1"));
		 list.add(new User("이길동",40,"경기도2"));
		 list.add(new User("고길동",50,"경기도3"));
		 list.add(new User("가길동",60,"경기도4"));
		 list.add(new User("심길동",70,"경기도5"));
		 list.add(new User("구길동",80,"경기도6"));
		 list.add(new User("한길동",90,"경기도7"));
		 list.add(new User("황길동",10,"경기도8"));
		 list.add(new User("이길동",5,"경기도"));
		 
		 request.setCharacterEncoding("utf-8");
		 int userIndex = Integer.parseInt(request.getParameter("userIndex"));
		 User user=list.get(userIndex-1);
		 
		JSONObject result= new JSONObject(); //JSON객체 생성
		
		//JSON 객체는 MAP형태로 사용(키,값)
		
		
		result.put("name", user.getName());
		result.put("age", user.getAge());
		result.put("addr", user.getAddr());
		
		response.setContentType("application/json");
		//json 객체를 전송하려면 타입을 변경해주어야 함
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(result);
		response.getWriter().close();
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
