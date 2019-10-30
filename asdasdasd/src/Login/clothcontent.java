package Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WholeDAO.cltohdao;
import WholeDTO.clothdto;

public class clothcontent implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String sqnumber = request.getParameter("sqnumber");
		
		cltohdao dao = new cltohdao();
		
		clothdto dto = dao.contentview(sqnumber);
		
	   
		request.setAttribute("contentview", dto);
		

		
	}

}
