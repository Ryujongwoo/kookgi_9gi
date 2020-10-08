<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 양식</title>
</head>

<script type="text/javascript">

	function passwordCheck(obj) {
		
//		입력한 비밀번호가 8자 이상 12자 이하인가 검사한다.
		len = obj.password.value.trim().length;		// 비밀번호에 입력한 글자수
		if (len < 8 || len > 12) {
			alert("비밀번호는 8자 이상 12자 이하로 입력해야 합니다.");
			obj.password.value = "";
			obj.password.focus();
			return false;
		}
		
//		영문자, 숫자, 특수문자가 각각 1개 이상 입력되었나 검사한다.
		
		
//		입력한 두 개의 비밀번호가 같은가 검사한다.
		if (obj.password.value.trim() != obj.repassword.value.trim()) {
			alert("비밀번호가 일치하지 않습니다.");
			obj.password.value = "";
			obj.repassword.value = "";
			obj.password.focus();
			return false;
		}
		
		return true;
		
	}

</script>

<body>

<form action="memberOK.jsp" method="post" onsubmit="return passwordCheck(this)">
	<table width="500" align="center" border="1" cellpadding="5" cellspacing="0">
	
		<tr>
			<th colspan="2">회원 가입</th>
		</tr>
		
		<tr>
			<td width="150">id</td>
			<td width="350">
				<input type="text" name="id" placeholder="아이디를 입력하세요"/>
			</td>
		</tr>
		
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" placeholder="이름을 입력하세요"/>
			</td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" name="password" placeholder="비밀번호를 입력하세요"/>
			</td>
		</tr>
		
		<tr>
			<td>비밀번호 확인</td>
			<td>
				<input type="password" name="repassword" placeholder="비밀번호를 한 번 더 입력하세요"/>
			</td>
		</tr>
	
		<tr>
			<td>나이</td>
			<td>
				<input type="text" name="age" placeholder="나이를 입력하세요"/>
			</td>
		</tr>
	
		<tr>
			<td>성별</td>
			<td>
				<input type="radio" name="gender" value="true"/>남자
				<input type="radio" name="gender" value="false"/>여자
			</td>
		</tr>
	
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="회원가입"/>
				<input type="reset" value="다시쓰기"/>
			</td>
		</tr>
		
	</table>
</form>

</body>
</html>