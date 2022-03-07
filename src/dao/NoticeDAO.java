/**
 * 최상진
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.NoticeVO;

public class NoticeDAO {

	public void create(NoticeVO vo) {

		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";;
		String user = "root";
		String password = "smart";

		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO notice ");
		sql.append(" (title, content, inputDate) ");
		sql.append(" VALUES (?, ?, ?) ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		int idx = 1;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(sql.toString());
			
			stmt.setString(idx++, vo.getTitle());
			stmt.setString(idx++, vo.getContent());
			stmt.setTimestamp(idx++, vo.getInputDate());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<NoticeVO> read() {
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM notice ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		try {
			try {
				String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";;
				String user = "root";
				String password = "smart";
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
				stmt = conn.prepareStatement(sql.toString());
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					NoticeVO vo = new NoticeVO(
							rs.getInt("no"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getTimestamp("inputDate")
					);					
					list.add(vo);
				}
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
