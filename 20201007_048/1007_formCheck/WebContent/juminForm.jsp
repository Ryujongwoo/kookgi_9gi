<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="formCheck.js"></script>

</head>

<!-- onload() 이벤트는 현재 페이지가 브라우저에 표시되고 난 후 자동으로 실행된다. -->

<body onload="document.juminForm.jumin1.focus()">

<!--
	onsubmit 이벤트는 form의 submit 버튼이 클릭되면 실행되는 이벤트이다.
	onsubmit 이벤트에서 함수를 실행해서 form에 입력된 데이터가 정상적인 데이터인가 유효성을 검사해서 검사 결과가 정상이면 true, 오류가 발생되면
	false를 리턴하게 만든다.
	onsubmit="return javascript함수(this)" 형태로 코딩하며 javascript 함수의 실행 결과 return 값이 true면 action 속성에서 지정한 페이지로
	넘겨주고 return 값이 false면 현재 페이지에 그대로 머물러 있는다.
-->

<form action="juminFormOK.jsp" method="post" name="juminForm" onsubmit="return formCheck(this)">

	<!--
		onkeydown => 키보드를 누르는 순간 실행되는 이벤트 => 누른 키보드에 해당되는 문자가 입력되기 전에 실행된다.
		onkeypress => 키보드를 누르고있을 때 실행되는 이벤트
		onkeyup => 키보드에서 손가락이 떨어질 때 실행되는 이벤트 => 누른 키보드에 해당되는 문자가 입력된 다음에 실행된다.
	-->

	<input type="text" name="jumin1" maxlength="6" onkeyup="moveNext(this, 6, document.juminForm.jumin2)">
	-
	<input type="text" name="jumin2" maxlength="7" onkeyup="moveNext(this, 7, document.juminForm.sendBtn)">
	<input type="submit" value="검사하기" name="sendBtn">

</form>

</body>
</html>








