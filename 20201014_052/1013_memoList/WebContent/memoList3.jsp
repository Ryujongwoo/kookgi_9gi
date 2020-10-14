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
	  background-color: white;		/* 배경색 */
	  border: 1px solid white;		/* 테두리 => 선두께, 선종류, 선색상 */
	  color: black;					/* 글자색 */
	  padding: 6px 6px;				/* 안여백 */
	  text-align: center;			/* 텍스트 정렬 */
	  text-decoration: none;		/* 선 */
	  display: inline-block;		/* 같은줄에 표시되게 한다. */
	  font-size: 15px;				/* 텍스트 크기 */
	  margin: 4px 2px;				/* 바깥 여백 */
	  transition-duration: 0.4s;	/* 애니메이션 재생시간 */
	  cursor: pointer;				/* 마우스 포인터 모양 */
	  width: 50px;					/* 가로 크기 */
	  height: 35px;					/* 세로 크기 */
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
			<th colspan="3">이제 그럭저럭 봐줄만한 출첵 게시판 Ver 0.85</th>
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
	int startPage = 0;			// 페이지 이동 하이퍼링크 또는 버튼에 표시될 시작 페이지 번호
	int endPage = 0;			// 페이지 이동 하이퍼링크 또는 버튼에 표시될 마지막 페이지 번호
	
	Connection conn = DBUtil.getMysqlConnection();
	
	String sql = "select count(*) from memolist";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	rs.next();
	totalCount = rs.getInt(1);
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
	
	<tr>
		<td colspan="5" align="center">
		<%
//		페이지 이동 버튼의 시작 페이지 번호와 마지막 페이지 번호를 계산한다.
		startPage = (currentPage - 1) / 10 * 10 + 1;
		endPage = startPage + 9;
//		페이지 이동 버튼의 마지막 페이지 번호가 전체 페이지 수 보다 커지면 존재하지 않는 페이지 번호가 표시되므로 마지막 페이지 번호를
//		전체 페이지 수로 변경한다.
		endPage = endPage > totalPage ? totalPage : endPage;
		
//		맨 앞으로
//		현재 페이지가 1보다 크다면 이전 페이지 목록이 있다.
		if (currentPage > 1) {
		%>
			<input class="button" type="button" value="맨앞" onclick="location.href='?currentPage=1'" title="첫 페이지 목록으로 이동하기"/>
		<%
		} else {
		%>
			<input class="button" type="button" value="맨앞" disabled="disabled" title="이미 첫 번째 목록입니다."/>
		<%
		}

//		10페이지 앞으로 이동 버튼을 출력한다.
//		startPage가 1보다 크다면 이전 페이지 목록이 있다.
		if (startPage > 1) {
		%>
			<input class="button" type="button" value="이전" onclick="location.href='?currentPage=<%=startPage - 1%>'" title="이전 페이지 목록으로 이동하기"/>
		<%
		} else {
		%>
			<input class="button" type="button" value="이전" disabled="disabled" title="이미 첫 번째 페이지 목록입니다."/>
		<%
		}
		
//		10페이지 단위로 페이지 이동 버튼을 출력한다.
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

//		10페이지 뒤로 이동 버튼을 출력한다.
//		endPage가 totalPage 보다 작으면 다음 페이지 목록이 있다.
		if (endPage < totalPage) {
		%>
			<input class="button" type="button" value="다음" onclick="location.href='?currentPage=<%=endPage + 1%>'" title="다음 페이지 목록으로 이동하기"/>
		<%
		} else {
		%>
			<input class="button" type="button" value="다음" disabled="disabled" title="이미 마지막 페이지 목록입니다."/>
		<%
		}

//		맨 뒤로
//		현재 페이지가 totalPage 보다 작으면 다음 페이지 목록이 있다.
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
















