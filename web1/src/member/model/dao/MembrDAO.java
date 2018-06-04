package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import member.model.vo.Member;

public class MembrDAO {

	public Member selectMember(Connection conn, String userId, String userPwd) {
		PreparedStatement stmt=null;
		ResultSet rset=null;
		
		String query="select * from member where member_id=? and member_pwd=?";
		Member m=null;
		
		try {
			stmt=conn.prepareStatement(query);
			stmt.setString(1, userId);
			stmt.setString(2, userPwd);
			rset=stmt.executeQuery();
			
			while(rset.next()) {
				m=new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPwd(rset.getString("member_pwd"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberAge(rset.getInt("member_age"));
				m.setMemberAddr(rset.getString("member_addr"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return m;
		
	}

	public int updateMember(Connection conn, Member m) {
		PreparedStatement stmt=null;
		int result=0;

		String query="update member set member_pwd =?,member_addr=? where member_id=?";

		try {
			stmt=conn.prepareStatement(query);
			stmt.setString(1, m.getMemberPwd());
			stmt.setString(2, m.getMemberAddr());
			stmt.setString(3, m.getMemberId());
			
			result=stmt.executeUpdate();
			
			if(result>0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
	}

	public boolean idCheck(Connection conn, String id) {
		PreparedStatement stmt=null;
		ResultSet rset=null;
		boolean result=false;

		String query="select * from member where member_id=?";

		try {
			stmt=conn.prepareStatement(query);
			stmt.setString(1,id);

			
			rset=stmt.executeQuery();
			
			if(rset.next()) {
				result=true;
			}
			else {
				result=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int insert(Connection conn, Member m) {
		PreparedStatement stmt=null;
		int result=0;

		String query="insert into member values(?,?,?,?,?)";

		try {
			stmt=conn.prepareStatement(query);
			stmt.setString(1,m.getMemberId());
			stmt.setString(2, m.getMemberPwd());
			stmt.setString(3, m.getMemberName());
			stmt.setInt(4,m.getMemberAge());
			stmt.setString(5, m.getMemberAddr());
			
			result=stmt.executeUpdate();
			
			if(result>0) {
				conn.commit();
			}
			else {
				conn.rollback();
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
	}

	public int delete(Connection conn, String id) {
	
		PreparedStatement stmt=null;
		int result=0;

		String query="delete from member where member_id=?";

		try {
			stmt=conn.prepareStatement(query);
			stmt.setString(1,id);
			
			result=stmt.executeUpdate();
			
			if(result>0) {
				conn.commit();
			}
			else {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
