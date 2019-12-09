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
	
	//파일 저장 위치
	private String ATTACHES_DIR = "C:\\Users\\PCG96\\git\\junggo\\asdasdasd\\WebContent\\image";
	private static final int LIMIT_SIZE_BYTES = 1024 * 20;



	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
	    int sqnumber= 0;
		String id ="";
		String title ="";
	    String content ="";
		String filename ="";
			

		
		
		File attachesDir = new File(ATTACHES_DIR);
		
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		
		fileItemFactory.setRepository(attachesDir);
		
		fileItemFactory.setSizeThreshold(LIMIT_SIZE_BYTES);
		ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
		
	
        
		try {
			List<FileItem> items = fileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) { // 텍스트가 존재하면
					System.out.printf("파라미터 명 : %s, 파라미터 값 :  %s \n", item.getFieldName(), item.getString(CHARSET));
					
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
				} else { // 파일 
					System.out.printf("파라미터 명 : %s, 파일 명 : %s,  파일 크기 : %s bytes\n", item.getFieldName(),
							item.getName(), item.getSize());
					filename = item.getName();
					if (item.getSize() > 0) {
						String separator = File.separator;
						int index = item.getName().lastIndexOf(separator);
						filename = item.getName().substring(index + 1);
						File uploadFile = new File(ATTACHES_DIR + "\\" + filename);
						item.write(uploadFile);
						
					}
				}
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		cltohdao dao = new cltohdao();
		dao.clothmodify(sqnumber,id,title,content,filename);
	    
}



		
}
		
		
		
		
	


