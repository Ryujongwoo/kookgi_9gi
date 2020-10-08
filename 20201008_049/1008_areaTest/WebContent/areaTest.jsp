<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//	jsp에서 사용하는 시스템 영역과 유효범위
//	pageContext => 현재 보고있는 페이지
//	request => 현재 보고있는 페이지의 다음 페이지
//	session => 브라우저가 실행되면 생성되고 브라우저가 종료되면 소멸되는 영역
//	application => 서버가 실행되면 생성되고 서버가 종료되면 소멸되는 영역

	String var = "일반 변수";
//	영역 변수가 저장되는 기억 공간은 영역 변수 이름을 key로 하고 영역 변수에 저장되는 데이터를 value로 하는 Map<String, Object> 형태의 구조로
//	value의 자료형이 Object인 이유는 개발자가 어떤 타입의 데이터를 영역 변수에 저장할지 모르기 때문이다.
//	영역이름.setAttribute("영역 변수 이름", 영역 변수에 저장할 데이터)
	pageContext.setAttribute("pageContextVar", "areaTest.jsp 파일의 pageContext 영역 변수");
	request.setAttribute("requestVar", "areaTest.jsp 파일의 request 영역 변수");
	session.setAttribute("sessionVar", "areaTest.jsp 파일의 session 영역 변수");
	application.setAttribute("applicationVar", "areaTest.jsp 파일의 application 영역 변수");

	out.println("일반 변수 : " + var + "<br>");
//	영역이름.getAttribute("영역 변수 이름")
	out.println("areaTest.jsp 파일의 pageContext 영역 변수 : " + pageContext.getAttribute("pageContextVar") + "<br>");
//	영역 변수가 저장되는 기억 공간은 Map<String, Object> 형태이므로 getAttribute() 메소드로 영역 변수에 저장된 데이터를 얻어오면 Object 타입으로
//	얻어오기 때문에 반드시 영역 변수에 저장된 데이터를 형변환시켜서 일반 변수에 저장시켜야 한다.
	String pageContextVar = (String) pageContext.getAttribute("pageContextVar");
	out.println("areaTest.jsp 파일의 pageContext 영역 변수 : " + pageContextVar + "<br>");
	out.println("areaTest.jsp 파일의 request 영역 변수 : " + request.getAttribute("requestVar") + "<br>");
	out.println("areaTest.jsp 파일의 session 영역 변수 : " + session.getAttribute("sessionVar") + "<br>");
	out.println("areaTest.jsp 파일의 application 영역 변수 : " + application.getAttribute("applicationVar") + "<br>");
	
//	sendRedirect() 메소드는 인수로 지정된 페이지로 request 영역의 데이터를 가지지 않고 넘어간다.
//	sendRedirect() 메소드는 url 창에 표시되는 페이지의 이름이 sendRedirect() 메소드의 인수로 지정한 페이지 이름으로 변경된다.
	response.sendRedirect("requestTest.jsp");

//	forward() 메소드는 인수로 지정된 페이지로 request 영역의 데이터를 가지고 넘어간다.
//	forward() 메소드는 url 창에 표시되는 페이지의 이름이 forward() 메소드의 인수로 지정한 페이지 이름으로 변경되지 않고 forward() 메소드가 실행된
//	페이지 이름이 그대로 유지된다.
//	pageContext.forward("requestTest.jsp");
%>

</body>
</html>





















