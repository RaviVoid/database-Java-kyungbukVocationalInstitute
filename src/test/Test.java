package test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dao.ExamDAO;
import domain.ExamVO;

public class Test {

	public static void main(String[] args) {
		ExamDAO dao = new ExamDAO();
		//Exam 테이블의 전체 데이터를 조회한다.
		ExamVO createVo = new ExamVO(0, "가변폭문자열", "고정폭문자열", 0.123, new Date(), new Timestamp(System.currentTimeMillis()));
		dao.create(createVo);
		List<ExamVO> list = dao.read();
		Iterator<ExamVO> it = list.iterator();
		while(it.hasNext()) {
			ExamVO vo = it.next();
			System.out.print(vo.getNum()+"\t");
			System.out.print(vo.getVarcharTest()+"\t");
			System.out.print(vo.getCharTest()+"\t");
			System.out.print(vo.getDoubleTest()+"\t");
			System.out.print(vo.getDateTest()+"\t");
			System.out.print(vo.getDateTimeTest()+"\t");
			System.out.println();
		}
		//Exam 테이블의 전체 데이터를 조회한다. 끝
		
		//num컬럼이 4번인 데이터만 가지고 오기
		ExamVO readVo = new ExamVO();
		readVo.setNum(4);
		
		ExamVO readVoRes = dao.read(readVo);
		
		if(readVoRes != null) {
			System.out.print(readVoRes.getNum()+"\t");
			System.out.print(readVoRes.getVarcharTest()+"\t");
			System.out.print(readVoRes.getCharTest()+"\t");
			System.out.print(readVoRes.getDoubleTest()+"\t");
			System.out.print(readVoRes.getDateTest()+"\t");
			System.out.print(readVoRes.getDateTimeTest()+"\t");
		}

		//num컬럼이 4번인 데이터만 가지고 오기 끝
		//num컬럼이 4번인 데이터를 수정합시다.
		ExamVO updateVo = new ExamVO();
		updateVo.setNum(4);
		updateVo.setVarcharTest("바꿀값");
		updateVo.setDoubleTest(123.12);
		dao.update(updateVo);
		//num컬럼이 4번인 데이터를 수정합시다. 끝
		//num컬럼이 4번인 데이터를 삭제합시다.
		ExamVO deleteVo = new ExamVO();
		deleteVo.setNum(4);
		dao.delete(deleteVo);
		//num컬럼이 4번인 데이터를 삭제합시다. 끝
	}

}






