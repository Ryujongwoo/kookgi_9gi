<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 쓰기</title>
</head>
<body>

<form action="insertOK.jsp" method="post">
	<table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th colspan="2">방명록 쓰기</th>
		</tr>
		<tr>
			<td width="100">이름</td>
			<td width="500"><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td>메모</td>
			<td><textarea rows="10" cols="65" name="memo" style="resize: none;"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="글남기기"/>
				<input type="reset" value="다시쓰기"/>
				<input type="button" value="돌아가기" onclick="history.back()"/>
			</td>
		</tr>
	</table>
</form>

</body>
</html>