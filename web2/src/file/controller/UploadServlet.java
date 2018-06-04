package file.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import file.model.service.FileService;
import file.model.vo.DataFile;
import member.model.vo.Member;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(name = "Upload", urlPatterns = { "/upload" })
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일 업로드를 구현하려면 몇가지 정보가 필요함
		//1.사용자 계정명(업로드한 사람 정보가 있어야함,session객체 에서 꺼냄)
		HttpSession session=request.getSession(false);
		
		String userId=((Member)session.getAttribute("user")).getUserId();
		
		//2.최대 업로드 파일 사이즈(설정)
		int FileSizeLimit=1024*1024*5;//Byte단위(5MB)
		
		//3.업로드 될 경로
		String uploadFilePath=getServletContext().getRealPath("/")+"uploadfile";
		
		//4.인코딩 타입(파일 인코딩 타입)
		String encType="utf-8";
		
		//위에 정보를 바탕으로 
		//5.MultipartRequest 객체를 생성
		//인자값 순서 : request,파일경로,파일최대사이즈,인코딩타입,Policy
		MultipartRequest multi=new MultipartRequest(request,
													uploadFilePath,FileSizeLimit,encType,new DefaultFileRenamePolicy());
		
		//마지막 인자값인 DefaultFileRenamePolicy객체를 생성하여 넣어줌으로써 파일 중복 처리를 자동으로 해결함
		//ex)a.bmp가 중복으로 업로드 되면 a1.bmp, a2.bmp, a3.bmp....
		//MultipartRequest 객체가 생성되면 자동으로 파일은 해당 경로로 업로드 됨
		
		//업로드된 파일의 정보를 DB에 기록하여야 함
		//1.파일 이름(fileName)
		//getFilesystemName("view의 파마리터이름"); 을 하게되면 
		//해당 업로드 될때의 파일 이름을 가져옴
		String fileName=multi.getFilesystemName("upfile");
		
		//2.업로드 파일의 실제 총 경로(filePath)
		//총 경로 : filePath+파일이름
		//ex)업로드한 파일이 a.txt 라면?
		//총 경로:c:\webworkspace3\web2\WebContent\UploadFile\a.txt
		
		String fullFilePath=uploadFilePath+"\\"+fileName;
		
		//3.파일의 길이-크기(length)
		File file=new File(fullFilePath);
		long fileSize=file.length();
		System.out.println(fileSize);
		
		//4.파일 유저명
		//굳이 만들 필요가 없음(위에 userId 변수를 만들어 놓았음)
		
		//5.파일 업로드된 시간(밀리세컨까지)
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Timestamp uploadTime=null;
		uploadTime=Timestamp.valueOf(formatter.format(Calendar.getInstance().getTimeInMillis()));
		
		
		DataFile df=new DataFile(fileName,fullFilePath,fileSize,userId,uploadTime);
		
		int result=new FileService().uploadFile(df);
		
		if(result>0) {
			response.sendRedirect("/views/file/fileUploadSuccess.jsp");
		}
		else
		{
			response.sendRedirect("/views/file/fileError.html");
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
