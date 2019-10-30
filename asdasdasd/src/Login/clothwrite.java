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
	// 캐릭터셋
	private static final String CHARSET = "EUC-KR";
	// 파일 저장 위치
	
	private String ATTACHES_DIR = "C:\\Users\\PCG96\\Desktop\\workspace_JSP\\asdasdasd\\WebContent\\image";
	private static final int LIMIT_SIZE_BYTES = 1024 * 20;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id ="";
			
		String title ="";
			
		String content ="";
			
	    String filename ="";
			

		
		// 파일 경로
		File attachesDir = new File(ATTACHES_DIR);
		// 파일 저장 담당 객체
		// 업로드 파일의 크기가 지정한 크기를 넘기 전까지는 업로드 한 파일 데이터를 메모리에 저장하고
		// 지정한 크기를 넘길 경우 임시 디렉터리에 파일로 저장
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		// 메모리 저장 최대 크기를 넘길 경우 파일을 생성할 디렉터리를 지정. 지정하지 않을 경우 시스템의 기본 임시 디렉터리를 사용
		fileItemFactory.setRepository(attachesDir);
		// 메모리에 저장할 수 잇는 최대크기. 단위는 바이트 기본값은 10240바이트(10kb)
		fileItemFactory.setSizeThreshold(LIMIT_SIZE_BYTES);
		ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
		
		//검색~!
        
		try {
			List<FileItem> items = fileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) { // 텍스트 
					System.out.printf("파라미터 명 : %s, 파라미터 값 :  %s \n", item.getFieldName(), item.getString(CHARSET));
					if(item.getFieldName().equals("id")) {
						id = item.getString(CHARSET); // input id
					}
					if(item.getFieldName().equals("content")) {
						content = item.getString(CHARSET); // input id
					}
					if(item.getFieldName().equals("title")) {
						title = item.getString(CHARSET); // input id
					}
				} else { // 파일 
					System.out.printf("파라미터 명 : %s, 파일 명 : %s,  파일 크기 : %s bytes \n", item.getFieldName(),
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

			//out.println("<h1>" + filename + " 파일 업로드 완료</h1>");

		} catch (Exception e) {
			// 파일 업로드 처리 중 오류가 발생하는 경우
			e.printStackTrace();
			//out.println("<h1>파일 업로드 중 오류가  발생하였습니다.</h1>");
		}
		
		
	    cltohdao dao = new cltohdao();
		dao.write(id,title,content,filename);
		
		
	}

}
