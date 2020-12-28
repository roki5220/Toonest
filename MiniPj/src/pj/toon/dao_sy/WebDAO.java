package pj.toon.dao_sy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pj.toon.vo.WebtoonVo;

public class WebDAO extends DAO{
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private final String SELECT_ALL = "SELECT * FROM WEBTOON ORDER BY TOON_VIEW DESC";
	
	public ArrayList<WebtoonVo> selectAll() {
		ArrayList<WebtoonVo> list = new ArrayList<WebtoonVo>();
		WebtoonVo vo;
		try {
			psmt = conn.prepareStatement(SELECT_ALL);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				vo = new WebtoonVo();
				vo.setToon_no(rs.getInt("toon_no"));
				vo.setToon_name(rs.getString("toon_name"));
				vo.setToon_writer(rs.getString("toon_writer"));
				vo.setToon_site(rs.getString("toon_site"));
				vo.setToon_pic(rs.getString("toon_pic"));
				vo.setToon_link(rs.getString("toon_link"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
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
