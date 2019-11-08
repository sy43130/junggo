package WholeDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import Login.joincheck;
import WholeDTO.clothdto;
import WholeDTO.wholedto;

public class wholedao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1522:orcl";
	String dId = "junggo";
	String dPw = "oracle_11g";

	public void join(String id, String pw, String name, String phone, int age, String city) {

		Connection con = null;
		PreparedStatement psmts = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, dId, dPw);

			String sql = "INSERT INTO USERTABLE(id, pw ,name ,phone,age, city) VALUES(?,?,?,?,?,?)";
			psmts = con.prepareStatement(sql);

			psmts.setString(1, id);
			psmts.setString(2, pw);
			psmts.setString(3, name);
			psmts.setString(4, phone);
			psmts.setInt(5, age);
			psmts.setString(6, city);
			
			psmts.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmts != null)
					psmts.close();
				if (con != null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}// join

	public int login(String id, String pw) {
		
		Connection con = null;
		PreparedStatement psmts = null;
		ResultSet rs = null;

		int x = -1;

		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, dId, dPw);// 데이터베이스 연결

			String sql = "SELECT pw FROM USERTABLE WHERE id = ?";
			psmts = con.prepareStatement(sql);

			psmts.setString(1, id);
			rs = psmts.executeQuery();

			if (rs.next()) {
				String dbpw = rs.getString("pw");
				// a, b
				// b , null

				if (dbpw.equals(pw)) {
					x = 1;//로그인성공시
				} else {
					x = 0; // alert 로그인 비번이 틀렸습니다
				}
			} else {
				x = -1; // alert 회원이 존재 않습니다ㄴ
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmts != null)
					psmts.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return x;
	}

	public wholedto list(String Id) {
	
		wholedto dto = null;

		Connection con = null;
		PreparedStatement psmts = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, dId, dPw);// 데이터베이스 연결

			String sql = "SELECT * FROM USERTABLE WHERE ID = ?";// 직접 넣을 꺼는 바인딩 변수 처리
			
			psmts = con.prepareStatement(sql);
			psmts.setString(1, Id);
			rs = psmts.executeQuery();

			if (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				int age = rs.getInt("age");
				String city = rs.getString("city");

				dto = new wholedto(id, pw, name, phone, age, city);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmts != null)
					psmts.close();
				if (con != null)
					con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public void delete(String Id) {
		
		Connection con = null;
		PreparedStatement psmts = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, dId, dPw);
			
			String query = "DELETE FROM USERTABLE WHERE id=?"; 
			
			
			psmts = con.prepareStatement(query);
		    
			psmts.setString(1, Id);
			
			psmts.executeUpdate();
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(psmts!=null) psmts.close();
				if(con!=null) con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}//delete

	
		public void modify(String id, String pw, String name, String phone, int age, String city) {
			
			Connection con = null;
			PreparedStatement psmts = null;
			
		
			try {
				
				Class.forName(driver);
				con = DriverManager.getConnection(url, dId, dPw);
			
				
				String query = "UPDATE USERTABLE SET pw=?, name=?, phone=?,age=? ,city=? where id=?";//바인딩변수
//		
				psmts =  con.prepareStatement(query);
				

				psmts.setString(1, pw);
				psmts.setString(2, name);
				psmts.setString(3, phone);
				psmts.setInt(4, age);
				psmts.setString(5, city);
			
				//바인딩 변수 셋팅
				psmts.setString(6, id);//바인딩 변수 셋팅
				
				psmts.executeUpdate();
			  
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(psmts!=null) psmts.close();
					if(con!=null) con.close();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}//modify
		
		
		
		
	}
	

