package com.koreait.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downloadAction")
public class downloadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public downloadAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getParameter("file"));
		System.out.println("get 방식으로 요청될 때 자동으로 실행되는 메소드");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 방식으로 요청될 때 자동으로 실행되는 메소드");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getParameter("file"));
		System.out.println("actionDo() 메소드");
		
		request.setCharacterEncoding("UTF-8");
//		다운로드 할 파일의 이름을 받는다.
		String fileName = request.getParameter("file");
		
//		다운로드 할 파일이 저장된 실제 물리적 디렉토리 경로를 얻어온다.
//		String uploadDirectory = this.getServletContext().getRealPath("/upload/");
//		System.out.println(uploadDirectory);
//		다운로드 할 파일이 저장된 실제 물리적 디렉토리 경로와 다운로드할 파일 이름을 연결한다.
//		String uploadDirectory = this.getServletContext().getRealPath("/upload/") + fileName;
		
//		보안성 향상을 위해 upload 폴더를 WebContent 폴더 바깥쪽에 만든다.
		String uploadDirectory = "D:/jsp/upload/" + fileName;
		
//		System.out.println(uploadDirectory);
		
//		다운로드 할 파일 객체를 만든다.
		File file = new File(uploadDirectory);
		
//		MIME => Multipurpose Internet Mail Extensions의 약자로 파일 변환을 뜻한다.
//		getMimeType() : 인수로 지정돤 파일의 MIME 타입을 얻어온다.
		String mimeType = getServletContext().getMimeType(file.toString());
//		MIME 타입을 얻어오지 못했다면 파일을 전송하는 것을 사용자에게 알려주기 위해서 response 객체를 사용해 file 형태의 데이터를 전송한다는
//		것을 "application/octet-stream"을 사용해 알려준다.
		if (mimeType == null) {
			response.setContentType("application/octet-stream");
		}
		
//		접속한 브라우저에 따라 다운로드 할 파일의 헤더 정보를 브라우저에 따라 다르게 설정한다.
		String downloadName = null;
		if (request.getHeader("user-agent").indexOf("MSIE") == -1) {
//			인터텟 익스플로러를 제외한 나머지 브라우저
			downloadName = new String(fileName.getBytes("UTF-8"), "8859_1");
		} else {
//			인터텟 익스플로러
			downloadName = new String(fileName.getBytes("EUC-KR"), "8859_1");
		}
//		attachment 뒤의 filename은 반드시 큰따옴표를 사용해서 묶어줘야 한다. => \"를 사용한다.
		response.setHeader("Content-Disposition", "attachment;filename=\"" + downloadName + "\";");
		
//		파일 전송에 사용할 객체를 선언한다.
		FileInputStream fileInputStream = new FileInputStream(file);			// 디스크의 파일을 읽어들이는 객체
		ServletOutputStream servletOutputStream = response.getOutputStream();	// 다운로드를 실행한 브라우저로 전송하는 객체
		
//		파일을 1024 바이트(1KB) 단위로 전송한다.
		byte[] b = new byte[1024];
		int data = 0;
		
		while ((data = (fileInputStream.read(b, 0, b.length))) != -1) {			// 디스크에서 읽어들인 전송할 파일 데이터가 있는가?
			servletOutputStream.write(b, 0, data);
		}
		
//		다운로드가 완료되면 다운로드 횟수를 증가시킨다.
//		System.out.println(new FileDAO().hit(fileName));
		new FileDAO().hit(fileName);
		
//		flush() 메소드로 servletOutputStream 객체의 출력 버퍼에 남아있는 모든 데이터를 전송하고 전송에 사용한 객체를 닫는다.
		servletOutputStream.flush();
		servletOutputStream.close();
		fileInputStream.close();
	}

}










