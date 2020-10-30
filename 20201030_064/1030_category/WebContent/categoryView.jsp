<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 보기</title>

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
	
	$(document).ready(function() {
		
	});

</script>

</head>
<body>

<h1>Category Project</h1>

<form action="insert.jsp" method="post" onsubmit="return formCheck(this)">
	<input type="text" name="category"/>
	<input type="submit" value="메인 카테고리 만들기"/>
</form>

<hr size="3" color="red"/>

</body>
</html>










