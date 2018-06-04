package jquery.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import jquery.test.vo.User;

/**
 * Servlet implementation class Test8Servlet
 */
@WebServlet(name = "Test8", urlPatterns = { "/test8" })
public class Test8Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test8Servlet() {
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
		 
		 String userIndexs2=request.getParameter("userIndexs2");
		 StringTokenizer sT=new StringTokenizer(userIndexs2,",");
		 System.out.println("12");
		 JSONObject resultMap=new JSONObject();
		 //JSONObject객체 자체가 기본적으로 MAP형태이기 때문에 키:값 형태로 사용하면 됨
		 ArrayList<Integer> userSelect=new ArrayList<Integer>();
		 while(sT.hasMoreTokens()) {
			 userSelect.add(Integer.parseInt(sT.nextToken())-1);
		 }
		 int index= 0;
		 
		 while(index<userSelect.size()) {
			 User user=list.get(userSelect.get(index));
			 JSONObject result=new JSONObject();
			 result.put("name",user.getName());
			 result.put("age",user.getAge());
			 result.put("addr",user.getAddr());
			 
			 resultMap.put(index, result);
			 index++;
		 }
		 
		 
		 response.setContentType("application/json");
		 response.setCharacterEncoding("utf-8");
		 
		 response.getWriter().print(resultMap);
		 response.getWriter().close();
		 System.out.println("11");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
