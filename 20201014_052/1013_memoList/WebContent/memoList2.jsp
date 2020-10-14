<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.koreait.memolist.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출첵 게시판</title>

<style type="text/css">

	a {
		color: black;
		text-decoration: none;
	}
	a:hover {
		color: red;
		text-decoration: none;
	}
	span {
		color: white;
		background: black;
	}

</style>

</head>
<body>

<form action="memoInsert.jsp" method="post">
	<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
	
		<tr>
			<th colspan="3">조금 덜 허접해 보이는 페이지 기능이 구현된 출첵 게시판 Ver 0.49</th>
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

<hr size="3" color="red"/>

<%
//	페이지 작업에 사용할 8개의 변수를 선언한다. => 계산에 의한 값을 가져야 하는 변수는 0으로 초기화 한다.
	int pageSize = 10;			// 한 페이지에 표시할 글의 개수
	int totalCount = 0;			// 테이블에 저장된 전체 글의 개수
	int totalPage = 0;			// 전체 페이지 개수
	int currentPage = 1;		// 현재 브라우저에 표시되는 페이지 번호
	int startNo = 0;			// 현재 브라우저에 표시되는 글의 시작 인덱스
	int endNo = 0;				// 현재 브라우저에 표시되는 글의 마지막 인덱스 => mysql은 사용하지 않고 oracle에서 사용한다.
	int startPage = 0;			// 페이지 이동 하이퍼링크 또는 버튼에 표시될 시작 페이지 번호
	int endPage = 0;			// 페이지 이동 하이퍼링크 또는 버튼에 표시될 마지막 페이지 번호
	
	Connection conn = DBUtil.getMysqlConnection();
	
//	========================================================================================================================================

//	totalCount 변수에 테이블에 저장된 전체 글의 개수를 얻어와 저장한다.
	String sql = "select count(*) from memolist";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
//	테이블에 저장된 글이 있으면 저장된 글의 개수를 얻어와서 ResultSet 객체에 저장하고 테이블에 저장된 글이 없으면 0을 ResultSet 객체에 
//	저장할 것이므로 ResultSet 객체에 저장된 데이터가 무조건 존재하기 때문에 물어보는 동작을 할 필요가 없다.
	rs.next();
	totalCount = rs.getInt(1);
//	out.println("테이블에 저장된 전체 글의 개수 : " + totalCount + "<br/>");
	
//	totalPage 변수에 전체 페이지 개수를 계산해서 저장한다.
	totalPage = (totalCount - 1) / pageSize + 1;
//	out.println("전체 페이지 개수 : " + totalPage + "<br/>");

//	========================================================================================================================================

//	이전 페이지에서 넘어오는 화면에 표시할 페이지 번호를 받는다.
//	게시판(memoList2.jsp)이 최초로 실행될 때 이전 페이지가 존재하지 않기 때문에 이전 페이지에서 넘어오는 currentPage가 존재하지 않기 때문에
//	null 이고 다른 페이지에서 memoList2.jsp가 호출될 때 currentPage를 넘겨주지 않기 때문에 역시 null 이다.
//	null을 parseInt() 메소드를 실행하면 NumberFormatException이 발생되기 때문에 화면에 표시할 페이지 번호 currentPage를 받을 때 반드시
//	예외 처리를 해줘야 한다.
//	정상적으로 currentPage가 넘어오면 넘어온 currentPage를 숫자로 바꿔서 currentPage 변수에 저장하면 되고 그렇치 않으면 초기값으로 지정된
//	1이 유지된다.
	try {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
//		현재 화면에 표시되는 페이지 번호는 전체 페이지의 개수 보다 클 수 없으므로 화면에 표시할 페이지 번호가 전체 페이지 개수 보다 큰 값이
//		넘어왔으면 전체 페이지 개수로 화면에 표시할 페이지 번호를 수정한다.
		currentPage = currentPage > totalPage ? totalPage : currentPage;
	} catch (NumberFormatException e) {
		
	}

//	========================================================================================================================================

//	startNo 변수에 현재 화면에 표시될 시작 인덱스 번호를 계산한다.
//	mysql은 select sql 명령을 실행했을 때 맨 처음 나오는 글의 인덱스 번호가 0부터 시작되고 oracle은 1부터 시작된다.
	startNo = (currentPage - 1) * pageSize;		// oracle은 결과에 1을 더한다.
//	mysql은 limit를 사용하면 되기 때문에 endNo를 계산할 필요가 없지만 oracle은 limit가 없기 때문에 endNo를 계산한다.
	endNo = startNo + pageSize - 1;
//	한 페이지 표시되는 글의 개수는 반드시 화면에 표시할 글의 개수 만큼 표시되지 않는다.
//	한 페이지에 표시할 마지막 글의 인덱스 번호는 전체 글의 개수 보다 커지면 안되므로 마지막 글의 인덱스 번호가 전체 글의 개수 보다 커지면
//	전체 글의 개수로 마지막 글의 인덱스 번호를 수정한다.
	endNo = endNo > totalCount ? totalCount : endNo;

//	========================================================================================================================================

//	브라우저에 표시할 한 페이지 분량의 글을 limit를 이용해서 얻어온다.
	sql = "select * from memolist order by idx desc limit ?, ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, startNo);
	pstmt.setInt(2, pageSize);
	rs = pstmt.executeQuery();
%>

<table width="1200" align="center" border="1" cellpadding="5" cellspacing="0">
	
	<tr>
		<th width="80">글번호</th>
		<th width="80">이름</th>
		<th width="800">메모</th>
		<th width="120">작성일</th>
		<th width="120">IP</th>
	</tr>
	
	<tr>
		<td colspan="5" align="right">
			<%=totalCount%>개(<%=currentPage%>/<%=totalPage%>)Page
		</td>
	</tr>
	
<%
if (rs.next()) {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
	do {
%>
	<tr>
		<td align="center"><%=rs.getInt("idx")%></td>
		<td align="center"><%=rs.getString("name")%></td>
		<td><%=rs.getString("memo")%></td>
		<td align="center"><%=sdf.format(rs.getTimestamp("writeDate"))%></td>
		<td align="center"><%=rs.getString("ip")%></td>
	</tr>
<%
	} while (rs.next());
} else {
%>
	<tr>
		<td colspan="5">
			<marquee>테이블에 저장된 글이 없습니다.</marquee>
		</td>
	</tr>
<%
}
%>
	
	<!-- 1페이지 부터 마지막 페이지 까지 이동할 수 있는 하이퍼링크 또는 버튼을 만든다. -->
	<tr>
		<td colspan="5" align="center">
		<%
		for (int i = 1; i <= totalPage; i++) {
			if (currentPage == i) {
		%>
			<%-- <span>[<%=i%>]</span> --%>
			<%-- <input type="button" value="<%=i%>" disabled="disabled"> --%>
			<button type="button" disabled="disabled"><%=i%></button>
		<%
			} else {
		%>
			<%-- <a href="?currentPage=<%=i%>">[<%=i%>]</a> --%>
			<%-- <input type="button" value="<%=i%>" onclick="location.href='?currentPage=<%=i%>'"> --%>
			<button type="button" onclick="location.href='?currentPage=<%=i%>'"><%=i%></button>
		<%
			}
		}
		%>
		</td>
	</tr>
	
	<tr>
		<td colspan="5" align="center">
		<%
		for (int i = 1; i <= totalPage; i++) {
			if (currentPage == i) {
				out.println("<input type='button' value='" + i + "' disabled='disabled'>");
			} else {
				out.println("<input type='button' value='" + i + "' onclick='location.href=\"?currentPage=" + i + "\"'>");
			}
		}
		%>
		</td>
	</tr>
	
</table>

</body>
</html>
















