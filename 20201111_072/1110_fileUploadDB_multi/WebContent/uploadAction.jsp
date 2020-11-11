<%@page import="java.util.Enumeration"%>
<%@page import="com.koreait.fileupload.FileDAO"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");

//	String uploadDirectory = application.getRealPath("/upload/");
//	보안성 향상을 위해 upload 폴더를 WebContent 폴더 바깥쪽에 만든다.
	String uploadDirectory = "D:/jsp/upload/";
	MultipartRequest multipartRequest = new MultipartRequest(
		request,
		uploadDirectory,
		5 * 1024 * 1024,
		"UTF-8",
		new DefaultFileRenamePolicy()
	);
	
	/*
//	단일 파일 업로드
//	getOriginalFileName() : 사용자가 업로드 한 파일의 이름을 얻어온다.
	String fileName = multipartRequest.getOriginalFileName("file");
//	out.println("fileName : " + fileName + "<br/>");
//	getFilesystemName() : 업로드 되서 실제 디스크에 저장된 파일 이름을 얻어온다.
	String fileRealName = multipartRequest.getFilesystemName("file");
//	out.println("fileRealName : " + fileRealName + "<br/>");

//	업로드 제한
//	startsWith() : 인수로 지정된 문자열로 문자열이 시작하면 true, 그렇치 않으면 false를 리턴한다.
//	endsWith()   : 인수로 지정된 문자열로 문자열이 끝나면 true, 그렇치 않으면 false를 리턴한다.
//	jar 파일만 업로드 할 수 있도록 한다. => 지정한 확장명을 가지지 않는 파일은 업로드 되자 마자 제거한다.
	if (!fileName.endsWith(".jar") && !fileName.endsWith(".zip")) {
		out.println("파일명 : " + fileName + "<br/>");
		out.println("<script>");
		out.println("alert('" + fileName + "은 업로드 할 수 없는 형식의 파일입니다.\\njar, zip 파일만 업로드가 가능합니다.')");
		out.println("</script>");
		
//		업로드된 파일을 삭제한다.
		File file = new File(uploadDirectory + fileName);
//		delete() : 파일을 삭제한다.
		file.delete();
	} else {
		out.println("업로드 한 파일명 : " + fileName + "<br/>");
		out.println("실제 업로드된 파일명 : " + fileRealName + "<br/>");
		
//		업로드한 파일명과 실제 업로드된 파일명을 테이블에 저장한다.
		new FileDAO().upload(fileName, fileRealName);
	}
	*/
	
//	다중 파일 업로드
	Enumeration fileNames = multipartRequest.getFileNames();
//	hasMoreElements() : Enumeration 인터페이스 객체에 다음에 읽어들일 데이터가 있으면 true, 없으면 false를 리턴시킨다.
	while (fileNames.hasMoreElements()) {
		
//		nextElement() : Enumeration 인터페이스 객체에 저장된 다음 데이터를 얻어온다.
		String parameter = (String) fileNames.nextElement();
//		out.println(parameter);
//		getOriginalFileName() : 업로드 하는 파일 이름을 얻어온다.
//		out.println(multipartRequest.getOriginalFileName(parameter) + ", ");
		String fileName = multipartRequest.getOriginalFileName(parameter);
//		getFilesystemName() : 디스크에 실제로 저장된 파일 이름을 얻어온다.
//		out.println(multipartRequest.getFilesystemName(parameter) + "<br/>");
		String fileRealName = multipartRequest.getFilesystemName(parameter);
		
//		파일 이름이 넘어오지 않았으면 다음 파일을 처리한다. => 남은 반복문을 실행하지 않고 다시 반복시킨다. => continue
		if (fileName == null) {
			continue;
		}
		
		if (!fileName.endsWith(".jar") && !fileName.endsWith(".zip")) {
			out.println("파일명 : " + fileName + "<br/>");
			out.println("<script>");
			out.println("alert('" + fileName + "은 업로드 할 수 없는 형식의 파일입니다.\\njar, zip 파일만 업로드가 가능합니다.')");
			out.println("</script>");
			File file = new File(uploadDirectory + fileName);
			file.delete();
		} else {
			out.println("업로드 한 파일명 : " + fileName + "<br/>");
			out.println("실제 업로드된 파일명 : " + fileRealName + "<br/>");
			new FileDAO().upload(fileName, fileRealName);
		}
		
	}
%>

<a href="index.jsp">돌아가기</a>

</body>
</html>



















