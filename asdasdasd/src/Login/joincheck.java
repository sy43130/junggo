package Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WholeDAO.wholedao;
import WholeDTO.wholedto;

public class joincheck implements Command{
    private int x;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");//id�Ӽ��� �Ӽ����� �����ͼ� id�� �ִ´�.
		String pw =request.getParameter("pw");
		 
		wholedao wholeDao = new wholedao();
	    x=  wholeDao.login(id,pw); // -1 , 0 , 1
	}

	public int getX() {
		return x;
	}

}
