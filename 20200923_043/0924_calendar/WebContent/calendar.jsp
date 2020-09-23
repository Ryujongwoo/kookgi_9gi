<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.koreait.myCalendar.MyCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만년달력</title>

<style type="text/css">

	tr {
		height: 80px;
	}
	th {
		font-size: 30pt;
		font-weight: bold;
		color: tomato;
		font-family: D2Coding;
	}
	td.sunday {
		font-size: 20pt;
		font-weight: bold;
		width: 100px;
		text-align: center;
		color: red;
	}
	td.saturday {
		font-size: 20pt;
		font-weight: bold;
		width: 100px;
		text-align: center;
		color: blue;
	}
	td.etcday {
		font-size: 20pt;
		font-weight: bold;
		width: 100px;
		text-align: center;
		color: black;
	}

</style>

</head>
<body>

<%
//	out.println(MyCalendar.isLeapYear(2020) + "<br>");
//	out.println(MyCalendar.lastDay(2020, 9) + "<br>");
//	out.println(MyCalendar.totalDay(2020, 9, 23) + "<br>");
//	out.println(MyCalendar.weekDay(2020, 9, 23) + "<br>");

//	컴퓨터 시스템의 년, 월을 얻어온다.
//	Date date = new Date();
//	int year = date.getYear() + 1900;
//	int month = date.getMonth() + 1;
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH) + 1;
//	out.println(year + "년 " + month + "월");
%>

<!-- 달력을 만든다. -->
<table width="700" align="center" border="1" cellpadding="5" cellspacing="0">

	<tr>
		<th colspan="7"><%=year%>년 <%=month%>월</th>
	</tr>

	<tr>
		<td class="sunday">일</td>
		<td class="etcday">월</td>
		<td class="etcday">화</td>
		<td class="etcday">수</td>
		<td class="etcday">목</td>
		<td class="etcday">금</td>
		<td class="saturday">토</td>
	</tr>

	<!-- 달력에 날짜를 출력한다. -->
	<tr>
	<%
//	1일 부터 달력을 출력할 달의 마지막 날짜까지 반복하며 날짜를 출력한다.
	for (int i = 1; i <= MyCalendar.lastDay(year, month); i++) {
	%>
		<td><%=i%></td>
	<%
//		출력한 날짜가 토요일이면 줄을 바꾼다.
		if (MyCalendar.weekDay(year, month, i) == 6) {
	%>
	</tr>
	<tr>
	<%
		}
	}
	%>
	</tr>

</table>

</body>
</html>

















