package domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class BoardVO implements Serializable {

	private int board_id; //게시글ID
	private String writer; //작성자
	private String title; //제목
	private String content; //내용
	private Timestamp regdate; //등록일자
	private int hit; //조회수

	//생성자
	public BoardVO() {
		super();
	}

	//toString
	@Override
	public String toString() {
		return "BoardVO [board_id=" + board_id + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + ", hit=" + hit + "]";
	}

	public BoardVO(int board_id, String writer, String title, String content, Timestamp regdate, int hit) {
		super();
		this.board_id = board_id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
/** DB에서 가져와서 보고 작성하면 됨
	  board_id INT NOT NULL AUTO_INCREMENT COMMENT '게시글ID', //int
	  writer VARCHAR(50) NOT NULL COMMENT '작성자',			//string
	  title VARCHAR(50) NOT NULL COMMENT '제목',				//string
	  content VARCHAR(255) NOT NULL COMMENT '내용',			//string
	  regdate DATETIME NOT NULL COMMENT '등록일자',			//timestamp
	  hit INT NULL COMMENT '조회수',							//int
**/
	

	
	
	
	
	
}
