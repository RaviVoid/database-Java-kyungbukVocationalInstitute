package test;

import java.sql.Timestamp;
import java.util.Date;

import dao.ExamDAO;
import domain.ExamVO;

public class Test {

	public static void main(String[] args) {
		ExamDAO dao = new ExamDAO();
		
		ExamVO createVo = new ExamVO(0, "가변폭문자열", "고정폭문자열", 0.123, new Date(), new Timestamp(System.currentTimeMillis()));
		
		dao.create(createVo);
		System.out.println("만들어쪄");
		//System.out.println(createVo);
		//dao.read(readVo);
		//Timestamp stamp = new Timestamp(System.currentTimeMillis());
		//Date date = new Date(stamp.getTime());
		//Date date = new Date(new Timestamp(System.currentTimeMillis()).getTime());
		//System.out.println(date);
		
		// new Date(vo.getDateTest().getTime())
		
	}

}
