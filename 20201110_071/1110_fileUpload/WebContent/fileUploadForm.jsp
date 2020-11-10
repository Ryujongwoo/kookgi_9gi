<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 폼</title>
</head>
<body>

<!-- 파일을 업로드 하는 폼은 enctype 속성을 반드시 multipart/form-data로 지정해야 한다. -->
<form action="fileUploadOK.jsp" method="post" enctype="multipart/form-data">

	<input type="file" name="filename"/><br/>
	<input type="submit" value="파일전송"/>

</form>

</body>
</html>