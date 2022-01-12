package com.poscoict.emaillist01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poscoict.emaillist01.vo.EmaillistVo;

public class EmaillistDao {
	public List<EmaillistVo> findAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<EmaillistVo> result = new ArrayList<EmaillistVo>();

		try {

			// 1. JDBC드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2.연결하기
			String url = "jdbc:mysql://localhost:3306/jdbcdb?characterEncoding=UTF-8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. SQL 준비
			String sql = "select no, first_name, last_name, email from emaillist order by no desc";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			while (rs.next()) {
				long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lasstName = rs.getString(3);
				String email = rs.getString(4);

				EmaillistVo vo = new EmaillistVo();
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lasstName);
				vo.setEmail(email);
				
				result.add(vo);
			}

		} catch (ClassNotFoundException e) {
			System.out.print("드라이버 로딩 실패 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.print("error : " + e.getMessage());
		} finally {
			// 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
