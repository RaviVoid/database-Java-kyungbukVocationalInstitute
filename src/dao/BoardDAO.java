package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.BoardDTO;
import domain.BoardVO;

public class BoardDAO {

	//전역변수로 모든 메소드에서 사용 가능 앞에 private 추가해줌
	private String url = "jdbc:mysql://localhost:3306/kbLab?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
	private String user = "root";
	private String password = "smart";
	
	//CRRUD
	
	//CREATE 시작
	public void create(BoardVO vo) {
		
		
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO kblab.board ");
		query.append("	(board_id, writer, title, content, regdate, hit) ");
		query.append("  VALUES (null, ?, ?, ?, now(), 0) ");
		
		String sql = query.toString();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
						
			//디비연결
			conn =  DriverManager.getConnection(url, user, password);
						
			//에스큐엘 명령어 작성 및 실행
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getWriter());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getContent());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//닫기
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}//CREATE 끝
	
	//READ1 시작
	public List<BoardVO> read() {
		
		// <BoardVO> 제네릭설정 자동 행바꿈
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO bvo = null; //전역변수설정
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		StringBuffer query = new StringBuffer();
		query.append(" SELECT b.board_id, b.title, ");
		query.append( "	b.writer, b.regdate, b.hit ");
		query.append( "	FROM kblab.board as b ");
		query.append( "    JOIN kblab.member as m ");
		query.append( "    ON m.id = b.writer ");
		query.append( "    ORDER BY b.regdate DESC; ");
		String sql = query.toString();
		
		try {
			//드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//디비연결
			conn = DriverManager.getConnection(url, user, password);
			
			//에스큐엘 명령어작성 및 실행
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				bvo = new BoardVO();
				bvo.setBoard_id(rs.getInt("board_id"));
				bvo.setTitle(rs.getString("title"));
				bvo.setWriter(rs.getString("writer"));
				bvo.setRegdate(rs.getTimestamp("regdate"));
				bvo.setHit(rs.getInt("hit"));
				list.add(bvo);
			}
			
		} catch (Exception e) {
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
		return list;
	}
	//READ1 끝
	//READ2 시작
	
	public List<BoardVO> read(BoardDTO dto) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO bvo = null;
		
		StringBuffer query = new StringBuffer();
		query.append(" SELECT b.board_id, b.title, ");
		query.append( "	b.writer, b.regdate, b.hit ");
		query.append( "	FROM kblab.board as b ");
		query.append( "    JOIN kblab.member as m ");
		query.append( "    ON m.id = b.writer ");
		
		if("title".equals(dto.getSfl())) {
			query.append( "    WHERE b.title LIKE ? ");
		}
		if("content".equals(dto.getSfl())) {
			query.append( "    WHERE b.content LIKE ? ");
		}
		if("title|content".equals(dto.getSfl())) {
			query.append( "    WHERE b.title LIKE ? OR b.content LIKE ? ");
		}
		query.append( "    ORDER BY b.board_id DESC; ");
		
		System.out.println(query);  //테스트
		
		String sql = query.toString();
		
		try {
			//드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//디비연결
			conn = DriverManager.getConnection(url, user, password);
			
			//에스큐엘 명령어작성 및 실행
			stmt = conn.prepareStatement(sql);
			
			int idx = 1;
			if("title".equals(dto.getSfl())) {
				stmt.setString(idx++, "%" + dto.getKeyword() + "%");
			}
			if("content".equals(dto.getSfl())) {
				stmt.setString(idx++, "%" + dto.getKeyword() + "%");
			}
			if("title|content".equals(dto.getSfl())) {
				stmt.setString(idx++, "%" + dto.getKeyword() + "%");
				stmt.setString(idx++, "%" + dto.getKeyword() + "%");
			}
			
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				bvo = new BoardVO();
				bvo.setBoard_id(rs.getInt("board_id"));
				bvo.setTitle(rs.getString("title"));
				bvo.setWriter(rs.getString("writer"));
				bvo.setRegdate(rs.getTimestamp("regdate"));
				bvo.setHit(rs.getInt("hit"));
				list.add(bvo);
			}
			
			
		} catch (Exception e) {
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
		
		//닫기
		return list;
	}
	//READ2 끝
	//READ3
	
	public BoardVO read(BoardVO bvo) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		StringBuffer query = new StringBuffer();
		query.append(" SELECT b.board_id, b.title, b.content, ");
		query.append( "	b.writer, b.regdate, b.hit ");
		query.append( "	FROM kblab.board as b ");
		query.append( "    JOIN kblab.member as m ");
		query.append( "    ON m.id = b.writer ");
		query.append( " WHERE b.board_id = ? ");
		
		String sql = query.toString();
		
		System.out.println(query);
		
		try {
			//드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//디비연결
			conn = DriverManager.getConnection(url, user, password);

			//에스큐엘 명령어작성 및 실행
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, bvo.getBoard_id());
			rs = stmt.executeQuery();
			if(rs.next()) {
				vo = new BoardVO();
				vo.setBoard_id(rs.getInt("board_id"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setWriter(rs.getString("content"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				vo.setHit(rs.getInt("hit"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		//닫기
		return vo;
	}
	//READ3 끝
	
	
}
