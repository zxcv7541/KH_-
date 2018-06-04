package file.model.service;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;

import common.JDBCTemplate;
import file.model.dao.FileDao;
import file.model.vo.DataFile;
import file.model.vo.DataFile2;

public class FileService {

	public int uploadFile(DataFile df) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new FileDao().uploadFile(conn,df);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		else
		{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<DataFile> fileList() {
		Connection conn=JDBCTemplate.getConnection();
		ArrayList<DataFile> list=new FileDao().fileList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public DataFile fileSelectDown(String fileName, Timestamp uploadTime) {
		Connection conn=JDBCTemplate.getConnection();
		DataFile df=new FileDao().fileSelectDown(conn,fileName,uploadTime);
		JDBCTemplate.close(conn);
		return df;
		
	}

	public int uploadFile2(DataFile2 df) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new FileDao().uploadFile2(conn,df);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		else
		{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<DataFile2> fileList2() {
		Connection conn=JDBCTemplate.getConnection();
		ArrayList<DataFile2> list=new FileDao().fileList2(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	public DataFile2 fileSelectDown2(String afterFileName, Timestamp uploadTime) {
		Connection conn=JDBCTemplate.getConnection();
		DataFile2 df=new FileDao().fileSelectDown2(conn,afterFileName,uploadTime);
		JDBCTemplate.close(conn);
		return df;
	}

	public int fileDelete(String afterFileName) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new FileDao().fileDelete(conn,afterFileName);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}
		else  
		{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
		
	}

}
