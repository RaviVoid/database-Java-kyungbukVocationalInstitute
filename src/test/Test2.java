package test;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import dao.SampleDAO;
import domain.SampleVO;

public class Test2 {

	public static void main(String[] args) {
		SampleDAO dao = new SampleDAO();
		//Exam 테이블의 전체 데이터를 조회한다.
//		SampleVO createVo = new SampleVO(0, "샘플문자열", new Date(0));
//		dao.create(createVo); 						//생성하기
		List<SampleVO> list = dao.read();			//읽어오기
		Iterator<SampleVO> it = list.iterator();
		while(it.hasNext()) {
			SampleVO vo = it.next();
			System.out.print(vo.getNum()+"\t");
			System.out.print(vo.getStrData()+"\t");
			System.out.print(vo.getSampleDate()+"\t");
			System.out.println();
		}											//읽어오기 끝
		//Exam 테이블의 전체 데이터를 조회한다. 끝
		
		//num컬럼이 4번인 데이터만 가지고 오기				//업데이트 1단계 (읽어오기)
		SampleVO readVo = new SampleVO();
		readVo.setNum(5);
		
		SampleVO readVoRes = dao.read(readVo);
		
		if(readVoRes != null) {
			System.out.print(readVoRes.getNum()+"\t");
			System.out.print(readVoRes.getStrData()+"\t");
			System.out.print(readVoRes.getSampleDate()+"\t");
		}

		//num컬럼이 4번인 데이터만 가지고 오기 끝				//업데이트 1단계 (읽어오기) 끝
		//num컬럼이 4번인 데이터를 수정합시다.				//업데이트 2단계 (수정하기)
		SampleVO updateVo = new SampleVO();
		updateVo.setNum(5);
		updateVo.setStrData("바꿔버려어어");
		updateVo.setSampleDate(Date.valueOf("2033-03-03"));
		dao.update(updateVo);
		//num컬럼이 4번인 데이터를 수정합시다. 끝				//업데이트 2단계 (수정하기) 끝
		//num컬럼이 4번인 데이터를 삭제합시다.				//삭제하기
//		SampleVO deleteVo = new SampleVO();
//		deleteVo.setNum(4);
//		dao.delete(deleteVo);
		//num컬럼이 4번인 데이터를 삭제합시다. 끝				//삭제하기 끝
	}

}