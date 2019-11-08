package Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WholeDAO.wholedao;
import WholeDTO.wholedto;

public class usermodify implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);

	    String id = (String) session.getAttribute("id");

		                                  
		String pw = request.getParameter("pw");
		
		String name = request.getParameter("name");
		
		String phone =request.getParameter("phone");

        int age = Integer.parseInt(request.getParameter("age"));
        
        String city = request.getParameter("city");
      
		wholedao wholeDao = new wholedao();
	
		wholeDao.modify(id, pw, name, phone, age, city);

	    
	}

}
