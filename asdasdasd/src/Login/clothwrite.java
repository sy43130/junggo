package Login;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	private String ATTACHES_DIR = "C:\\Users\\PCG96\\git\\junggo\\asdasdasd\\WebContent\\image";
	private static final int LIMIT_SIZE_BYTES = 1024 * 100;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id ="";
			
		String title ="";
			
		String content ="";
			
	    String filename ="";
			

		
		// ���� ���
		File attachesDir = new File(ATTACHES_DIR);
		//ATTACHES_DIR ��ο� �ش�Ǵ� ������ File ��ü�� �����Ѵ�. 


		// ���� ���� ��� ��ü
		// ���ε� ������ ũ�Ⱑ ������ ũ�⸦ �ѱ� �������� ���ε� �� ���� �����͸� �޸𸮿� �����ϰ�
		// ������ ũ�⸦ �ѱ� ��� �ӽ� ���͸��� ���Ϸ� ����
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		// ���� ���� ��� ��ü
		// ���ε� ������ ũ�Ⱑ ������ ũ�⸦ �ѱ� �������� ���ε� �� ���� �����͸� �޸𸮿� �����ϰ�
		// ������ ũ�⸦ �ѱ� ��� �ӽ� ���͸��� ���Ϸ� ����
		
		fileItemFactory.setRepository(attachesDir);
		// �޸� ���� �ִ� ũ�⸦ �ѱ� ��� ������ ������ ���͸��� ����. �������� ���� ��� �ý����� �⺻ �ӽ� ���͸��� ���
		
		fileItemFactory.setSizeThreshold(LIMIT_SIZE_BYTES);
		// �޸𸮿� ������ �� �մ� �ִ�ũ��. ������ ����Ʈ �⺻���� 1024����Ʈ(10kb)
		
		ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
		//���ε� ��û�� ó���ϴ� ServletFileUpload����
		
		try {
			List<FileItem> items = fileUpload.parseRequest(request);
			//���ε� ��û �Ľ��ؼ� FileItem ��� ����
			for (FileItem item : items) {
				if (item.isFormField()) { // �Ϲ��� ������ (�ؽ�Ʈ) 
					System.out.printf("�Ķ���� �� : %s, �Ķ���� �� : %s \n", item.getFieldName(), item.getString(CHARSET));
					if(item.getFieldName().equals("id")) { //�Ķ���͸� �� ���� ���̵� ��
						id = item.getString(CHARSET); // �⺻ ĳ���� ���� �̿��� �Ķ���� �� ���� id�� ��´�.
					}
					if(item.getFieldName().equals("content")) {
						content = item.getString(CHARSET); // input id
					}
					if(item.getFieldName().equals("title")) {
						title = item.getString(CHARSET); // input id
					}
				} else { // ���� �ΰ��
					System.out.printf("�Ķ���� �� : %s, ���� �� : %s,  ���� ũ�� : %s bytes \n", item.getFieldName(),
							item.getName(), item.getSize());
					filename = item.getName();//���ϸ� ������
					if (item.getSize() > 0) {//������ ũ�� 0 ��
						String separator = File.separator;
						int index = item.getName().lastIndexOf(separator);
						filename = item.getName().substring(index + 1);
						File uploadFile = new File(ATTACHES_DIR +"\\" +filename);
						//������ ���
						
					    System.out.println("separator = > " + separator);
					    System.out.println("index = > " + index);
					
						System.out.println("uploadFile = > " + ATTACHES_DIR + separator +filename);
						item.write(uploadFile);
						//���ε� �� ������ file�� ��Ÿ���� ���Ϸ� �����Ѵ�. 
					}
				}
			}

		

		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	    cltohdao dao = new cltohdao();
		dao.write(id,title,content,filename);
		
		
	}

}
