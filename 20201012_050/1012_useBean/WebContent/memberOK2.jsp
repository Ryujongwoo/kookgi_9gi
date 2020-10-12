<%@page import="java.util.Date"%>
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
//	Date date = new Date();
//	out.println(date + "<br/>");
%>

<!-- useBean 액션 태그는 객체를 만들 때 사용한다. -->
<!--
	useBean 액션 태그의 id 속성에는 만들려는 객체의 이름을 쓴다.
	useBean 액션 태그의 class 속성에는 객체를 만들려고 하는 클래스 이름을 반드시 풀 패키지 이름과 같이 쓴다.
-->

<jsp:useBean id="date" class="java.util.Date"/>
${date}<br/>

<!-- MemberVO vo = new MemberVO();와 같은 기능이 실행된다. -->
<jsp:useBean id="vo" class="com.koreait.useBean.MemberVO">

	<!-- setProperty 액션 태그는 setter 메소드를 실행한다. => 클래스에 setter 메소드가 작성되어있어야 실행할 수 있다. -->
	<!--
		setProperty 액션 태그의 property 속성에는 setter 메소드를 실행할 멤버 변수 이름을 쓴다.
		setProperty 액션 태그의 name 속성에는 setter 메소드를 실행할 멤버 변수가 작성된 클래스의 객체 이름을 쓴다.
		setProperty 액션 태그를 사용하면 request.getParameter() 메소드로 넘어오는 데이터를 받지 않아도 jsp가 자동으로 받아준다.
		String id = request.getParameter("id");
		vo.setId(id);
	-->
	<!--
		String id = request.getParameter("id");
		vo.setId(id);
		위의 2줄과 같은 기능이 실행된다. Integer.parseInt(), Boolean.parseBoolean()를 사용하지 않아도 자동으로 데이터가 변환되서 저장된다.
	-->
	<!--
	<jsp:setProperty property="id" name="vo"/>
	<jsp:setProperty property="name" name="vo"/>
	<jsp:setProperty property="password" name="vo"/>
	<jsp:setProperty property="age" name="vo"/>
	<jsp:setProperty property="gender" name="vo"/>
	-->

	<!-- setProperty 액션 태그의 property 속성에 "*"을 입력하면 form의 name 속성에 입력한 이름과 같은 모든 멤버 변수의 setter가 실행된다. -->
	<jsp:setProperty property="*" name="vo"/>

</jsp:useBean>

<!-- useBean 액션 태그로 만든 객체에 저장할 데이터 중에서 form에 저장되서 넘어오지 않는 데이터는 별도로 받아서 넣어줘야 한다. -->

<%
	String ip = request.getRemoteAddr();
	vo.setIp(ip);
%>

${vo}<br/>

</body>
</html>


















