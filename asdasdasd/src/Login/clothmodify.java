package Login;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import WholeDAO.cltohdao;



public class clothmodify implements Command{
	


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String sqnumber = request.getParameter("sqnumber");
		String id = request.getParameter("id");
		String title =request.getParameter("title");
	    String content = request.getParameter("content");
	 
		System.out.println("시컨스" +sqnumber);
		System.out.println("아이디" +id);
		
		
		cltohdao dao = new cltohdao();
		dao.clothmodify(sqnumber,id,title,content);
	  
		
	}



		
}
		
		
		
		
	


