<%@page import="java.text.DecimalFormat"%>
<%@page import="com.koreait.onLinePoll.PollRead"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 일정 시간이 경과되면 특정 웹 사이트로 이동하기 -->
<!-- <meta http-equiv="refresh" content="5; url='https://www.naver.com/'"> -->
<!-- 일정 시간이 경과되면 현재 페이지를 새로고침한다. -->
<meta http-equiv="refresh" content="1; url=?">

<title>투표 결과 보기</title>
</head>
<body>

<!-- 텍스트 파일에 저장된 투표 결과를 읽어와 표시한다. -->
<%
//	투표 결과를 웹 브라우저에 출력하기 위해서 텍스트 파일을 읽어오고 투표 항목의 개수를 계산한다.
	String filepath = application.getRealPath("/") + "poll.txt";
	ArrayList<String> poll = PollRead.pollRead(filepath);
	int itemCount = (poll.size() - 1) / 2;

//	득표율을 계산하기 위해서 전체 득표수를 계산한다.
	int sum = 0;
	for (int i = itemCount + 1; i < poll.size(); i++) {
		sum += Integer.parseInt(poll.get(i));
	}
//	out.println(sum);

//	숫자 데이터 서식을 지정한다.
	DecimalFormat df1 = new DecimalFormat("#,##0표");
	DecimalFormat df2 = new DecimalFormat("0.0%");
%>

	<table width="500" align="center" border="1" cellpadding="5" cellspacing="0">

		<tr height="70">
			<th colspan="2"><%=poll.get(0)%></th>
		</tr>
		
		<tr height="50">
			<td colspan="2" align="right">전체 투표수 : <%=sum%></td>
		</tr>

		<!-- 투표 항목의 개수 만큼 반복하며 투표 항목, 득표수, 득표율, 막대 그래프를 출력한다. -->
		<%
		for (int i = 1; i <= itemCount; i++) {
//			ArrayList에 저장된 득표수를 얻어오고 득표율을 계산한다.
			int pyo = Integer.parseInt(poll.get(i + itemCount));
			double per = (double) pyo / sum;
		%>
		
		<tr height="50">
			<td width="150">
				<%=poll.get(i)%>(<%=df1.format(pyo)%>)
				<%-- <%=poll.get(i)%>(<%=df2.format(per)%>) --%>
			</td>
			<td width="350">
			
				<!-- <hr> 태그로 막대 그래프 효과를 낸다. -->
				<hr color="tomato" size="20" width="<%=350 * per%>" align="left">
			
			</td>
		</tr>
		
		<%
		}
		%>

		<tr height="50">
			<td align="center" colspan="2">
				<input type="button" value="투표하기로 가기" onclick="location.href='pollRead.jsp'">
			</td>
		</tr>

	</table>

</body>
</html>















