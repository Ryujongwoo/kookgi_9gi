<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출첵 게시판</title>
</head>
<body>

<!-- 입력 화면 설계 -->
<form action="memoInsert.jsp" method="post">
	<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
	
		<tr>
			<th colspan="3">아주 많이 허접해 보이는 출첵 게시판 Ver 0.01</th>
		</tr>
		<tr>
			<td width="100" align="center">이름</td>
			<td width="100" align="center">비밀번호</td>
			<td width="800" align="center">메모</td>
		</tr>
		<tr>
			<td align="center">
				<input type="text" name="name" size="7"/>
			</td>
			<td align="center">
				<input type="password" name="password" size="7"/>
			</td>
			<td align="center">
				<input type="text" name="memo" size="98"/>
				<input type="submit" value="저장"/>
			</td>
		</tr>
	
	</table>
</form>
<!-- 입력 화면 설계 끝 -->

<hr size="3" color="red"/>

</body>
</html>









