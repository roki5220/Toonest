package pj.toon.vo;

import java.util.ArrayList;

public class WebtoonVo {
	private String toon_title;
	private String toon_writer;
	private String toon_link;
	private String toon_pic;
	private String toon_site;
	private ArrayList<Integer> g_no;	//g_no은 장르 테이블의 column
	
	public String getToon_site() {
		return toon_site;
	}
	public void setToon_site(String toon_site) {
		this.toon_site = toon_site;
	}
	public String getToon_pic() {
		return toon_pic;
	}
	public void setToon_pic(String toon_pic) {
		this.toon_pic = toon_pic;
	}
	public String getToon_link() {
		return toon_link;
	}
	public void setToon_link(String toon_link) {
		this.toon_link = toon_link;
	}
	public String getToon_title() {
		return toon_title;
	}
	public void setToon_title(String toon_title) {
		this.toon_title = toon_title;
	}
	public String getToon_writer() {
		return toon_writer;
	}
	public void setToon_writer(String toon_writer) {
		this.toon_writer = toon_writer;
	}
	public ArrayList<Integer> getG_no() {
		return g_no;
	}
	public void setG_no(ArrayList<Integer> g_no) {
		this.g_no = g_no;
	}
	
}
