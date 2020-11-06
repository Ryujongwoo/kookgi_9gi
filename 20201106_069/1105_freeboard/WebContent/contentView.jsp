<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>

<table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
	<tr><th colspan="4">게시글 보기</th></tr>
	<tr>
		<th width="80">글번호</th>
		<th width="320">이름</th>
		<th width="120">작성일</th>
		<th width="80">조회수</th>
	</tr>
	<tr>
		<td align="center">${vo.idx}</td>
		<td align="center">
			<c:set var="name" value="${fn:replace(fn:trim(vo.name), '<', '&lt;')}"/>
			<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>
			${name}
		</td>
		<td align="center">
			<jsp:useBean id="date" class="java.util.Date"/>
			<c:if test="${date.year == vo.writeDate.year && date.month == vo.writeDate.month && date.date == vo.writeDate.date}">
				<fmt:formatDate value="${vo.writeDate}" pattern="a h:mm"/>
			</c:if>
			<c:if test="${date.year != vo.writeDate.year || date.month != vo.writeDate.month || date.date != vo.writeDate.date}">
				<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
			</c:if>
		</td>
		<td align="center">${vo.hit}</td>
	</tr>
	<tr>
		<td>제목</td>
		<td colspan="3">
			<c:set var="subject" value="${fn:replace(fn:trim(vo.subject), '<', '&lt;')}"/>
			<c:set var="subject" value="${fn:replace(subject, '>', '&gt;')}"/>
			${subject}
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td colspan="3">
			<c:set var="content" value="${fn:replace(fn:trim(vo.content), '<', '&lt;')}"/>
			<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"/>
			<c:set var="content" value="${fn:replace(content, enter, '<br/>')}"/>
			${content}
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="button" value="수정하기" 
				onclick="location.href='selectByIdx.jsp?idx=${vo.idx}&currentPage=${currentPage}&job=update'"/>
			<input type="button" value="삭제하기" 
				onclick="location.href='selectByIdx.jsp?idx=${vo.idx}&currentPage=${currentPage}&job=delete'"/>
			<!-- history.back(), history.go(-1)를 사용하면 단순히 전 화면으로 가기 때문에 변경된 조회수가 반영되지 않고 F5를 눌러야 반영된다. -->
			<input type="button" value="돌아가기" onclick="location.href='list.jsp?currentPage=${currentPage}'"/>
		</td>
	</tr>
</table>

</body>
</html>















