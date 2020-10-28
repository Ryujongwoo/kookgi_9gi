<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.koreait.vo.GuestbookVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.koreait.vo.GuestbookList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 보기</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
//	list.jsp에서 1페이지 분량의 글 목록과 페이지 작업에 사용할 8개의 변수를 초기화 시켜 request 영역에 저장한 GuestbookList 클래스 객체를
//	받는다. => request 영역에 저장된 데이터는 Object 타입이므로 반드시 얻어온 다음에 형변환을 시켜야 한다.
	GuestbookList guestbookList = (GuestbookList) request.getAttribute("guestbookList");
//	out.println(guestbookList);
//	out.println(guestbookList.getList());

//	브라우저에 출력할 1페이지 분량의 글 목록(guestbookList.getList())만 꺼내서 별도로 ArrayList에 저장시켜 사용한다.
	ArrayList<GuestbookVO> view = guestbookList.getList();
//	for (GuestbookVO vo : view) {
//		out.println(vo + "<br/>");
//	}
%>

<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th>방명록 보기</th>
	</tr>
	
	<tr>
		<td align="right">
			<%=guestbookList.getTotalCount()%>개(<%=guestbookList.getCurrentPage()%> / <%=guestbookList.getTotalPage()%>)Page
		</td>
	</tr>
	
	<tr>
		<td>
		<%
			if (view.size() == 0) {
				out.println("<marquee>테이블에 저장된 글이 없습니다.</marquee>");
			} else {
//				컴퓨터 시스템의 현재 날짜와 시간을 얻어온다.
				Date date = new Date();
//				날짜 데이터에 적용할 서식을 만든다.
				SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd(E)");
				
				for (GuestbookVO vo : view) {
		%>
			
			<table width="99%" align="center" border="1" cellpadding="5" cellspacing="0" 

			<%
				if (vo.getIdx() % 2 == 0) {
					out.println("bgcolor='skyblue'");
				} else {
					out.println("bgcolor='hotpink'");
				}
			%>

			>
				<tr>
					<td>
					
						<%=vo.getIdx()%>. <%=vo.getName().replace("<", "&lt;").replace(">", "&gt;")%>님(<%=vo.getIp()%>)이 
						
						<!-- 오늘 입력한 글은 시간만 나오게 하고 어제 이전에 입력한 글은 날짜만 나오게 한다. -->
						<%
							if (date.getYear() == vo.getWriteDate().getYear() && date.getMonth() == vo.getWriteDate().getMonth() &&
								date.getDate() == vo.getWriteDate().getDate()) {
								out.println(sdf1.format(vo.getWriteDate()));
							} else {
								out.println(sdf2.format(vo.getWriteDate()));
							}
						%>
						
						에 남긴글<br/>
						<%=vo.getMemo().replace("<", "&lt;").replace(">", "&gt;").replace("\r\n", "<br/>")%> 
					
					</td>
				</tr>
			</table>
			
		<%
				}
			}
		%>
		</td>
	</tr>
	
	<!-- 페이지 이동 버튼 -->
	<tr>
		<td align="center">
		
		<%
			if (guestbookList.getCurrentPage() > 1) {
		%>
			<input class="button" type="button" value="맨앞" onclick="location.href='?currentPage=1'" title="첫 페이지 목록으로 이동하기"/>
		<%
			} else {
		%>
			<input class="button" type="button" value="맨앞" disabled="disabled" title="이미 첫 번째 목록입니다."/>
		<%
			}

			if (guestbookList.getStartPage() > 1) {
		%>
			<input class="button" type="button" value="이전" onclick="location.href='?currentPage=<%=guestbookList.getStartPage() - 1%>'" 
				title="이전 페이지 목록으로 이동하기"/>
		<%
			} else {
		%>
			<input class="button" type="button" value="이전" disabled="disabled" title="이미 첫 번째 페이지 목록입니다."/>
		<%
			}
		
			for (int i = guestbookList.getStartPage(); i <= guestbookList.getEndPage(); i++) {
				if (guestbookList.getCurrentPage() == i) {
		%>
			<input class="button button1" type="button" value="<%=i%>" disabled="disabled"/>
		<%
				} else {
		%>
			<input class="button button2" type="button" value="<%=i%>" onclick="location.href='?currentPage=<%=i%>'"/>
		<%
				}
			}

			if (guestbookList.getEndPage() < guestbookList.getTotalPage()) {
		%>
			<input class="button" type="button" value="다음" onclick="location.href='?currentPage=<%=guestbookList.getEndPage() + 1%>'" 
				title="다음 페이지 목록으로 이동하기"/>
		<%
			} else {
		%>
			<input class="button" type="button" value="다음" disabled="disabled" title="이미 마지막 페이지 목록입니다."/>
		<%
			}

			if (guestbookList.getCurrentPage() < guestbookList.getTotalPage()) {
		%>
			<input class="button" type="button" value="맨뒤" onclick="location.href='?currentPage=<%=guestbookList.getTotalPage()%>'" 
				title="마지막 페이지 목록으로 이동하기"/>
		<%
			} else {
		%>
			<input class="button" type="button" value="맨뒤" disabled="disabled" title="이미 마지막 목록입니다."/>
		<%
			}
		%>
		
		</td>
	</tr>
	
	<!-- 글 쓰기 버튼 -->
	<tr>
		<td align="right">
			<input type="button" value="글쓰기" onclick="location.href='insert.jsp'"/>
		</td>
	</tr>
</table>

</body>
</html>










