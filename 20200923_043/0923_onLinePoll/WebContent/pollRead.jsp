<%@page import="com.koreait.onLinePoll.PollRead"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>
</head>
<body>

<!-- 투표 항목이 저장된 텍스트 파일의 데이터를 읽어서 웹 브라우저에 출력한다. -->
<%
//	D:\kookgi_9gi\JSP\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\0923_onLinePoll => 웹 서비스가 구현되는 실제 경로
//	이클립스는 웹 서비스가 구현되는 실제 경로에 프로젝트 이름으로 폴더를 생성한 후 웹 페이지를 실행한다.
//	getRealPath("/") : 웹 서비스가 실행되는 서버의 실제 경로를 얻어온다.
//	out.println(application.getRealPath("/"));	// "/"는 웹 서비스가 실행되는 web root(최상위 폴더)를 의미한다.
	String filepath = application.getRealPath("/") + "poll.txt";
//	out.println(filepath);

//	텍스트 파일의 데이터를 읽어오는 메소드를 실행해서 리턴되는 결과를 ArrayList에 저장한다.
	ArrayList<String> poll = PollRead.pollRead(filepath);
//	out.println(poll);
//	읽어들인 텍스트 파일의 데이터 전체를 출력한다.
//	for (String str : poll) {
//		out.println(str + "<br>");
//	}

//	투표 항목의 개수를 계산한다.
	int itemCount = (poll.size() - 1) / 2;
//	out.println(itemCount);
%>

<form action="pollWrite.jsp" method="post">

	<!-- cellpadding : 셀과 셀 내부의 입력된 데이터와의 간격을 지정한다. => 안여백 -->
	<!-- cellspacing : 셀과 셀 사이의 간격을 지정한다. -->
	<table width="500" align="center" border="1" cellpadding="5" cellspacing="0">
	
		<tr height="70">
			<th><%=poll.get(0)%></th>
		</tr>
	
		<!-- 투표 항목의 개수 만큼 반복하며 라디오 버튼과 투표 항목을 출력한다. -->
		<%
		for (int i = 1; i <= itemCount; i++) {
		%>
		
		<tr height="50">
			<td>
				<%--
				<%
				if (i == 3) {
				%>	
				<input type="radio" name="poll" value="<%=i%>" checked="checked"><%=poll.get(i)%>
				<%
				} else {
				%>
				<input type="radio" name="poll" value="<%=i%>"><%=poll.get(i)%>
				<%
				}
				%>
				--%>
				<input type="radio" name="poll" value="<%=i%>"><%=poll.get(i)%>
			</td>
		</tr>
		
		<%
		}
		%>
	
		<tr height="50">
			<td align="center">
				<input type="submit" value="투표하기">
				<input type="button" value="결과보기" onclick="location.href='pollResult.jsp'">
			</td>
		</tr>
	
	</table>
	
</form>

</body>
</html>















