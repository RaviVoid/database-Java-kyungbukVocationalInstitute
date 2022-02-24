package dao;

import java.util.List;

public class Simple2DAO {

	/**
	 * C:create() 등록하는 메소드
	 * 접근지정자 : public
	 * param : 등록될 값
	 * return : 없음. 
	 */
	public void create() {
		//코드작성
		try {
			//드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DB연결
			//prepereStatament(SQL작성 실행)
			//결과처리(Select문만 ResultSet 객체 리턴)
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//닫기		
	}

	/**
	 * R:read() 조회하는 메소드
	 * 접근지정자 : public
	 * param : 조회할 값
	 * return : List 
	 */
	public List read() {
		//코드작성
		//드라이버로드
				//DB연결
				//prepereStatament(SQL작성 실행)
				//결과처리(Select문만 ResultSet 객체 리턴)
				//닫기
		return null;
	}

	/**
	 * U:update() 수정하는 메소드
	 * 접근지정자 : public
	 * param : 수정될 값
	 * return : 없음. 
	 */
	public void update() {
		//코드작성
		//드라이버로드
				//DB연결
				//prepereStatament(SQL작성 실행)
				//결과처리(Select문만 ResultSet 객체 리턴)
				//닫기
		
	}

	/**
	 * D:delete() 삭제하는 메소드
	 * 접근지정자 : public
	 * param : 삭제될 키값
	 * return : 없음. 
	 */
	public void delete() {
		//코드작성
		//드라이버로드
				//DB연결
				//prepereStatament(SQL작성 실행)
				//결과처리(Select문만 ResultSet 객체 리턴)
				//닫기
		
	}
}





