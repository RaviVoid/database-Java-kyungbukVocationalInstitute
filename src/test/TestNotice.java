package test;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import dao.NoticeDAO;
import domain.NoticeVO;

public class TestNotice {

	public static void main(String[] args) {
		NoticeDAO dao = new NoticeDAO();
		NoticeVO createVo = new NoticeVO(1, "테스트", "내용", new Timestamp(System.currentTimeMillis()));
		
		dao.create(createVo);
		System.out.println("입력해쪄");
		
		List<NoticeVO> list = dao.read();
		Iterator<NoticeVO> it = list.iterator();
		while(it.hasNext()) {
			NoticeVO vo = it.next();
			System.out.print(vo.getNo()+"\t");
			System.out.print(vo.getTitle()+"\t");
			System.out.print(vo.getContent()+"\t");
			System.out.print(vo.getInputDate()+"\t");
			System.out.println();
		}
		
		
	}

}
