package domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class BoardDTO implements Serializable {

	//멤버변수[속성]
	private String sfl; //검색종류
	private String keyword; //검색어

	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BoardDTO [sfl=" + sfl + ", keyword=" + keyword + "]";
	}

	public BoardDTO(String sfl, String keyword) {
		super();
		this.sfl = sfl;
		this.keyword = keyword;
	}

	public String getSfl() {
		return sfl;
	}

	public void setSfl(String sfl) {
		this.sfl = sfl;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	


	
	
	
}
