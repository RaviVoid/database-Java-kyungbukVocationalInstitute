/**
 * 최상진
 */

package domain;

import java.sql.Timestamp;

public class NoticeVO {
	
	private int no;
	private String title;
	private String content;
	private Timestamp inputDate;
	
	public NoticeVO() {
	//디폴트
	}

	public NoticeVO(int no, String title, String content, Timestamp inputDate) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.inputDate = inputDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public Timestamp getInputDate() {
		return inputDate;
	}

	public void setInputDate(Timestamp inputDate) {
		this.inputDate = inputDate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

	
}
