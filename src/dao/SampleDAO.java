package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.SampleVO;
import util.DbUtil2;

public class SampleDAO extends DbUtil2 {

	/**
	 * C:create() 등록하는 메소드
	 * 접근지정자 : public
	 * param : 등록될 값
	 * return : 없음. 
	 */
	public void create(SampleVO vo) {
		//코드작성
//		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
//		String user = "root";
//		String password = "smart";
		StringBuffer sql = new StringBuffer();
		sql.append("\n INSERT INTO sample "); 
		sql.append("\n (strData, sampleDate) ");  
		sql.append("\n VALUES (?, ?) "); 
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int idx = 0;
		try {
			//드라이버로드
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//DB연결
			conn = getConn();
			//prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			
			//?에 값설정
			stmt.setString(++idx, vo.getStrData());
			stmt.setDate(++idx, new Date(vo.getSampleDate().getTime()));
			
			int res = stmt.executeUpdate();
			//결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
			
		}
		//닫기		
	}

	/**
	 * R:read() 조회하는 메소드
	 * 접근지정자 : public
	 * param : 조회할 값
	 * return : List 
	 */
	public List<SampleVO> read() {
//		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
//		String user = "root";
//		String password = "smart";
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM sample ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<SampleVO> list = new ArrayList<SampleVO>();
		//코드작성
		try {
			//드라이버로드
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//DB연결
			conn = getConn();
			//prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			//결과처리(Select문만 ResultSet 객체 리턴)
			while(rs.next()) {
				SampleVO vo = new SampleVO(
						rs.getInt("num"),
						rs.getString("strData"),
						rs.getDate("sampleDate")
				);
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, rs);
		}
		//닫기
		return list;
	}

	public SampleVO read(SampleVO vo){
//		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
//		String user = "root";
//		String password = "smart";
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM sample WHERE num = ? ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		SampleVO SampleVO = null;
		ResultSet rs = null;
		//코드작성
		try {
			//드라이버로드
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//DB연결
			conn = getConn();
			//prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			
			stmt.setInt(1, vo.getNum());
			rs = stmt.executeQuery();
			//결과처리(Select문만 ResultSet 객체 리턴)
			if(rs.next()) {
				SampleVO = new SampleVO(
						rs.getInt("num"),
						rs.getString("strData"),
						rs.getDate("sampleDate")
				);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, rs);
		}
		//닫기
		return SampleVO;
	}
	
	/**
	 * U:update() 수정하는 메소드
	 * 접근지정자 : public
	 * param : 수정될 값
	 * return : 없음. 
	 */
	public void update(SampleVO vo) {
		//코드작성
//		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
//		String user = "root";
//		String password = "smart";
		StringBuffer sql = new StringBuffer()
				.append(" UPDATE sample SET strData = ?, sampleDate = ? WHERE num = ? ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int idx = 0;
		
		try {
			//드라이버로드
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//DB연결
			conn = getConn();
			//prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());

			stmt.setString(++idx, vo.getStrData());
			stmt.setDate(++idx, vo.getSampleDate());
			stmt.setInt(++idx, vo.getNum());
			
			int res = stmt.executeUpdate();
			//결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
		}
		//닫기
		
	}

	/**
	 * D:delete() 삭제하는 메소드
	 * 접근지정자 : public
	 * param : 삭제될 키값
	 * return : 없음. 
	 */
	public void delete(SampleVO vo) {
//		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
//		String user = "root";
//		String password = "smart";
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE FROM sample WHERE num = ? "); 
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//드라이버로드
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//DB연결
			conn = getConn();
			//prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			
			stmt.setInt(1, vo.getNum());
			
			int res = stmt.executeUpdate();
			//결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
			
		}
		
	}


}