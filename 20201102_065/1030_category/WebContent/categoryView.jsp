<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 보기</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

	
	function formCheck(obj) {
		if (!obj.category.value || obj.category.value.trim().length == 0) {
			alert('카테고리는 반드시 입력해야 합니다.');
			obj.category.value = '';
			obj.category.focus();
			return false;
		}
		return true;
	}
	
	
//	$(document).ready(function() {
	$(function() {
		
//		메인 카테고리에 아무것도 입력되지 않았는가 검사한다. => 메인 카테고리 입력은 1개만 있기 때문에 id를 지정해서 처리한다.
//		$('#form').submit() : form이라는 id가 지정된 폼에서 submit 버튼이 클릭되면 submit() 함수의 인수로 지정된 익명 함수가 실행된다.
//		이 때, 익명 함수의 인수(event)로 실행되는 이벤트가 넘어온다.
		$('#form').submit(function(event) {
//			$.trim() : 인수로 지정된 문자열 앞, 뒤의 불필요한 빈 칸을 제거한다.
//			$('#category').val() : category라는 id가 지정된 객체에 입력된 데이터를 얻어온다.
//			alert($('#category').val());
			var category = $.trim($('#category').val()).length;		// 메인 카테고리에 입력된 글자수
			if (category == 0) {
				alert('메인 카테고리는 반드시 입력해야 합니다.');
//				preventDefault() : event로 넘어온 기본 이벤트의 실행을 중지시킨다.
				event.preventDefault();
				$('#form')[0].reset();		// form이라는 id가 지정된 폼에서 reset 기능을 실행한다. => [0]만 사용가능 하다.
				$('#category').focus();		// category라는 id가 지정된 객체로 포커스를 이동시킨다.
			}
		});
		
	});

</script>

</head>
<body>

<h1>Category Project</h1>

<!--
javascript 함수로 메인 카테고리 폼 체크
<form action="insert.jsp" method="post" onsubmit="return formCheck(this)">
-->

<!-- jquery로 메인 카테고리 폼 체크 -->
<form id="form" action="insert.jsp" method="post">
	<input id="category" type="text" name="category"/>
	<input type="submit" value="메인 카테고리 만들기"/>
</form>

<hr size="3" color="red"/>

<!-- 여기부터 카테고리 개수 만큼 반복하며 카테고리 목록을 출력한다. -->
<c:forEach var="vo" items="${categoryList.list}">

	<!-- javascript 함수로 서브 카테고리 폼 체크 -->
	<form action="reply.jsp" method="post" onsubmit="return formCheck(this)">
	
		<!-- idx, ref, lev, seq를 표시하는 텍스트 상자는 테스트가 완료되면 모두 hidden으로 처리한다. -->
		<input type="text" name="idx" value="${vo.idx}" size="1"/>
		<input type="text" name="ref" value="${vo.ref}" size="1"/>
		<input type="text" name="lev" value="${vo.lev}" size="1"/>
		<input type="text" name="seq" value="${vo.seq}" size="1"/>
	
		<!-- 카테고리 레벨(lev)에 따른 들여쓰기를 한다. -->
		<c:if test="${vo.lev > 0}">
			<c:forEach var="i" begin="1" end="${vo.lev}" step="1">
				&nbsp;&nbsp;&nbsp;
			</c:forEach>
			<img src="./images/re.png" width="25" height="10"/>
		</c:if>
		${vo.category}
	
		<input type="text" name="category"/>
		<input type="submit" value="서브 카테고리 만들기"/>
		<input type="button" value="삭제" onclick="location.href='delete.jsp?idx=${vo.idx}'"/>
	
	</form>

</c:forEach>

</body>
</html>










