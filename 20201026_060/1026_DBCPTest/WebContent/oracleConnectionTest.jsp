<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--
	오라클에 접속하기
	SQL> connect system 엔터
	※ 실제로 비밀번호를 입력할 때는 문자가 화면에 표시되지 않는다.
	Enter Password : 0000 엔터

	오라클 계정 만들기
	SQL> create user 계정이름 identified by 비밀번호; 엔터
	User created.
	
	계정에 권한 설정하기
	※ connect는 접속 권한, resource은 테이블을 만들고 입력, 삭제, 수정, 검색을 하는 개발자가 사용하는 권한을 말한다.
	SQL> grant connect, resource to 계정이름; 엔터
	Grant succeeded.
-->

<%
	Connection conn = null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(url, "koreait", "0000");
		
		out.println("연결 성공 : " + conn + "<br/>");
		
	} catch (ClassNotFoundException e) {
		out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
	} catch (SQLException e) {
		out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
	}
%>

</body>
</html>









