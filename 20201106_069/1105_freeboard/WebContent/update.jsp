<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정할 글 보기</title>
</head>
<body>

<form action="updateOK.jsp" method="post">

	<table width="620" align="center" border="1" cellpadding="5" cellspacing="0">
	
		<tr><th colspan="4">수정할 글 보기</th></tr>
		
		<tr>
			<th width="80">글번호</th>
			<th width="320">이름</th>
			<th width="120">작성일</th>
			<th width="100">조회수</th>
		</tr>
		
		<tr>
			<td align="center">${vo.idx}</td>
			<td>
				<!--
				<c:set var="name" value="${fn:replace(fn:trim(vo.name), '<', '&lt;')}"/>
				<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>
				${name}
				-->
				<input type="text" name="name" value="${fn:trim(vo.name)}" readonly="readonly"/>
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
			<td colspan="2">
				<!--
				<c:set var="subject" value="${fn:replace(fn:trim(vo.subject), '<', '&lt;')}"/>
				<c:set var="subject" value="${fn:replace(subject, '>', '&gt;')}"/>
				${subject}
				-->
				<input type="text" name="subject" value="${vo.subject}" size="55"/>
			</td>
			
			<!-- 공지글 수정 -->
			<td align="center">
				공지글
				<c:if test="${fn:trim(vo.notice) == 'notice'}"> <!-- 공지글인가? -->
					<input type="checkbox" name="notice" checked="checked"/>
				</c:if>
				<c:if test="${fn:trim(vo.notice) != 'notice'}"> <!-- 일반글인가? -->
					<input type="checkbox" name="notice" value="notice"/>
				</c:if>
			</td>
			
		</tr>
		
		<tr>
			<td>내용</td>
			<td colspan="3">
				<!--
				<c:set var="content" value="${fn:replace(fn:trim(vo.content), '<', '&lt;')}"/>
				<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"/>
				<c:set var="content" value="${fn:replace(content, enter, '<br/>')}"/>
				${content}
				-->
				<textarea rows="10" cols="65" name="content" style="resize: none;">${vo.content}</textarea>
			</td>
		</tr>
		
		<tr>
			<td colspan="4" align="center">
				<label>
					비밀번호 <input type="password" name="password"/>
				</label>
				<input type="submit" value="수정하기"/>
				<input type="reset" value="다시쓰기"/>
				<input type="button" value="돌아가기" onclick="history.back()"/>
				<!-- <input type="button" value="목록으로" onclick="history.go(-2)"/> -->
				<input type="button" value="목록으로" onclick="location.href='list.jsp?currentPage=${currentPage}'"/>
				
				<!-- hidden으로 수정할 글번호, 수정 후 돌아갈 페이지 번호를 폼에 넣어준다. -->
				<input type="hidden" name="idx" value="${vo.idx}"/>
				<input type="hidden" name="currentPage" value="${currentPage}"/>
				
			</td>
		</tr>
		
	</table>

</form>

</body>
</html>







