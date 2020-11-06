<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

	a {
		color: black;
		text-decoration: none;
	}
	a:hover {
		color: red;
		text-decoration: none;
	}

</style>

</head>
<body>

<table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
	<tr><th colspan="5">게시판 보기</th></tr>
	<tr>
		<td colspan="5" align="right">
			${freeboardList.totalCount}(${freeboardList.currentPage} / ${freeboardList.totalPage})Page
		</td>
	</tr>
	<tr>
		<th width="80">글번호</th>
		<th width="620">제목</th>
		<th width="100">이름</th>
		<th width="120">작성일</th>
		<th width="80">조회수</th>
	</tr>
	
	<!-- 오늘 날짜를 기억하는 Date 클래스 객체를 만든다. -->
	<jsp:useBean id="date" class="java.util.Date"/>
	
	<!-- 공지글이 있으면 출력한다. -->
	
	<!-- 메인글의 제목을 출력한다. -->
	<!-- request 영역의 freeboardList 객체에서 1페이지 분량의 글이 저장된 ArrayList(list)의 내용만 얻어온다. -->
	<c:set var="list" value="${freeboardList.list}"/>
	
	<!-- 메인글이 한 건도 없으면 없다고 출력한다. -->
	<c:if test="${list.size() == 0}">
	<tr>
		<td colspan="5">
			<marquee>테이블에 저장된 글이 없습니다.</marquee>
		</td>
	</tr>
	</c:if>
	
	<!-- 메인글이 있으면 메인글의 개수 만큼 반복하며 제목을 출력한다. -->
	<c:if test="${list.size() != 0}">
	<c:forEach var="vo" items="${list}">
	<tr>
	
		<td align="center">${vo.idx}</td>
		
		<td>
			<c:set var="subject" value="${fn:replace(fn:trim(vo.subject), '<', '&lt;')}"/>
			<c:set var="subject" value="${fn:replace(subject, '>', '&gt;')}"/>
			
			<!-- 오늘 입력된 글에 new 아이콘을 표시한다. -->
			<c:if test="${date.year == vo.writeDate.year && date.month == vo.writeDate.month && date.date == vo.writeDate.date}">
				<img src="./images/new.png"/>
			</c:if>
			
			<!-- 제목에 하이퍼링크를 걸어준다. => 하이퍼링크를 클릭하면 조회수를 증가하고 메인글의 내용을 표시한다. -->
			<a href="increment.jsp?idx=${vo.idx}&currentPage=${freeboardList.currentPage}">
				${subject}
			</a>[${vo.commentCount}]
			
			<!-- 오늘 입력된 글에 new 아이콘을 표시한다. -->
			<c:if test="${date.year == vo.writeDate.year && date.month == vo.writeDate.month && date.date == vo.writeDate.date}">
				<img src="./images/ic_new.gif"/>
			</c:if>
		</td>
		
		<td align="center">
			<c:set var="name" value="${fn:replace(fn:trim(vo.name), '<', '&lt;')}"/>
			<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>
			${name}
		</td>
		
		<td align="center">
			<c:if test="${date.year == vo.writeDate.year && date.month == vo.writeDate.month && date.date == vo.writeDate.date}">
				<fmt:formatDate value="${vo.writeDate}" pattern="a h:mm"/>
			</c:if>
			<c:if test="${date.year != vo.writeDate.year || date.month != vo.writeDate.month || date.date != vo.writeDate.date}">
				<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
			</c:if>
		</td>
		
		<td align="center">${vo.hit}</td>
		
	</tr>
	</c:forEach>
	</c:if>
	
	<!-- 페이지 이동 버튼 -->
	<tr>
		<td colspan="5" align="center">
		
			<!-- 처음으로 -->
			<c:if test="${freeboardList.currentPage > 1}">
				<input class="button" type="button" value="맨앞" onclick="location.href='?currentPage=1'" title="첫 페이지 목록으로 이동하기"/>
			</c:if>
			<c:if test="${freeboardList.currentPage <= 1}">
				<input class="button" type="button" value="맨앞" disabled="disabled" title="이미 첫 번째 목록입니다."/>
			</c:if>
			
			<!-- 10페이지 앞으로 -->
			<c:if test="${freeboardList.startPage > 1}">
				<input class="button" type="button" value="이전" onclick="location.href='?currentPage=${freeboardList.startPage - 1}'" 
					title="이전 페이지 목록으로 이동하기"/>
			</c:if>
			<c:if test="${freeboardList.startPage <= 1}">
				<input class="button" type="button" value="이전" disabled="disabled" title="이미 첫 번째 페이지 목록입니다."/>
			</c:if>
			
			<!-- 페이지 이동 -->
			<c:forEach var="i" begin="${freeboardList.startPage}" end="${freeboardList.endPage}" step="1">
				<c:if test="${freeboardList.currentPage == i}">
					<input class="button button1" type="button" value="${i}" disabled="disabled"/>
				</c:if>
				<c:if test="${freeboardList.currentPage != i}">
					<input class="button button2" type="button" value="${i}" onclick="location.href='?currentPage=${i}'"
						title="${i}페이지로 이동합니다."/>
				</c:if>
			</c:forEach>
			
			<!-- 10페이지 뒤로 -->
			<c:if test="${freeboardList.endPage < freeboardList.totalPage}">
				<input class="button" type="button" value="다음" onclick="location.href='?currentPage=${freeboardList.endPage + 1}'" 
					title="다음 페이지 목록으로 이동하기"/>
			</c:if>
			<c:if test="${freeboardList.endPage >= freeboardList.totalPage}">
				<input class="button" type="button" value="다음" disabled="disabled" title="이미 마지막 페이지 목록입니다."/>
			</c:if>
			
			<!-- 마지막으로 -->
 			<c:if test="${freeboardList.currentPage < freeboardList.totalPage}">
				<input class="button" type="button" value="맨뒤" onclick="location.href='?currentPage=${freeboardList.totalPage}'" 
					title="마지막 페이지 목록으로 이동하기"/>
			</c:if>
			<c:if test="${freeboardList.currentPage >= freeboardList.totalPage}">
				<input class="button" type="button" value="맨뒤" disabled="disabled" title="이미 마지막 목록입니다."/>
			</c:if>
			
		</td>
	</tr>
	
	<tr>
		<td colspan="5" align="right">
			<input type="button" value="글쓰기" onclick="location.href='insert.jsp'"/>
		</td>
	</tr>
</table>

</body>
</html>















