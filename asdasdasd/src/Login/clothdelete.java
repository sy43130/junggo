package Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WholeDAO.cltohdao;
import WholeDAO.wholedao;

public class clothdelete implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		     
		String sqnumber = request.getParameter("sqnumber");
		String id = request.getParameter("id");
				
		cltohdao dao = new cltohdao();
		dao.delete(sqnumber);
		
	    }

}
