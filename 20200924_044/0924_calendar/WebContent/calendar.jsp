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
	/* 하이퍼링크 스타일 지정하기 */
	a:link {		/* 한 번도 방문하지 않은 하이퍼링크 */
		color: black;
		text-decoration: none;
	}
	a:visited {		/* 한 번 이상 클릭한 하이퍼링크 */
		color: black;
		text-decoration: none;
	}
	a:hover {		/* 마우스를 올리고 있을 때 */
		text-decoration: underline;
	}
	a:active {		/* 마우스로 누르고 있을 때 */
		color: skyblue;
		text-decoration: none;
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

//	이전달, 다음달 하이퍼링크 또는 버튼을 클릭했을 때 넘어오는 달력을 출력할 년, 월을 받는다.
	try {
		year = Integer.parseInt(request.getParameter("year"));
		month = Integer.parseInt(request.getParameter("month"));
		
//		month 13이 넘어왔으면 달력에는 다음해 1월을 표시해야 하고 month 0이 넘어왔으면 전년도 12월을 표시해야 한다.
		if (month >= 13) {
			year++;
			month = 1;
		} else if (month <= 0) {
			year--;
			month = 12;
		}
		
	} catch (NumberFormatException e) {
		
	}
%>

<!-- 달력을 만든다. -->
<table width="700" align="center" border="1" cellpadding="5" cellspacing="0">

	<tr>
		<th>
			<%-- <a href="?year=<%=year%>&month=<%=month - 1%>">이전달</a> --%>
			<input type="button" value="이전달" onclick="location.href='?year=<%=year%>&month=<%=month - 1%>'">
		</th>
		<th id="title" colspan="5"><%=year%>년 <%=month%>월</th>
		<th>
			<%-- <a href="?year=<%=year%>&month=<%=month + 1%>">다음달</a> --%>
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

	<!-- 달력에 날짜를 출력한다. -->
	<tr>
	<%
//	달력을 출력할 달 1일의 요일을 저장한다.
	int week = MyCalendar.weekDay(year, month, 1);
	
//	1일이 출력될 위치를 맞추기 위해서 1일의 요일만큼 반복하며 빈 칸을 출력한다.
//	for (int i = 0; i < week; i++) {
//		out.println("<td>&nbsp;</td>");
//	}

//	빈 칸에 출력할 전 달 날짜의 시작일을 계산한다.
	int start = 0;
	if (month == 1) {
//		start = MyCalendar.lastDay(year - 1, 12) - week; // 1월
		start = 31 - week; // 1월
	} else {
		start = MyCalendar.lastDay(year, month - 1) - week; // 2 ~ 12월
	}

//	1일이 출력될 위치를 맞추기 위해서 1일의 요일만큼 반복하며 전달의 날짜를 출력한다.
	for (int i = 0; i < week; i++) {
		if (i == 0) {
			out.println("<td class='beforesun'>" + (month == 1 ? 12 : month - 1) + "/" + ++start + "</td>");
		} else {
			out.println("<td class='before'>" + (month == 1 ? 12 : month - 1) + "/" + ++start + "</td>");
		}
	}
	
//	1일 부터 달력을 출력할 달의 마지막 날짜까지 반복하며 날짜를 출력한다.
	for (int i = 1; i <= MyCalendar.lastDay(year, month); i++) {
		
		boolean flag = false;
		int child = 0;
//		어린이날이 토요일 또는 일요일과 겹치는 경우 그 다음 첫 번째 비 공휴일을 대체 공휴일로 한다.
		if (MyCalendar.weekDay(year, 5, 5) == 6) {			// 어린이날이 토요일인가?
			flag = true;
			child = 7;
		} else if (MyCalendar.weekDay(year, 5, 5) == 0) {	// 어린이날이 일요일인가?
			flag = true;
			child = 6;
		}
		
//		양력 공휴일을 표시한다.
		if (month == 1 && i == 1) {
			out.println("<td class='holiday'>" + i + "<br><span>신정</span></td>");
		} else if (month == 3 && i == 1) {
			out.println("<td class='holiday'>" + i + "<br><span>삼일절</span></td>");
		} else if (month == 5 && i == 1) {
			out.println("<td class='holiday'>" + i + "<br><span>근로자의날</span></td>");
		} else if (month == 5 && i == 5) {
			out.println("<td class='holiday'>" + i + "<br><span>어린이날</span></td>");
		} else if (month == 6 && i == 6) {
			out.println("<td class='holiday'>" + i + "<br><span>현충일</span></td>");
		} else if (month == 8 && i == 15) {
			out.println("<td class='holiday'>" + i + "<br><span>광복절</span></td>");
		} else if (month == 10 && i == 3) {
			out.println("<td class='holiday'>" + i + "<br><span>개천절</span></td>");
		} else if (month == 10 && i == 9) {
			out.println("<td class='holiday'>" + i + "<br><span>한글날</span></td>");
		} else if (month == 12 && i == 25) {
			out.println("<td class='holiday'>" + i + "<br><span>크리스마스</span></td>");
		} else if (flag && month == 5 && i == child) {
			out.println("<td class='holiday'>" + i + "<br><span>어린이날<br>대체공휴일</span></td>");
		}

		else {
//			요일별로 글자색을 다르게 출력하기 위해 <td> 태그에 요일에 따른 class 속성을 지정한다.
			switch (MyCalendar.weekDay(year, month, i)) {
				case 0: // 일요일
					out.println("<td class='sun'>" + i + "</td>");
					break;
				case 6: // 토요일
					out.println("<td class='sat'>" + i + "</td>");
					break;
				default: // 평일
					out.println("<td class='etc'>" + i + "</td>");
					break;
			}
		}
		
//		출력한 날짜가 토요일이고 그 달의 마지막 날짜가 아니면 줄을 바꾼다.
		if (MyCalendar.weekDay(year, month, i) == 6 && i != MyCalendar.lastDay(year, month)) {
			out.println("</tr><tr>");
		}
	}

//	다음달 1일의 요일을 계산한다.
	if (month == 12) {
		week = MyCalendar.weekDay(year + 1, 1, 1);	// 12월
	} else {
		week = MyCalendar.weekDay(year, month + 1, 1);	// 1 ~ 11월
	}

//	날짜를 다 출력하고 남은 빈 칸에 다음달의 날짜를 다음달 1일의 요일 부터 토요일까지 반복하며 출력한다.
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

	<!-- 년, 월을 선택하고 보기 버튼을 클릭하면 특정 달의 달력으로 한 번에 넘어가게 한다. -->
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

















