<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

requestTest.jsp 입니다.<br>

<%
//	out.println("일반 변수 : " + var + "<br>");		// var라는 일반 변수를 선언하지 않았으므로 에러가 발생된다.
	out.println("areaTest.jsp 파일의 pageContext 영역 변수 : " + pageContext.getAttribute("pageContextVar") + "<br>");
	out.println("areaTest.jsp 파일의 request 영역 변수 : " + request.getAttribute("requestVar") + "<br>");
	out.println("areaTest.jsp 파일의 session 영역 변수 : " + session.getAttribute("sessionVar") + "<br>");
	out.println("areaTest.jsp 파일의 application 영역 변수 : " + application.getAttribute("applicationVar") + "<br>");
%>

<%--
	EL(Expression Language, 표현 언어) 내장 객체 => jsp의 표현식(<%= ~ %>)을 대신해서 간단한 출력에 사용된다.
	EL 사용방법 => ${변수이름} 또는 ${객체이름.변수이름} => getter 메소드를 사용한 것과 같은 효과를 낸다.
	jsp를 사용해서 영역 변수의 내용을 출력할 때 영역 변수에 저장된 데이터가 없으면 null을 출력하지만 EL을 사용하면 아무것도 출력하지 않는다.
	
	영역 객체 => 영역이름Scope
--%>

<hr>

areaTest.jsp 파일의 pageContext 영역 변수(jsp 표현식 사용) : <%=pageContext.getAttribute("pageContextVar")%><br>
areaTest.jsp 파일의 pageContext 영역 변수(EL 사용) : ${pageContextScope.pageContextVar}<br>
areaTest.jsp 파일의 request 영역 변수(EL 사용) : ${requestScope.requestVar}<br>
areaTest.jsp 파일의 session 영역 변수(EL 사용) : ${sessionScope.sessionVar}<br>
areaTest.jsp 파일의 application 영역 변수(EL 사용) : ${applicationScope.applicationVar}<br>

</body>
</html>


















