package test;

import java.util.Iterator;
import java.util.List;

import dao.BoardDAO;
import domain.BoardDTO;
import domain.BoardVO;

public class BoardTest {

	public static void main(String[] args) {

//글등록		
//		BoardVO bvo = new BoardVO();
//		bvo.setWriter("A002");
//		bvo.setTitle("이것이너와나의");
//		bvo.setContent("눈높이국어이다.");
//		//System.out.println(bvo.toString()); //잘 나오는지 테스트
//		new BoardDAO().create(bvo);
//		System.out.println("입력해쪄");
//글등록끝
//글목록
//		BoardVO bvo = null;
//		List<BoardVO> list = new BoardDAO().read();
//		Iterator<BoardVO> it = list.iterator();
//		while(it.hasNext()) {
//			bvo = it.next();
//			System.out.printf("%d \t %s \t %s \t %s \t %d \n",
//				bvo.getBoard_id(),
//				bvo.getWriter(),
//				bvo.getTitle(),
//				bvo.getRegdate(),
//				bvo.getHit()
//					);
//		System.out.println("조회해쪄");
//글목록끝
		
//글목록조회
//	BoardDTO bdto = new BoardDTO();
//	bdto.setSfl("title|content"); //title, content
//	bdto.setKeyword("블");
//	
//	System.out.println(bdto); //테스트
//		
//	BoardVO bvo = null;
//	List<BoardVO> list = new BoardDAO().read(bdto);
//	Iterator<BoardVO> it = list.iterator();
//	while(it.hasNext()) {
//		bvo = it.next();
//		System.out.printf("%d \t %s \t %s \t %s \t %d \n",
//			bvo.getBoard_id(),
//			bvo.getWriter(),
//			bvo.getTitle(),
//			bvo.getRegdate(),
//			bvo.getHit()
//				);
//		
//	}
//	System.out.println("찾아와쪄");  //테스트
//글목록조회끝
//글목록조회2
	BoardVO vo = new BoardVO();
	vo.setBoard_id(1);
	
	BoardVO bvo = new BoardDAO().read(vo);

	if(bvo != null) {
		System.out.printf("%d \t %s \t %s \t %s \t %s \t %d \n",
			bvo.getBoard_id(),
			bvo.getWriter(),
			bvo.getTitle(),
			bvo.getContent(),
			bvo.getRegdate(),
			bvo.getHit()
				);
	} else {
		System.out.println("해당 글이 없습니다.");
	}
	System.out.println("찾아와쪄");  //테스트
//글목록조회2끝	
	
	
	
	}

}
