package Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WholeDAO.cltohdao;
import WholeDAO.wholedao;

public class userdelete implements Command {

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		
		String id = (String) session.getAttribute("id");
	    
		cltohdao cdao = new cltohdao();
		cdao.userdelete(id);
		
		wholedao dao = new wholedao();
		dao.delete(id);
	
		
		session.removeAttribute("id"); //세션값으로 가지고 있던 id 값 삭제
	
	}
	
//	public String deleteExecute(HttpServletRequest request, HttpServletResponse response) {
//	
//		
//		HttpSession session = request.getSession(false);
//		String id = (String) session.getAttribute("id");
//		
//	
//	
//	    if(id!=null){ 
//			
//			wholedao dao = new wholedao();
//			dao.delete(id);
//			
//			
//			session.removeAttribute("id"); //세션값으로 가지고 있던 id 값 삭제
//		}else {
//			
//			return "userdelete.jsp";
//		}
//		
//		response.setContentType("text/html; charset=EUC-KR");
//		PrintWriter out;
//		try {
//			out = response.getWriter();
//			out.println("<script>alert('회원 탈퇴하였습니다.');</script>");
//			out.flush();
//			
//			
//			} catch (IOException e) {
//			   e.printStackTrace();
//		}
//	     return "main.jsp";	
//		
//	}
	
}
