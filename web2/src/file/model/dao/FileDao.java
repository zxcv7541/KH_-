package file.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import common.JDBCTemplate;
import file.model.vo.DataFile;
import file.model.vo.DataFile2;

public class FileDao {

	public int uploadFile(Connection conn, DataFile df) {
		PreparedStatement pstmt=null;
		int result=0;
		String query="insert into filetbl values(?,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, df.getFileName());
			pstmt.setString(2, df.getFilePath());
			pstmt.setLong(3, df.getFileSize());
			pstmt.setString(4, df.getFileUser());
			pstmt.setTimestamp(5, df.getUploadTime());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<DataFile> fileList(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		ArrayList<DataFile> list=new ArrayList<DataFile>();
		
		
		String query="select * from filetbl";
		
		try {
			pstmt=conn.prepareStatement(query);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				DataFile df=new DataFile();
				df.setFileName(rset.getString("filename"));
				df.setFileSize(rset.getLong("filesize"));
				df.setFileUser(rset.getString("fileuser"));
				df.setUploadTime(rset.getTimestamp("uploadtime"));
				list.add(df);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public DataFile fileSelectDown(Connection conn, String fileName, Timestamp uploadTime) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String query="select * from filetbl where filename=? and uploadtime=?";
		DataFile df=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, fileName);
			pstmt.setTimestamp(2, uploadTime);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				df=new DataFile();
				df.setFileName(rset.getString("filename"));
				df.setFilePath(rset.getString("filepath"));
				df.setFileSize(rset.getLong("filesize"));
				df.setFileUser(rset.getString("fileuser"));
				df.setUploadTime(rset.getTimestamp("uploadtime"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return df;
	}

	public int uploadFile2(Connection conn, DataFile2 df) {
		PreparedStatement pstmt=null;
		int result=0;
		String query="insert into filetbl2 values(?,?,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, df.getBeforeFileName());
			pstmt.setString(2, df.getAfterFileName());
			pstmt.setString(3, df.getFilePath());
			pstmt.setLong(4, df.getFileSize());
			pstmt.setString(5, df.getFileUser());
			pstmt.setTimestamp(6, df.getUploadTime());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<DataFile2> fileList2(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		ArrayList<DataFile2> list=new ArrayList<DataFile2>();
		
		
		String query="select * from filetbl2";
		
		try {
			pstmt=conn.prepareStatement(query);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				DataFile2 df=new DataFile2();
				df.setBeforeFileName(rset.getString("beforefilename"));
				df.setAfterFileName(rset.getString("afterfilename"));
				df.setFileSize(rset.getLong("filesize"));
				df.setFileUser(rset.getString("fileuser"));
				df.setUploadTime(rset.getTimestamp("uploadtime"));
				df.setFilePath(rset.getString("filepath"));
				list.add(df);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public DataFile2 fileSelectDown2(Connection conn, String afterFileName, Timestamp uploadTime) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String query="select * from filetbl2 where afterFileName=? and uploadtime=?";
		DataFile2 df=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, afterFileName);
			pstmt.setTimestamp(2, uploadTime);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				df=new DataFile2();
				df.setBeforeFileName(rset.getString("beforeFileName"));
				df.setAfterFileName(rset.getString("afterFileName"));
				df.setFilePath(rset.getString("filepath"));
				df.setFileSize(rset.getLong("filesize"));
				df.setFileUser(rset.getString("fileuser"));
				df.setUploadTime(rset.getTimestamp("uploadtime"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return df;
	}

	public int fileDelete(Connection conn, String afterFileName) {
		PreparedStatement pstmt=null;
		int result=0;
		String query="delete from filetbl2 where afterfilename=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, afterFileName);
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
