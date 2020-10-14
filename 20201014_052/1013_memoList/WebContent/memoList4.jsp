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

	.button {
	  background-color: white;
	  border: 1px solid white;
	  color: black;
	  padding: 6px 6px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 15px;
	  margin: 4px 2px;
	  transition-duration: 0.4s;
	  cursor: pointer;
	  width: 50px;
	  height: 35px;
	}
	
	.button1 {
	  background-color: tomato; 
	  color: yellow;
	  font-weight: bold;
	  border: 1px solid white;
	}
	
	.button1:hover {
	  background-color: yellow;
	  color: tomato;
	}
	
	.button2:hover {
	  background-color: #008CBA;
	  color: white;
	}

</style>

</head>
<body>

<form action="memoInsert.jsp" method="post">
	<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
	
		<tr>
			<th colspan="3">이제 그럭저럭 봐줄만한 출첵 게시판 Ver 0.99</th>
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
	int pageSize = 10;
	int totalCount = 0;
	int totalPage = 0;
	int currentPage = 1;
	int startNo = 0;
	int endNo = 0;
	int startPage = 0;
	int endPage = 0;
	
	Connection conn = DBUtil.getMysqlConnection();
	
	String sql = "select count(*) from memolist";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	totalCount = rs.getInt(1);
	
//	=========================================================================================================================================

//	select 태그에서 선택한 페이지당 표시할 글의 개수를 받는다.
//	게시판이 최초로 실행될 때 이전 페이지가 없으므로 넘어오는 pageSize의 값이 null 이고 보기 버튼 이외의 다른 버튼이 클릭되면 pageSize가 
//	넘어오지 않기 때문에 예외 처리를 한다.

	try {
		pageSize = Integer.parseInt(request.getParameter("pageSize"));
//		화면에 표시할 글의 개수가 정상적으로 넘어왔으므로 화면에 표시할 글의 개수를 세션에 저장한다.
		session.setAttribute("pageSize", pageSize + "");
	} catch (NumberFormatException e) {
//		이전 페이지에서 넘어오는 pageSize가 null이면 세션에 저장해둔 pageSize를 얻어와서 화면에 표시할 글의 개수로 지정한다.
//		브라우저가 최초로 실행될 때 세션이 만들어지기 때문에 브라우저가 최초로 실행되면 이전 페이지에서 넘어오는 pageSize도 null이고 
//		세션에 저장된 pageSize도 null 이다.
		String temp = (String) session.getAttribute("pageSize");
		if (temp != null) {
			pageSize = Integer.parseInt(temp);
		}
	}

//	=========================================================================================================================================
	
	totalPage = (totalCount - 1) / pageSize + 1;

	try {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		currentPage = currentPage > totalPage ? totalPage : currentPage;
	} catch (NumberFormatException e) {
		
	}

	startNo = (currentPage - 1) * pageSize;
	endNo = startNo + pageSize - 1;
	endNo = endNo > totalCount ? totalCount : endNo;

	sql = "select * from memolist order by idx desc limit ?, ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, startNo);
	pstmt.setInt(2, pageSize);
	rs = pstmt.executeQuery();
%>

<table width="1300" align="center" border="1" cellpadding="5" cellspacing="0">
	
	<tr>
		<th width="80">글번호</th>
		<th width="80">이름</th>
		<th width="800">메모</th>
		<th width="120">작성일</th>
		<th width="120">IP</th>
		<th width="100">&nbsp;</th>
	</tr>
	
	<tr>
		<td colspan="3">
			
			<form action="?" method="post">
				페이지당 표시할 글의 개수를 선택하세요
				<!--
				<select name="pageSize" style="width: 100px;">
					<option>3</option>
					<option>5</option>
					<option selected="selected">10</option>
					<option>15</option>
					<option>20</option>
				</select>
				-->
				<!--
				<input type="radio" name="pageSize" value="3"/>3
				<input type="radio" name="pageSize" value="5"/>5
				<input type="radio" name="pageSize" value="10" checked="checked"/>10
				<input type="radio" name="pageSize" value="15"/>15
				<input type="radio" name="pageSize" value="20"/>20
				-->
				<input type="number" name="pageSize" value="10"/>
				<input type="submit" value="보기"/>
			</form>
			
		</td>
		<td colspan="3" align="right">
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
		<td align="center"><%=rs.getString("name").replace("<", "&lt;").replace(">", "&gt;")%></td>
		<td><%=rs.getString("memo").replace("<", "&lt;").replace(">", "&gt;")%></td>
		<td align="center"><%=sdf.format(rs.getTimestamp("writeDate"))%></td>
		<td align="center"><%=rs.getString("ip")%></td>
		<td align="center">
		
			<!-- 수정 또는 삭제 작업시 수정 또는 삭제할 글번호(idx)와 작업 후 돌아갈 페이지 번호(cuurrentPage)를 넘겨준다. -->
			<input type="button" value="수정" onclick="location.href='memoUpdate.jsp?idx=<%=rs.getInt("idx")%>&currentPage=<%=currentPage%>'"/>
			<input type="button" value="삭제" onclick="location.href='memoDelete.jsp?idx=<%=rs.getInt("idx")%>&currentPage=<%=currentPage%>'"/>
		
		</td>
	</tr>
<%
	} while (rs.next());
} else {
%>
	<tr>
		<td colspan="6">
			<marquee>테이블에 저장된 글이 없습니다.</marquee>
		</td>
	</tr>
<%
}
%>
	
	<tr>
		<td colspan="6" align="center">
		<%
		startPage = (currentPage - 1) / 10 * 10 + 1;
		endPage = startPage + 9;
		endPage = endPage > totalPage ? totalPage : endPage;
		
		if (currentPage > 1) {
		%>
			<input class="button" type="button" value="맨앞" onclick="location.href='?currentPage=1'" title="첫 페이지 목록으로 이동하기"/>
		<%
		} else {
		%>
			<input class="button" type="button" value="맨앞" disabled="disabled" title="이미 첫 번째 목록입니다."/>
		<%
		}

		if (startPage > 1) {
		%>
			<input class="button" type="button" value="이전" onclick="location.href='?currentPage=<%=startPage - 1%>'" title="이전 페이지 목록으로 이동하기"/>
		<%
		} else {
		%>
			<input class="button" type="button" value="이전" disabled="disabled" title="이미 첫 번째 페이지 목록입니다."/>
		<%
		}
		
		for (int i = startPage; i <= endPage; i++) {
			if (currentPage == i) {
		%>
			<input class="button button1" type="button" value="<%=i%>" disabled="disabled"/>
		<%
			} else {
		%>
			<input class="button button2" type="button" value="<%=i%>" onclick="location.href='?currentPage=<%=i%>'"/>
		<%
			}
		}

		if (endPage < totalPage) {
		%>
			<input class="button" type="button" value="다음" onclick="location.href='?currentPage=<%=endPage + 1%>'" title="다음 페이지 목록으로 이동하기"/>
		<%
		} else {
		%>
			<input class="button" type="button" value="다음" disabled="disabled" title="이미 마지막 페이지 목록입니다."/>
		<%
		}

		if (currentPage < totalPage) {
		%>
			<input class="button" type="button" value="맨뒤" onclick="location.href='?currentPage=<%=totalPage%>'" title="마지막 페이지 목록으로 이동하기"/>
		<%
		} else {
		%>
			<input class="button" type="button" value="맨뒤" disabled="disabled" title="이미 마지막 목록입니다."/>
		<%
		}
		%>
		</td>
	</tr>
		
</table>

</body>
</html>
















