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
	// 캐릭터셋
	private static final String CHARSET = "EUC-KR";
	// 파일 저장 위치
	
	private String ATTACHES_DIR = "C:\\Users\\PCG96\\git\\junggo\\asdasdasd\\WebContent\\image";
	private static final int LIMIT_SIZE_BYTES = 1024 * 100;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id ="";
			
		String title ="";
			
		String content ="";
			
	    String filename ="";
			

		
		// 파일 경로
		File attachesDir = new File(ATTACHES_DIR);
		//ATTACHES_DIR 경로에 해당되는 파일의 File 객체를 생성한다. 


		// 파일 저장 담당 객체
		// 업로드 파일의 크기가 지정한 크기를 넘기 전까지는 업로드 한 파일 데이터를 메모리에 저장하고
		// 지정한 크기를 넘길 경우 임시 디렉터리에 파일로 저장
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		// 파일 저장 담당 객체
		// 업로드 파일의 크기가 지정한 크기를 넘기 전까지는 업로드 한 파일 데이터를 메모리에 저장하고
		// 지정한 크기를 넘길 경우 임시 디렉터리에 파일로 저장
		
		fileItemFactory.setRepository(attachesDir);
		// 메모리 저장 최대 크기를 넘길 경우 파일을 생성할 디렉터리를 지정. 지정하지 않을 경우 시스템의 기본 임시 디렉터리를 사용
		
		fileItemFactory.setSizeThreshold(LIMIT_SIZE_BYTES);
		// 메모리에 저장할 수 잇는 최대크기. 단위는 바이트 기본값은 1024바이트(10kb)
		
		ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
		//업로드 요청을 처리하는 ServletFileUpload생성
		
		try {
			List<FileItem> items = fileUpload.parseRequest(request);
			//업로드 요청 파싱해서 FileItem 목록 구함
			for (FileItem item : items) {
				if (item.isFormField()) { // 일반폼 데이터 (텍스트) 
					System.out.printf("파라미터 명 : %s, 파라미터 값 : %s \n", item.getFieldName(), item.getString(CHARSET));
					if(item.getFieldName().equals("id")) { //파라미터명 과 현재 아이디 비교
						id = item.getString(CHARSET); // 기본 캐릭터 셋을 이용해 파라미터 값 구해 id에 담는다.
					}
					if(item.getFieldName().equals("content")) {
						content = item.getString(CHARSET); // input id
					}
					if(item.getFieldName().equals("title")) {
						title = item.getString(CHARSET); // input id
					}
				} else { // 파일 인경우
					System.out.printf("파라미터 명 : %s, 파일 명 : %s,  파일 크기 : %s bytes \n", item.getFieldName(),
							item.getName(), item.getSize());
					filename = item.getName();//파일명 얻어오기
					if (item.getSize() > 0) {//파일의 크기 0 위
						String separator = File.separator;
						int index = item.getName().lastIndexOf(separator);
						filename = item.getName().substring(index + 1);
						File uploadFile = new File(ATTACHES_DIR +"\\" +filename);
						//저장할 경로
						
					    System.out.println("separator = > " + separator);
					    System.out.println("index = > " + index);
					
						System.out.println("uploadFile = > " + ATTACHES_DIR + separator +filename);
						item.write(uploadFile);
						//업로드 한 파일을 file이 나타내는 파일로 저장한다. 
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
