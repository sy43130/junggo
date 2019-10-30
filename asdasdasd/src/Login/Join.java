package Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WholeDAO.wholedao;

public class Join implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		   String id = request.getParameter("id");
		   String pw =request.getParameter("pw");
		   String name =request.getParameter("name");
		   String phone =request.getParameter("phone");
		   int age  =Integer.parseInt(request.getParameter("age"));
		   String city =request.getParameter("city");
		   
		   wholedao wholeDao = new wholedao();
		   wholeDao.join(id,pw,name,phone,age,city);
	}
}
