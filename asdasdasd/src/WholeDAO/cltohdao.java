package WholeDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import WholeDTO.clothdto;
import WholeDTO.wholedto;

public class cltohdao {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1522:orcl";
	String dId = "junggo";
	String dPw = "oracle_11g";
	
	private String ATTACHES_DIR = "../image";
	public ArrayList<clothdto> list() {

	
		ArrayList<clothdto> array = new ArrayList<clothdto>();

		Connection con = null;
		PreparedStatement psmts = null;
		ResultSet rs = null;
        
		clothdto dto = null;
		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, dId, dPw);// 데이터베이스 연결

			String sql = "SELECT * FROM cloth ORDER BY sqnumber desc";

			
			psmts = con.prepareStatement(sql);
			rs = psmts.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String Title = rs.getString("title");
			    String Content = rs.getString("content");
			    String filename = rs.getString("filename");
			    
				int sqnumber = rs.getInt("sqnumber");
			
			    dto = new clothdto(sqnumber,id, Title,Content,filename);

				array.add(dto);
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
					con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return array;
	}// clothlist

	public void write(String id, String title, String content, String filename) {

		
		Connection con = null;
		PreparedStatement psmts = null;
    
		
		
		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, dId, dPw);// 데이터베이스 연결
			
			String query = "INSERT INTO cloth(Id, Title, Content,sqnumber,filename) VALUES(?,?,?,cloth_sequence.nextval,?)";

			psmts = con.prepareStatement(query);
			psmts.setString(1, id);
			psmts.setString(2, title);
			psmts.setString(3, content);
			psmts.setString(4, filename);

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
		
		
	} // write
	
	public clothdto contentview(int sqnumbers) {
		                       //String sqnumbers

		Connection con = null;
		PreparedStatement psmts = null;
		ResultSet rs = null;

		clothdto dto = null;
		
		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, dId, dPw);// 데이터베이스 연결

			String sql = "SELECT * FROM cloth WHERE sqnumber=?";

			// 처리
			psmts = con.prepareStatement(sql);
			//psmts.setInt(1, Integer.parseInt(sqnumbers));
			psmts.setInt(1, sqnumbers);
			rs = psmts.executeQuery();
            
			if(rs.next()) {
				
				String id = rs.getString("id");
				String Title = rs.getString("title");
				String Content = rs.getString("content");
				String filename = rs.getString("filename");
				filename = ATTACHES_DIR + "\\" + filename;
				//int sqnumber = rs.getInt("sqnumber");
				int sqnumber = rs.getInt("sqnumber");
				
				dto = new clothdto(sqnumber,id, Title, Content,filename);
                
				
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
					con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;

	}//contentview

	
	public void delete(String sqnumber) {
		
		Connection con = null;
		PreparedStatement pstms = null;
		
		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, dId, dPw);// 데이터베이스 연결
			
			String query = "DELETE FROM cloth WHERE sqnumber=?"; 
			
			
			pstms = con.prepareStatement(query);
		    
			pstms.setInt(1, Integer.parseInt(sqnumber));//아이디는 인트형
			
			pstms.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstms!=null) pstms.close();
				if(con!=null) con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}//delete
	
public void userdelete(String id) {
		
		Connection con = null;
		PreparedStatement pstms = null;
		
		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, dId, dPw);// 데이터베이스 연결
			
			String query = "DELETE FROM cloth WHERE id=?"; 
			
			
			pstms = con.prepareStatement(query);
		    
			pstms.setString(1, id);//아이디는 인트형
			
			pstms.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstms!=null) pstms.close();
				if(con!=null) con.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}//delete
	
	public void clothmodify(int sqnumber,String id, String title, String content, String filename) {
		//String sqnumber,String id, String title, String content, String filename
		Connection con = null;
		PreparedStatement psmts = null;
		
		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, dId, dPw);// 데이터베이스 연결
			
			String query = "UPDATE cloth SET id=?, Title=?, Content=? , filename=? WHERE sqnumber=?";
			
			
			psmts = con.prepareStatement(query);
			
			psmts.setString(1, id);//바인딩 변수 셋팅
			psmts.setString(2, title);
			psmts.setString(3, content);
			psmts.setString(4, filename);
			filename = ATTACHES_DIR + "\\" + filename;
		    //psmts.setInt(5, Integer.parseInt(sqnumber));
			psmts.setInt(5, sqnumber);
			
			
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
	
	
}//
