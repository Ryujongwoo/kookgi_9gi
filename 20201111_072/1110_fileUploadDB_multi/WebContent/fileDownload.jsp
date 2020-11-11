<%@page import="com.koreait.fileupload.FileDAO"%>
<%@page import="com.koreait.fileupload.FileVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다운로드 페이지</title>
</head>
<body>

<%--
<%
//	다운로드 횟수 코딩 전
//	String uploadDirectory = application.getRealPath("/upload/");
//	보안성 향상을 위해 upload 폴더를 WebContent 폴더 바깥쪽에 만든다.
	String uploadDirectory = "D:/jsp/upload/";

//	list() : 지정된 디렉토리(폴더)에 저장된 파일 이름 목록을 얻어온다.
	String[] files = new File(uploadDirectory).list();
	for (String file : files) {
//		out.println(file + "<br/>");
%>
		<a href="<%=request.getContextPath()%>/downloadAction?file=<%=URLEncoder.encode(file, "UTF-8")%>"><%=file%></a><br/>
<%
	}
%>
--%>

<%
//	다운로드 횟수 코딩 후
//	테이블에 저장된 업로드된 전체 파일 정보를 얻어온다.
	ArrayList<FileVO> fileList = new FileDAO().getList();
	for (FileVO vo : fileList) {
%>

		<a href="<%=request.getContextPath()%>/downloadAction?file=<%=URLEncoder.encode(vo.getFileRealName(), "UTF-8")%>">
			<%=vo.getFileName()%>(다운로드 횟수 : <%=vo.getDownloadCount()%>)
		</a><br/>

<%
	}
%>

<a href="index.jsp">돌아가기</a>

</body>
</html>













