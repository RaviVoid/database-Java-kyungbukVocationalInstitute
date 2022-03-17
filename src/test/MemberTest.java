package test;

import dao.MemberDAO;
import domain.MemberVO;

public class MemberTest {

	public static void main(String[] args) {

		MemberVO mvo = new MemberVO();
		mvo.setId("ABCD1004-2");
		mvo.setPw("****");
		mvo.setUname("최학생");
		System.out.println(mvo);
		
		new MemberDAO().create(mvo);
		System.out.println("출력해쪄");
		
	}

}
