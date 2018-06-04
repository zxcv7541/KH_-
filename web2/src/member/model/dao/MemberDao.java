package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;
import sun.dc.pr.PRError;

public class MemberDao {

	public Member selectOne(Connection conn, String userId, String userPwd) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		String query  = "select * from member where userid=? and userpwd=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,userId);
			pstmt.setString(2,userPwd);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setUserId(rset.getString("userid"));
				m.setUserPwd(rset.getString("userpwd"));
				m.setUserName(rset.getString("username"));
				m.setAge(rset.getInt("age"));
				m.setEmail(rset.getString("email"));
				m.setPhone(rset.getString("phone"));
				m.setAddr(rset.getString("address"));
				m.setGender(rset.getString("gender"));
				m.setHobby(rset.getString("hobby"));
				m.setEnrolldate(rset.getDate("enrolldate"));
				m.setActivation(rset.getString("activation"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
	}
	public ArrayList<Member> selectList(Connection conn) {
		ArrayList<Member> list = new ArrayList<Member>();
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * from member";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()){
				Member	member = new Member();
				member.setUserId(rset.getString("userid"));
				member.setUserPwd(rset.getString("userpwd"));
				member.setUserName(rset.getString("username"));
				member.setAge(rset.getInt("age"));
				member.setEmail(rset.getString("email"));
				member.setPhone(rset.getString("phone"));
				member.setAddr(rset.getString("address"));
				member.setGender(rset.getString("gender"));
				member.setHobby(rset.getString("hobby"));
				member.setEnrolldate(rset.getDate("enrolldate"));
				member.setActivation(rset.getString("activation"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally		{
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	public int memberActivationChange(Connection conn, String activation,String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member set activation=? where userid=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, activation);
			pstmt.setString(2, userId);
			
			 result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
	
		return result;
	}
	public int insertMember(Connection conn, Member m) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into member values(?,?,?,?,?,?,?,?,?,SYSDATE,?,SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getAddr());
			pstmt.setString(8, m.getGender());
			pstmt.setString(9, m.getHobby());
			pstmt.setString(10, m.getActivation());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}
	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		boolean changePwd = false;
		try {
			pstmt = conn.prepareStatement("select userPwd from member where userid='"+m.getUserId()+"'");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				if(!(m.getUserPwd().equals(rset.getString("userPwd")))) {
					changePwd = true;
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String query = null;
		if(changePwd==true) {
		 query = "update member set userpwd=?,"
					+ "email=?,phone=?,address=?,hobby=?,last_modified=SYSDATE"
					+ " where userid=?";
		}else
		{
		 query = "update member set userpwd=?,"
				+ "email=?,phone=?,address=?,hobby=?"
				+ " where userid=?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddr());
			pstmt.setString(5, m.getHobby());
			pstmt.setString(6, m.getUserId());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public int deleteMember(String userId, String userPwd, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from member where userid=? AND userpwd=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public boolean changePwdCheck(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;
		
		String query = "select floor(SYSDATE-last_modified)AS change_date "
				+ "FROM member where userid=?";
		try {
			pstmt  = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next())
			{
				if(rset.getInt("change_date")>=90) {
					result = true;
				}else
				{
					result = false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


}
















