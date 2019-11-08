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
	private static final String CHARSET = "EUC-KR";
	// ���� ���� ��ġ
	
	private String ATTACHES_DIR = "C:\\Users\\PCG96\\git\\junggo\\asdasdasd\\WebContent\\image";
	private static final int LIMIT_SIZE_BYTES = 1024 * 20;



	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
	    int sqnumber= 0;
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
				if (item.isFormField()) { // �ؽ�Ʈ�� �����ϸ�
					System.out.printf("�Ķ���� �� : %s, �Ķ���� �� :  %s \n", item.getFieldName(), item.getString(CHARSET));
					
					if(item.getFieldName().equals("sqnumber")) { 
					    sqnumber = Integer.parseInt(item.getString(CHARSET)); }
					   
					if(item.getFieldName().equals("id")) {
						id = item.getString(CHARSET); // input id
					}
					if(item.getFieldName().equals("title")) {
						content = item.getString(CHARSET); // input id
					}
					if(item.getFieldName().equals("content")) {
						title = item.getString(CHARSET); // input id
					}
				} else { // ���� 
					System.out.printf("�Ķ���� �� : %s, ���� �� : %s,  ���� ũ�� : %s bytes\n", item.getFieldName(),
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
						//write(uploadFile);
					}
				}
			}

			//out.println("<h1>" + filename + "���� ���ε� �Ϸ�</h1>");

		} catch (Exception e) {
			// ���� ���ε� ó�� �� ������ �߻��ϴ� ���
			e.printStackTrace();
			//out.println("<h1>���� ���ε� �� ������  �߻��Ͽ����ϴ�.</h1>");
		}
		
		
		
		cltohdao dao = new cltohdao();
		dao.clothmodify(sqnumber,id,title,content,filename);
	    
		
		
		
	}



		
}
		
		
		
		
	


