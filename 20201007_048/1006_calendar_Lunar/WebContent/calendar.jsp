<%@page import="com.koreait.myCalendar.SolaToLunar"%>
<%@page import="com.koreait.myCalendar.LunarDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.koreait.myCalendar.MyCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만년달력 - 음력처리</title>

<style type="text/css">

	tr {
		height: 80px;
	}
	th#title {
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
	td.sun {
		font-size: 12pt;
		font-weight: bold;
		text-align: right;
		vertical-align: top;
		color: red;
	}
	td.sat {
		font-size: 12pt;
		font-weight: bold;
		text-align: right;
		vertical-align: top;
		color: blue;
	}
	td.etc {
		font-size: 12pt;
		font-weight: bold;
		text-align: right;
		vertical-align: top;
	}
	td.beforesun {
		font-size: 8pt;
		font-weight: bold;
		text-align: right;
		vertical-align: top;
		color: red;
	}
	td.before {
		font-size: 8pt;
		font-weight: bold;
		text-align: right;
		vertical-align: top;
	}
	td.aftersat {
		font-size: 8pt;
		font-weight: bold;
		text-align: right;
		vertical-align: top;
		color: blue;
	}
	td.after {
		font-size: 8pt;
		font-weight: bold;
		text-align: right;
		vertical-align: top;
	}
	.select {
		width: 100px;
		height: 30px;
	}
	.holiday {
		font-size: 12pt;
		font-weight: bold;
		text-align: right;
		vertical-align: top;
		color: red;
		background: yellow;
	}
	span {
		font-size: 9pt;
	}
	a:link {
		color: black;
		text-decoration: none;
	}
	a:visited {
		color: black;
		text-decoration: none;
	}
	a:hover {
		text-decoration: underline;
	}
	a:active {
		color: skyblue;
		text-decoration: none;
	}

</style>

</head>
<body>

<%
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH) + 1;

	try {
		year = Integer.parseInt(request.getParameter("year"));
		month = Integer.parseInt(request.getParameter("month"));
		
		if (month >= 13) {
			year++;
			month = 1;
		} else if (month <= 0) {
			year--;
			month = 12;
		}
		
	} catch (NumberFormatException e) {
		
	}

//	달력을 출력할 달의 양력 음력 대조 결과를 얻어온다.
	ArrayList<LunarDate> lunarDate = SolaToLunar.solaToLunar(year, month);
%>

<table width="700" align="center" border="1" cellpadding="5" cellspacing="0">

	<tr>
		<th>
			<input type="button" value="이전달" onclick="location.href='?year=<%=year%>&month=<%=month - 1%>'">
		</th>
		<th id="title" colspan="5"><%=year%>년 <%=month%>월</th>
		<th>
			<button type="button" onclick="location.href='?year=<%=year%>&month=<%=month + 1%>'">다음달</button>
		</th>
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

	<tr>
	<%
	int week = MyCalendar.weekDay(year, month, 1);
	int start = 0;
	if (month == 1) {
		start = 31 - week;
	} else {
		start = MyCalendar.lastDay(year, month - 1) - week;
	}

	for (int i = 0; i < week; i++) {
		if (i == 0) {
			out.println("<td class='beforesun'>" + (month == 1 ? 12 : month - 1) + "/" + ++start + "</td>");
		} else {
			out.println("<td class='before'>" + (month == 1 ? 12 : month - 1) + "/" + ++start + "</td>");
		}
	}
	
	for (int i = 1; i <= MyCalendar.lastDay(year, month); i++) {
		
//		공휴일인가 평일인가 판단해서 class 속성을 다르게 지정해서 날짜를 출력한다.
		if (lunarDate.get(i - 1).getLunar() == null) {
			switch (MyCalendar.weekDay(year, month, i)) {
				case 0:
					out.println("<td class='sun'>" + i + "</td>");
					break;
				case 6:
					out.println("<td class='sat'>" + i + "</td>");
					break;
				default:
					out.println("<td class='etc'>" + i + "</td>");
					break;
			}
		} else {
			out.println("<td class='holiday'>" + i + lunarDate.get(i - 1).getLunar() + "</td>");
		}
		
		if (MyCalendar.weekDay(year, month, i) == 6 && i != MyCalendar.lastDay(year, month)) {
			out.println("</tr><tr>");
		}
	}

	if (month == 12) {
		week = MyCalendar.weekDay(year + 1, 1, 1);
	} else {
		week = MyCalendar.weekDay(year, month + 1, 1);
	}

	start = 0;
	for (int i = week; i <= 6; i++) {
		if (week == 0) {
			break;
		}
		if (i == 6) {
			out.println("<td class='aftersat'>" + (month == 12 ? 1 : month + 1) + "/" + ++start + "</td>");
		} else {
			out.println("<td class='after'>" + (month == 12 ? 1 : month + 1) + "/" + ++start + "</td>");
		}
	}
	%>
	</tr>

	<tr>
		<td colspan="7" align="center">
			<form action="?" method="post">
				<select class="select" name="year">
				<%
				for (int i = 1950; i <= 2050; i++) {
					if (i == calendar.get(Calendar.YEAR)) {
						out.println("<option selected='selected'>" + i + "</option>");
					} else {
						out.println("<option>" + i + "</option>");
					}
				}
				%>
				</select>년 
				<select class="select" name="month">
				<%
				for (int i = 1; i <= 12; i++) {
					out.println("<option>" + i + "</option>");
				}
				%>
				</select>월 
				<input class="select" type="submit" value="보기">
			</form>
		</td>
	</tr>

</table>

</body>
</html>

















