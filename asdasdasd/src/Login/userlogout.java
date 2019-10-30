package Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class userlogout implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		 
		
	      request.getSession().invalidate();
     }

}
