package pj.toon.vo;

public class WebtoonVo {
	private int toon_no;
	private String toon_name;
	private String toon_writer;
	private String toon_pic;
	private String toon_site;
	private String toon_genre;	//g_no은 장르 테이블의 column
	private String toon_link;
	private int toon_view;
	private double avg_star;
	
	
	
	public double getAvg_star() {
		return avg_star;
	}
	public void setAvg_star(double avg_star) {
		this.avg_star = avg_star;
	}
	public int getToon_view() {
		return toon_view;
	}
	public void setToon_view(int toon_view) {
		this.toon_view = toon_view;
	}
	public int getToon_no() {
		return toon_no;
	}
	public void setToon_no(int toon_no) {
		this.toon_no = toon_no;
	}
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
	public String getToon_name() {
		return toon_name;
	}
	public void setToon_name(String toon_name) {
		this.toon_name = toon_name;
	}
	public String getToon_writer() {
		return toon_writer;
	}
	public void setToon_writer(String toon_writer) {
		this.toon_writer = toon_writer;
	}
	public String getToon_genre() {
		return toon_genre;
	}
	public void setToon_genre(String toon_genre) {
		this.toon_genre = toon_genre;
	}
	public String getToon_link() {
		return toon_link;
	}
	public void setToon_link(String toon_link) {
		this.toon_link = toon_link;
	}
	
}
