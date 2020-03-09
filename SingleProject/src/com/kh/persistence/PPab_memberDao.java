package com.kh.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.kh.domain.PPab_loginDto;
import com.kh.domain.PPab_memberVo;

public class PPab_memberDao {
	private static PPab_memberDao instance;
	
	private PPab_memberDao() {}
	
	public static PPab_memberDao getInstance() {
		if (instance == null) {
			instance = new PPab_memberDao();
		}
		return instance;
	}
	
	private Connection getConnection() {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/basicjsp");
			Connection conn = ds.getConnection();
			return conn;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (conn != null) try { conn.close(); } catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
		if (rs != null) try { rs.close(); } catch (Exception e) { }
	}
	
	//회원 가입
	public boolean insertMember(PPab_memberVo memberVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql ="insert into ppab_member (user_id, user_pass, user_name, user_nickname, user_money)"
					+ " values (?, ?, ?, ?, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getUser_id());
			pstmt.setString(2, memberVo.getUser_pass());
			pstmt.setString(3, memberVo.getUser_name());
			pstmt.setString(4, memberVo.getUser_nickname());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	// 아이디 중복 체크
	public boolean checkDupId(String user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select count(*) from ppab_member"
					+ " where user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count > 0) {
					return true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return false;
	}
	
	//아이디 패스워드 일치 여부
	public boolean checkMember(PPab_loginDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select count(*) from ppab_member"
					+ " where user_id = ? and user_pass = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getUser_pass());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count > 0) {
					return true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return false;
	}
	
	//회원 정보 불러오기
	public PPab_memberVo infoMember(String user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from ppab_member"
					+ " where user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				PPab_memberVo membervo = new PPab_memberVo();
				membervo.setUser_id(rs.getString("user_id"));
				membervo.setUser_pass(rs.getString("user_pass"));
				membervo.setUser_name(rs.getString("user_name"));
				membervo.setUser_nickname(rs.getString("user_nickname"));
				membervo.setUser_money(rs.getInt("user_money"));
				
				return membervo;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	//아이디 찾기
	public List<PPab_memberVo> find_user_id(PPab_memberVo memberVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from ppab_member"
					+ " where user_name = ? and user_nickname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getUser_name());
			pstmt.setString(2, memberVo.getUser_nickname());
			rs = pstmt.executeQuery();
			List<PPab_memberVo> list = new ArrayList<>();
			while(rs.next()) {
				String user_id = rs.getString("user_id");
				
				PPab_memberVo vo = new PPab_memberVo();
				vo.setUser_id(user_id);
				
				list.add(vo);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	//비밀번호 찾기
	public List<PPab_memberVo> find_user_pass(PPab_memberVo memberVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from ppab_member"
					+ " where user_id = ? and user_name = ? and user_nickname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getUser_id());
			pstmt.setString(2, memberVo.getUser_name());
			pstmt.setString(3, memberVo.getUser_nickname());
			rs = pstmt.executeQuery();
			
			List<PPab_memberVo> list = new ArrayList<>();
			while(rs.next()) {
				String user_pass = rs.getString("user_pass");
				
				PPab_memberVo vo = new PPab_memberVo();
				vo.setUser_pass(user_pass);
				
				list.add(vo);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	//회원 정보 수정
	public boolean update_member_info(PPab_memberVo memberVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "update ppab_member set"
					+ " user_name = ?,"
					+ " user_nickname = ?"
					+ " where user_id = ? and user_pass = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getUser_name());
			pstmt.setString(2, memberVo.getUser_nickname());
			pstmt.setString(3, memberVo.getUser_id());
			pstmt.setString(4, memberVo.getUser_pass());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	
	//회원 비밀 번호 수정
		public boolean update_member_pass(String user_pass, String user_id) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = getConnection();
				String sql = "update ppab_member set"
						+ " user_pass = ?"
						+ " where user_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user_pass);
				pstmt.setString(2, user_id);
				int count = pstmt.executeUpdate();
				if (count > 0) {
					return true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				closeAll(conn, pstmt, null);
			}
			return false;
		}
	//회원 삭제 >> 게시판 이나 나머지 다 한후 
}
