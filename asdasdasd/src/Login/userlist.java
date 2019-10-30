package Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WholeDAO.wholedao;
import WholeDTO.wholedto;
import Login.joincheck;

public class userlist implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
	    String id = (String)request.getSession(false).getAttribute("id");
	   
	    wholedao dao = new wholedao();
	    
	    wholedto dtoss =dao.list(id);
	
		request.setAttribute("idList", dtoss);
		
	}

}
