<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//	쿠키를 읽어올 때는 여러개를 한꺼번에 읽어오기 때문에 배열로 받는다.
	Cookie[] cookies = request.getCookies();
//	out.println(cookies + "<br>");

	for (Cookie cookie : cookies) {
//		getName() : 쿠키 이름을 얻어온다.
//		out.println(cookie.getName() + "<br>");
//		getValue() : 쿠키에 저장된 데이터를 얻어온다.
//		내용이 한글인 쿠키를 저장할 때는 에러가 발생되기 때문에 반드시 인코딩 과정을 거쳐 저장해야 하지만 읽어올 때는 그냥 읽어와도 에러가
//		발생되지 안는다. => %EC%95%84%EB%A1%B1%EC%9D%B4와 같이 인코딩된 유니코드 자체를 가져오기 때문에 읽을 수 없다.
//		out.println(cookie.getValue() + "<br>");
//		저장된 내용이 한글인 쿠키를 읽어올 때 디코딩 과정을 거쳐야 한글을 읽을 수 있다.
//		out.println(URLDecoder.decode(cookie.getValue()) + "<br>");

		out.println(cookie.getName() + " : " + URLDecoder.decode(cookie.getValue()) + "<br>");
	}
%>

</body>
</html>





