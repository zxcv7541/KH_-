package member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	public Member selectOne(String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().selectOne(conn,userId,userPwd);
		JDBCTemplate.close(conn);
		return m;
	}
	public ArrayList<Member> selectList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new MemberDao().selectList(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	public int memberActivationChange(String activation,String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().memberActivationChange(conn,activation,userId);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}else
		{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().insertMember(conn,m);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}else
		{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().updateMember(conn,m);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}else
		{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	public int deleteMember(String userId, String userPwd) {
		 Connection conn =  JDBCTemplate.getConnection();
		 int result = new MemberDao().deleteMember(userId,userPwd,conn);
		 if(result>0)
		 {
			 JDBCTemplate.commit(conn);
		 }else {
			 JDBCTemplate.rollback(conn);
		 }
		 JDBCTemplate.close(conn);
		return result;
	}
	public boolean changePwdCheck(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = new MemberDao().changePwdCheck(conn,userId);
		JDBCTemplate.close(conn);
		return result;
	}
}















