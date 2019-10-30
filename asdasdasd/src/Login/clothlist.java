package Login;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import WholeDAO.cltohdao;
import WholeDAO.wholedao;
import WholeDTO.clothdto;

public class clothlist implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
        
		
		
		cltohdao dao = new cltohdao();

		ArrayList<clothdto> dtos = dao.list();
	   
		
		request.setAttribute("clothlist", dtos);

	}

}
