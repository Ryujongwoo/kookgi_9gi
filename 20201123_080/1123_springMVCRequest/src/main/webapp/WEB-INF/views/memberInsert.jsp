<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

memberInsert.jsp 입니다.<br/>

${memberVO}<br/>
이름 : ${memberVO.name}<br/>
ID : ${memberVO.id}<br/>
비밀번호 : ${memberVO.password}<br/>
이메일 : ${memberVO.email}<br/>
=======================================================<br/>

${vo}<br/>
이름 : ${vo.name}<br/>
ID : ${vo.id}<br/>
비밀번호 : ${vo.password}<br/>
이메일 : ${vo.email}<br/>

</body>
</html>