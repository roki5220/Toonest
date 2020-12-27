package pj.toon.dao_hr;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pj.toon.vo.WebtoonVo;

public class WebtoonDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	// 검색어, 제목, 작가명, 썸네일, 플랫폼, 장르
//	private final String SEARCH = "SELECT toon_name, toon_writer, toon_pic, toon_site, toon_genre FROM webtoon WHERE toon_name like ? OR toon_writer like ?";
	private final String SEARCH = "SELECT toon_name, toon_writer, toon_pic, toon_site, toon_genre FROM webtoon WHERE toon_name like ?";
	private final String INSERT = "INSERT INTO webtoon VALUES(toon_seq.nextval, ?, ?, ?, ?, 0, 0, ?, 0, ?)";

	public ArrayList<WebtoonVo> search(String search) {
		ArrayList<WebtoonVo> list = new ArrayList<WebtoonVo>();
		WebtoonVo vo;
		try {
			psmt = conn.prepareStatement(SEARCH);
			psmt.setString(1, "%" + search + "%");
//			psmt.setString(2, "%" + search + "%");
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new WebtoonVo();
				vo.setToon_name(rs.getString("toon_name"));
				vo.setToon_writer(rs.getString("toon_writer"));
				vo.setToon_pic(rs.getString("toon_pic"));
				vo.setToon_site(rs.getString("toon_site"));
				vo.setToon_genre(rs.getString("toon_genre"));
//				vo.setToon_link(rs.getString("toon_link"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	/*
	 * toon_no number Primary Key, toon_name Varchar2(100) not null, toon_writer
	 * varchar2(50) not null, toon_site varchar2(50) not null, toon_genre
	 * varchar2(20) not null, toon_end number not null, toon_pay number not null,
	 * toon_pic varchar2(100) not null, toon_view number default 0, toon_link
	 * varchar2(100) not null);
	 */
	public int insert(ArrayList<WebtoonVo> list) {
		int n = 0;
		
		try {
			for (WebtoonVo vo: list) {
				psmt = conn.prepareStatement(INSERT);
				psmt.setString(1, vo.getToon_name());
				psmt.setString(2, vo.getToon_writer());
				psmt.setString(3, vo.getToon_site());
				psmt.setString(4, vo.getToon_genre());
				psmt.setString(5, vo.getToon_pic());
				psmt.setString(6, vo.getToon_link());
				
				n = psmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
