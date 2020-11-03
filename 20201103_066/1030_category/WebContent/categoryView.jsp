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

	/*
	function formCheck(obj) {
		if (!obj.category.value || obj.category.value.trim().length == 0) {
			alert('카테고리는 반드시 입력해야 합니다.');
			obj.category.value = '';
			obj.category.focus();
			return false;
		}
		return true;
	}
	*/
	
//	삭제 버튼이 클릭되면 delete.jsp로 form에 입력된 데이터를 전송하는 함수
	function mySubmitDelete(obj) {
//		alert(obj);
		obj.action = 'delete.jsp';		// 인수로 넘어온 form의 action 페이지를 변경(지정)한다.
		obj.submit();					// action 페이지를 호출하고 form의 데이터를 전송한다.
	}
	
//	복구 버튼이 클릭되면 deleteRestore.jsp로 form에 입력된 데이터를 전송하는 함수
	function mySubmitRestore(obj) {
//		alert(obj);
		obj.action = 'deleteRestore.jsp';
		obj.submit();
	}
	
//	신고 버튼이 클릭되면 deleteReport.jsp로 form에 입력된 데이터를 전송하는 함수
	function mySubmitDeleteReport(obj) {
//		alert(obj);
		obj.action = 'deleteReport.jsp';
		obj.submit();
	}
	
//	수정 버튼이 클릭되면 update.jsp로 form에 입력된 데이터를 전송하는 함수
	function mySubmitUpdate(obj) {
//		alert(obj);
		if (!obj.category.value || obj.category.value.trim().length == 0) {
			alert('수정할 카테고리를 입력하세요')
			obj.category.value = '';
			obj.category.focus();
		} else {
			obj.action = 'update.jsp';
			obj.submit();
		}
	}
	
//	===============================================================================================================================
	
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
		
//		서브 카테고리에 아무것도 입력되지 않았는가 검사한다. => 서브 카테고리 입력은 여러개가 있기 때문에 class를 지정해서 처리한다.

//		서브 카테고리를 입력하는 폼의 개수 만큼 반복하며 모든 서브 카테고리 form에 이름이 다른 class 속성을 지정한다.
//		$('.sub_form').each() : sub_form이란 class 속성이 지정된 객체의 개수 만큼 인수로 지정된 함수를 반복해서 실행한다.
//		index : sub_form이란 class가 지정된 객체의 일련번호(index)가 저장된다.
//		item : sub_form이란 class가 지정된 index 번째 객체가 저장된다.
		$('.sub_form').each(function(index, item) {
//			console.log(index);
//			$(item).addClass() : 반복문을 통해서 반복되는 객체(서브 카테고리 폼)에 class 속성을 추가한다.
			$(item).addClass('sub_form' + index);
		});
		
//		서브 카테고리를 입력하는 텍스트 상자의 개수 만큼 반복하며 모든 서브 카테고리를 입력하는 text 상자에 이름이 다른 class 속성을 지정한다.
		$('.sub_category').each(function(index, item) {
			$(item).addClass('sub_category' + index);
		});
		
		$('.sub_form').each(function(index, item) {
			$('.sub_form' + index).submit(function(event) {
				var sub_category = $.trim($('.sub_category' + index).val()).length;
				if (sub_category == 0) {
					alert('서브 카테고리는 반드시 입력해야 합니다.');
					event.preventDefault();
					$('.sub_form' + index)[0].reset();
					$('.sub_category' + index).focus();
				}
			});
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

	<!-- 서브 카테고리를 입력하는 모든 폼에 다른 이름이 지정되야 식별이 가능하므로 폼 이름을 만든다. -->
	<c:set var="formName" value="form${vo.idx}"/>

	<!--
	javascript 함수로 서브 카테고리 폼 체크
	<form action="reply.jsp" method="post" onsubmit="return formCheck(this)" name="${formName}">
	-->
	
	<!-- jquery로 서브 카테고리 폼 체크 -->
	<form class="sub_form" action="reply.jsp" method="post" name="${formName}">
	
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
		
		<c:if test="${fn:trim(vo.deleteCheck) == 'yes'}">
			삭제된 카테고리 입니다.
		</c:if>
		
		<c:if test="${fn:trim(vo.deleteCheck) != 'yes'}">
		
			<c:if test="${vo.deleteReport > 10}">
				신고 만땅 먹은 카테고리 입니다.
			</c:if>
			
			<c:if test="${vo.deleteReport <= 10}">
				${vo.category}(신고 횟수 : ${vo.deleteReport}번)
			</c:if>
			
		</c:if>
	
		<input class="sub_category" type="text" name="category"/>
		<input type="submit" value="서브 카테고리 만들기"/>
		<%-- <input type="button" value="삭제" onclick="location.href='delete.jsp?idx=${vo.idx}'"/> --%>
		<input type="button" value="삭제" onclick="mySubmitDelete(${formName})"/>
		<input type="button" value="복구" onclick="mySubmitRestore(${formName})"/>
		<input type="button" value="신고" onclick="mySubmitDeleteReport(${formName})"/>
		<input type="button" value="수정" onclick="mySubmitUpdate(${formName})"/>
	
	</form>

</c:forEach>

</body>
</html>










