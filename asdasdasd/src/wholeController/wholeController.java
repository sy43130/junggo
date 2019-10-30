package wholeController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.Command;
import Login.Join;
import Login.clothcontent;
import Login.clothdelete;
import Login.clothlist;
import Login.clothmodify;
import Login.clothwrite;
import Login.joincheck;
import Login.userdelete;
import Login.userlist;
import Login.userlogout;
import Login.usermodify;

/**
 * Servlet implementation class wholeController
 */
@WebServlet("*.do")
public class wholeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public wholeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("EUC-KR");
		
		response.setContentType("text/html; charset=EUC-KR");
		HttpSession session = request.getSession(false);
			
		
		
		String view = null;
		Command command = null;

		String uri = request.getRequestURI();
		System.out.println("URI: " + uri);

		String[] arrURI = uri.split("/");
		String comm = arrURI[arrURI.length - 1];
		System.out.println("comm: " + comm);
        
		if (comm.equals("join.do")) {
			command = new Join();
			command.execute(request, response);
			view = "createSucessed.jsp";
			
		
			
		} else if (comm.equals("joincheck.do")) {
			command = new joincheck();
			command.execute(request, response);
			PrintWriter out;
			if (((joincheck) command).getX() == 1) {
				try {
					out = response.getWriter();
					out.println("<script>alert('로그인을 성공하였습니다.');</script>");
					out.flush();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				view = "main.jsp";
			    String id = request.getParameter("id");
				session.setAttribute("id", id);
               
			} else if (((joincheck) command).getX() == 0) {
				try {
					out = response.getWriter();
					out.println("<script>alert('비밀번호 오류!');</script>");
					out.flush();
				} catch (IOException e) {

					e.printStackTrace();
				}
				view = "login.jsp";
			} else if (((joincheck) command).getX() == -1) {
				try {
					out = response.getWriter();
					out.println("<script>alert('아이디가 존재 하지 않습니다. 회원가입 페이지 이동');</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			    view = "create.jsp";
			}
		} else if (comm.equals("userlist.do")) {
			command = new userlist();
			command.execute(request, response);
		    view = "List.jsp";
		} else if (comm.equals("userdelete.do")) {
			command = new userdelete();
			command.execute(request, response);
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('회원탈퇴 성공!');</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			view = "main.jsp";
		} else if (comm.equals("usermodify.do")) {
			command = new usermodify();
			command.execute(request, response);
			
			command = new userlist();
			command.execute(request, response);
			view = "List.jsp";
        } else if (comm.equals("userlogout.do")) {
			command = new userlogout();
			command.execute(request, response);
			view = "main.jsp";
		} else if (comm.equals("usermodifyPage.do")) {
		    command = new userlist();
			command.execute(request, response);
			view = "usermodify.jsp";
		} else if (comm.equals("clothlist.do")) {
			command = new clothlist();
			command.execute(request, response);
			view = "clothlist.jsp";
		} else if (comm.equals("clothwrite_view.do")) {
			
			view = "clothwirte_view.jsp";
		} else if (comm.equals("write.do")) {
			command = new clothwrite();
			command.execute(request, response);
		
			command = null; 
		    command = new clothlist();
		    command.execute(request, response);
			view = "clothlist.jsp";  
		} else if(comm.equals("clothcontent.do")){ 
			command = new clothcontent();
			command.execute(request, response);
			view= "clothcontent.jsp";
		} else if(comm.equals("clothdelete.do")) {
			command = new clothdelete();
			command.execute(request, response);
			    
			command = new clothlist();
			command.execute(request, response);
			     view = "clothlist.jsp";
	   } else if(comm.equals("clothmodifypage.do")) {
			command = new clothcontent();
		    command.execute(request, response);
			view="clothmodify.jsp";
		} else if(comm.equals("clothmodify.do")) {
			 command = new clothmodify();
			 command.execute(request, response);
			 
			 System.out.println("여기1");
			 command = new clothcontent();
			 command.execute(request, response);
			 System.out.println("여기2");
			 view="clothcontent.jsp";
		}else {
			System.out.println("컨트롤러를 타지못했습니다 ");
		}

        
		System.out.println("request.getContextPath() = > " + request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.include(request, response);

	}

}
