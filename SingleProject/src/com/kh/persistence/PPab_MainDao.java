package com.kh.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.kh.domain.PPab_boardVo;
import com.kh.domain.PPab_commentVo;
import com.kh.domain.PPab_menuVo;

public class PPab_MainDao {
	private static PPab_MainDao instance;
	
	private PPab_MainDao() {}
	
	public static PPab_MainDao getInstance() {
		if (instance == null) {
			instance = new PPab_MainDao();
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
	
	//search box 메뉴 종류 찾기
	public List<Map<String, Object>> menu(String index, String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select menu_desc "+index+" from ppab_menu"
					+ " where menu_code like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			List<Map<String, Object>> list = new ArrayList<>();
			while (rs.next()) {
				String items = rs.getString(1);
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put(index, items);
				
				list.add(paramMap);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	//김밥 정보 얻기
	public PPab_menuVo getInfoGimppab(String menu) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from ppab_menu"
					+ " where menu_code like 'M%'"
					+ " and menu_desc = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String code = rs.getString("menu_code");
				String desc = rs.getString("menu_desc");
				int price = rs.getInt("menu_price");
				
				PPab_menuVo menuVo = new PPab_menuVo();
				menuVo.setMenu_code(code);
				menuVo.setMenu_desc(desc);
				menuVo.setMenu_price(price);
				return menuVo;
			}
			
		}catch(Exception e) {
			
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	
	//고객의 소리 글쓰기
	public boolean write(PPab_boardVo boardVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "insert into PPAB_BOARD (BOARD_NUM, BOARD_CATEGORY_NUM, USER_ID, BOARD_CONTENT, BOARD_IMAGES, BOARD_READ_COUNT, MENU_CODE, BOARD_REPLY_COUNT, BOARD_SUBJECT)"
					+ " values (seq_board_num.nextval, seq_customer_board_num.nextval, ?, ?, ?, 0, 'C2', 0, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getUser_id());
			pstmt.setString(2, boardVo.getBoard_content());
			pstmt.setString(3, boardVo.getBoard_images());
			pstmt.setString(4, boardVo.getBoard_subject());
			int count = pstmt.executeUpdate();
			if(count > 0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	
	//고객의 소리 목록 가져오기
	public List<PPab_boardVo> getList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from ppab_board"
					+ " where menu_code = 'C2'"
					+ " order by board_category_num desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<PPab_boardVo> list = new ArrayList<>();
			while (rs.next()) {
				int board_category_num = rs.getInt("board_category_num");
				String user_id = rs.getString("user_id");
				String board_subject = rs.getString("board_subject");
				String board_content = rs.getString("board_content");
				String board_images = rs.getString("board_images");
				int board_read_count = rs.getInt("board_read_count");
				String menu_code = rs.getString("menu_code");
				int board_reply_count = rs.getInt("board_reply_count");
				Timestamp board_reg_date = rs.getTimestamp("board_reg_date");
				
				PPab_boardVo boardVo = new PPab_boardVo();
				boardVo.setBoard_category_num(board_category_num);
				boardVo.setUser_id(user_id);
				boardVo.setBoard_subject(board_subject);
				boardVo.setBoard_content(board_content);
				boardVo.setBoard_images(board_images);
				boardVo.setBoard_read_count(board_read_count);
				boardVo.setMenu_code(menu_code);
				boardVo.setBoard_reply_count(board_reply_count);
				boardVo.setBoard_reg_date(board_reg_date);
				
				list.add(boardVo);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	//게시글 상세보기
	public PPab_boardVo getContent(int board_category_num, String menu_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			String sql2 = "update ppab_board set"
					+ " board_read_count = board_read_count + 1"
					+ " where board_category_num = ? and menu_code = ?";
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, board_category_num);
			pstmt2.setString(2, menu_code);
			pstmt2.executeUpdate();
			
			String sql = "select * from ppab_board"
					+ " where board_category_num = ? and menu_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_category_num);
			pstmt.setString(2, menu_code);
			rs = pstmt.executeQuery();
			conn.commit();
			if (rs.next()) {
				int board_num = rs.getInt("board_num");
				String user_id = rs.getString("user_id");
				String board_subject = rs.getString("board_subject");
				String board_content = rs.getString("board_content");
				String board_images = rs.getString("board_images");
				int board_read_count = rs.getInt("board_read_count");
				int board_reply_count = rs.getInt("board_reply_count");
				Timestamp board_reg_date = rs.getTimestamp("board_reg_date");
				
				PPab_boardVo boardVo = new PPab_boardVo();
				boardVo.setBoard_num(board_num);
				boardVo.setUser_id(user_id);
				boardVo.setBoard_subject(board_subject);
				boardVo.setBoard_content(board_content);
				boardVo.setBoard_images(board_images);
				boardVo.setBoard_read_count(board_read_count);
				boardVo.setBoard_reply_count(board_reply_count);
				boardVo.setBoard_reg_date(board_reg_date);
				
				return boardVo;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	
	//게시판 글 수정하기
	public boolean updateCustomerBoardContent(PPab_boardVo boardVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "update ppab_board set"
					+ " board_subject = ?,"
					+ " board_content = ?,"
					+ " board_images = ?"
					+ " where board_category_num = ? and menu_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_subject());
			pstmt.setString(2, boardVo.getBoard_content());
			pstmt.setString(3, boardVo.getBoard_images());
			pstmt.setInt(4, boardVo.getBoard_category_num());
			pstmt.setString(5, boardVo.getMenu_code());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	
	//댓글 작성하기
	public boolean insertComment(PPab_commentVo commentVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into ppab_reply(board_reply_num, board_category_num, user_id, reply_content)"
					+ " values (seq_board_reply_num.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentVo.getBoard_category_num());
			pstmt.setString(2, commentVo.getUser_id());
			pstmt.setString(3, commentVo.getReply_content());
			int result = pstmt.executeUpdate();
			
			String sql2 = "update ppab_board set"
					+ " board_reply_count = board_reply_count + 1"
					+ " where board_category_num = ?";
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, commentVo.getBoard_category_num());
			int result2 = pstmt2.executeUpdate();
			conn.commit();
			if ((result+result2)>=2) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt2, null);
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	//댓글 리스트
	public List<PPab_commentVo> getCommentList(int board_category_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from ppab_reply"
					+ " where board_category_num = ?"
					+ " order by board_reply_num desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_category_num);
			rs = pstmt.executeQuery();
			List<PPab_commentVo> list = new ArrayList<PPab_commentVo>();
			while (rs.next()) {
				PPab_commentVo commentVo = new PPab_commentVo();
				
				commentVo.setBoard_reply_num(rs.getInt("board_reply_num"));
				commentVo.setBoard_category_num(rs.getInt("board_category_num"));
				commentVo.setUser_id(rs.getString("user_id"));
				commentVo.setReply_reg_date(rs.getTimestamp("reply_reg_date"));
				commentVo.setReply_content(rs.getString("reply_content"));
				
				list.add(commentVo);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	//게시판 글 삭제하기
	public boolean deleteCustomerBoardContent(int board_category_num, String menu_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "delete from ppab_board"
					+ " where board_category_num = ? and menu_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_category_num);
			pstmt.setString(2, menu_code);
			int result = pstmt.executeUpdate();
			if (result > 0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	
	//장바구니에 담기
	public boolean insertBasket(String user_id, String menu_code, int menu_price, int menu_count) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "insert into ppab_user_order (order_num, user_id, menu_code, menu_price, menu_count)"
					+ " values (seq_order_num.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, menu_code);
			pstmt.setInt(3, menu_price);
			pstmt.setInt(4, menu_count);
			int rs = pstmt.executeUpdate();
			if (rs > 0 ) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	//장바구니 보여주기
	public List<Map<String, Object>> getBasket(String user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from ppab_user_order u, ppab_menu m"
					+ " where u.menu_code = m.menu_code"
					+ " and u.user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			List<Map<String, Object>> list = new ArrayList<>();
			while (rs.next()) {
				int order_num = rs.getInt("order_num");
				String menu_code = rs.getString("menu_code");
				String menu_desc = rs.getString("menu_desc");
				int menu_count = rs.getInt("menu_count");
				int menu_price = rs.getInt("menu_price");
				Timestamp order_reg_date = rs.getTimestamp("order_reg_date");
				
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("order_num", order_num);
				paramMap.put("menu_code", menu_code);
				paramMap.put("menu_desc", menu_desc);
				paramMap.put("menu_count", menu_count);
				paramMap.put("menu_price", menu_price);
				paramMap.put("order_reg_date", order_reg_date);
				
				list.add(paramMap);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	//장바구니 부분 삭제
	public boolean basket_partial_delete(Map<String, Object> paramMap) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "delete from ppab_user_order"
					+ " where user_id = ? "
					+ " and order_num in("+(String)paramMap.get("order_nums")+")";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String)paramMap.get("user_id"));
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	//장바구니에서 주문 보내고 내역 남기기
	public void orderlist(List<Map<String, Object>> list, String user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = getConnection();
			int v = 0;
			for (int i = 0; i < list.size(); i++) {
			
				String sql = "insert into ppab_user_order_list(order_list_num, user_id, menu_count,"
					+ " menu_code, menu_price)"
					+ " values(seq_order_list_num.nextval, ?, ?, ?, ?)";
				System.out.println("sql:" + sql);
				Map<String, Object> map = list.get(i);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(++v, user_id);
				pstmt.setInt(++v, (int)map.get("menu_count"));
				pstmt.setString(++v, (String)map.get("menu_code"));
				pstmt.setInt(++v, (int)map.get("menu_price"));
				pstmt.executeUpdate();
				pstmt.close();
				v = 0;
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
	}
	//주문 내역 보여주기
		public List<Map<String, Object>> getOrderList(String user_id) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = getConnection();
				String sql = "select * from ppab_user_order_list o, ppab_menu m"
						+ " where o.menu_code = m.menu_code"
						+ " and user_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user_id);
				rs = pstmt.executeQuery();
				List<Map<String, Object>> list = new ArrayList<>();
				while (rs.next()) {
					int order_list_num = rs.getInt("order_list_num");
					String menu_code = rs.getString("menu_code");
					String menu_desc = rs.getString("menu_desc");
					int menu_count = rs.getInt("menu_count");
					int menu_price = rs.getInt("menu_price");
					Timestamp order_list_reg_date = rs.getTimestamp("order_list_reg_date");
					
					Map<String, Object> paramMap = new HashMap<>();
					paramMap.put("order_list_num", order_list_num);
					paramMap.put("menu_code", menu_code);
					paramMap.put("menu_desc", menu_desc);
					paramMap.put("menu_count", menu_count);
					paramMap.put("menu_price", menu_price);
					paramMap.put("order_list_reg_date", order_list_reg_date);
					
					list.add(paramMap);
				}
				return list;
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				closeAll(conn, pstmt, rs);
			}
			return null;
		}
	
}
