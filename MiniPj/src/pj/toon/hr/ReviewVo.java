package pj.toon.hr;

import java.util.ArrayList;

public class ReviewVo {
	private int review_no;
	private int toon_no;
	private String review_content;
	private int review_star;
	private String nickname;
	private String password;
	
	private ArrayList<String> keyList;
	
	public ArrayList<String> getKeyList() {
		return keyList;
	}
	public void setKeyList(ArrayList<String> keyList) {
		this.keyList = keyList;
	}
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public int getToon_no() {
		return toon_no;
	}
	public void setToon_no(int toon_no) {
		this.toon_no = toon_no;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public int getReview_star() {
		return review_star;
	}
	public void setReview_star(int review_star) {
		this.review_star = review_star;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
