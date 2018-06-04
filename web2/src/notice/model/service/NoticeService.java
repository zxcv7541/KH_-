package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;
import notice.model.vo.PageData;

public class NoticeService {

	public PageData noticeAll(int currentPage) {
		Connection conn=JDBCTemplate.getConnection();
		
		int recordCountPerPage=10;
		int naviCountPerPage=5;
		
		//Service에서는 DAO에 2가지 요청을 진행 해야 함
		//1.현재 페이지 리스트
		//2.현재 중심으로 만들어지는 navi 리스트
		
		ArrayList<Notice> list=new NoticeDao().getCurrentPage(conn,currentPage,recordCountPerPage);
		String pageNavi=new NoticeDao().getPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage);
		
		PageData pd=null;
		
		if(!list.isEmpty() && !pageNavi.isEmpty()) {
		pd=new PageData();
		pd.setNoticelist(list);
		pd.setPageNavi(pageNavi);
		}
		JDBCTemplate.close(conn);
		return pd;
	}

	public PageData searchList(int currentPage, String search) {
		Connection conn=JDBCTemplate.getConnection();
		
		int recordCountPerPage=10;
		int naviCountPerPage=5;
		
		ArrayList<Notice> list=new NoticeDao().getSearchCurrentPage(conn,currentPage,recordCountPerPage,search);
		String pageNavi=new NoticeDao().getSearchPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage,search);
		
		PageData pd=null;
		
		if(!list.isEmpty() && !pageNavi.isEmpty()) {
		pd=new PageData();
		pd.setNoticelist(list);
		pd.setPageNavi(pageNavi);
		}
		JDBCTemplate.close(conn);
		return pd;
	}

	public Notice noticeSelect(int noticeNo) {
		Connection conn=JDBCTemplate.getConnection();
		Notice notice=new NoticeDao().noticeSelect(conn,noticeNo);
		JDBCTemplate.close(conn);
		return notice;
		
	}

	public int update(String subject, String content, int noticeNo) {
		
		Connection conn=JDBCTemplate.getConnection();
		int result=new NoticeDao().update(conn,subject,content,noticeNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public int noticeInsert(String subject, String content) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new NoticeDao().noticeInsert(conn,subject,content);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public int noticeDelete(int noticeNo) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new NoticeDao().noticeDelete(conn,noticeNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
		
	}

	public ArrayList<NoticeComment> noticeComment(int noticeNo) {
		Connection conn=JDBCTemplate.getConnection();
		ArrayList<NoticeComment> list=new NoticeDao().noticeComment(conn,noticeNo);
		JDBCTemplate.close(conn);
		return list;
		
	}

	public int commentWrite(NoticeComment nc) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new NoticeDao().commentWrite(conn,nc);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
		
	}

	public int updateComment(String content, int commentNo) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new NoticeDao().updateComment(conn,content,commentNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
		
	}

	public int deldteComment(int commentNo) {
		
		Connection conn=JDBCTemplate.getConnection();
		int result=new NoticeDao().deldteComment(conn,commentNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
