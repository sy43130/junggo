package Login;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import WholeDAO.cltohdao;

public class clothwrite implements Command {
	// ĳ���ͼ�
	private static final String CHARSET = "EUC-KR";
	// ���� ���� ��ġ
	
	private String ATTACHES_DIR = "C:\\Users\\PCG96\\Desktop\\workspace_JSP\\asdasdasd\\WebContent\\image";
	private static final int LIMIT_SIZE_BYTES = 1024 * 20;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id ="";
			
		String title ="";
			
		String content ="";
			
	    String filename ="";
			

		
		// ���� ���
		File attachesDir = new File(ATTACHES_DIR);
		// ���� ���� ��� ��ü
		// ���ε� ������ ũ�Ⱑ ������ ũ�⸦ �ѱ� �������� ���ε� �� ���� �����͸� �޸𸮿� �����ϰ�
		// ������ ũ�⸦ �ѱ� ��� �ӽ� ���͸��� ���Ϸ� ����
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		// �޸� ���� �ִ� ũ�⸦ �ѱ� ��� ������ ������ ���͸��� ����. �������� ���� ��� �ý����� �⺻ �ӽ� ���͸��� ���
		fileItemFactory.setRepository(attachesDir);
		// �޸𸮿� ������ �� �մ� �ִ�ũ��. ������ ����Ʈ �⺻���� 10240����Ʈ(10kb)
		fileItemFactory.setSizeThreshold(LIMIT_SIZE_BYTES);
		ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
		
		//�˻�~!
        
		try {
			List<FileItem> items = fileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) { // �ؽ�Ʈ 
					System.out.printf("�Ķ���� �� : %s, �Ķ���� �� :  %s \n", item.getFieldName(), item.getString(CHARSET));
					if(item.getFieldName().equals("id")) {
						id = item.getString(CHARSET); // input id
					}
					if(item.getFieldName().equals("content")) {
						content = item.getString(CHARSET); // input id
					}
					if(item.getFieldName().equals("title")) {
						title = item.getString(CHARSET); // input id
					}
				} else { // ���� 
					System.out.printf("�Ķ���� �� : %s, ���� �� : %s,  ���� ũ�� : %s bytes \n", item.getFieldName(),
							item.getName(), item.getSize());
					filename = item.getName();
					if (item.getSize() > 0) {
						String separator = File.separator;
						int index = item.getName().lastIndexOf(separator);
						filename = item.getName().substring(index + 1);
						File uploadFile = new File(ATTACHES_DIR + "\\" + filename);
						
//						System.out.println("separator = > " + separator);
//						System.out.println("index = > " + index);
//						
//						System.out.println("uploadFile = > " + ATTACHES_DIR + separator +filename);
						item.write(uploadFile);
					}
				}
			}

			//out.println("<h1>" + filename + " ���� ���ε� �Ϸ�</h1>");

		} catch (Exception e) {
			// ���� ���ε� ó�� �� ������ �߻��ϴ� ���
			e.printStackTrace();
			//out.println("<h1>���� ���ε� �� ������  �߻��Ͽ����ϴ�.</h1>");
		}
		
		
	    cltohdao dao = new cltohdao();
		dao.write(id,title,content,filename);
		
		
	}

}
