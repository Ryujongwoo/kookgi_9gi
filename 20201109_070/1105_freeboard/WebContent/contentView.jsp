<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>

<script type="text/javascript">

	function setting(idx, mode, title, name, content) {
		var frm = document.commentForm;		// 현재 문서의 댓글 작업 폼
		frm.idx.value = idx;				// 수정 또는 삭제할 댓글의 번호를 저장한다. 댓글 입력시는 0으로 처리한다.
		frm.mode.value = mode;				// 댓글 작업 모드를 지정한다. 1 => 저장, 2 => 수정, 3 => 삭제
		frm.commentBtn.value = title;		// submit 버튼에 표시될 텍스트를 지정한다.
		frm.name.value = name;				// 댓글 작성자 이름을 댓글 작업 폼의 text 객체에 넣어준다.
		
//		${list.get(i).content}를 넘겨받으면 javascript는 이스케이프 시퀀스(\r, \n)가 포함된 데이터를 인수로 받을 수 없기 때문에 함수가
//		정상적으로 작동되지 않는다.
//		일반적으로 자주 사용하지 않는 문자열이나 줄바꿈에 사용하는 <br/> 태그로 이스케이프 시퀀스를 치환시켜 javascript 함수로 데이터를 
//		전달하는데 넘어온 데이터를 textarea에 넣어주려면 다시 '\r\n'으로 치환시켜주는 작업이 필요하다.
		
//		java나 jsp의 replace 메소드는 모든 내용을 일괄적으로 치환하지만 javascript의 replace 함수는 맨 처음의 1개만 치환시킨다.
//		인수로 넘어온 데이터에 더 이상 '<br/>'이 나타나지 않을 때 까지 반복하며 '\r\n'으로 치환시켜야 한다.
		while (content.indexOf('<br/>') != -1) {
			content = content.replace('<br/>', '\r\n');
		}
		frm.content.value = content;		// 댓글 내용을 댓글 작업 폼의 textarea 객체에 넣어준다.
	}

</script>

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

<hr color="red" size="3"/>

<!-- 여기 부터 댓글 입력, 보기, 수정, 삭제에 사용하는 폼 -->
<form action="commentOK.jsp" method="post" name="commentForm">
	<table width="600" align="center" border="1" cellpadding="5" cellspacing="0">
	
		<!-- 이 줄은 원래 보이면 안되는 줄로 작업이 완료되면 모두 hidden으로 처리해서 보이지 않게 한다. -->
		<tr>
			<td bgcolor="yellow" colspan="4">
				idx : <input type="text" name="idx" value="${vo.idx}" size="1"/> <!-- 수정 또는 삭제할 댓글의 글번호를 넘겨준다. -->
				ref : <input type="text" name="ref" value="${vo.idx}" size="1"/> <!-- 현재 댓글이 어떤 메인글의 댓글인가 넘겨준다. -->
				mode : <input type="text" name="mode" value="1" size="1"/> <!-- 작업 모드, 1 => 댓글 저장, 2 => 댓글 수정, 3 => 댓글 삭제 -->
				currentPage : <input type="text" name="currentPage" value="${currentPage}" size="1"/> <!-- 메인글의 페이지 번호를 넘겨준다. -->
				ip : <input type="text" name="ip" value="${pageContext.request.remoteAddr}" size="8"/> <!-- 댓글 작성자 ip 주소를 넘겨준다. -->
			</td>
		</tr>
	
		<!-- 이 줄 부터 댓글 입력, 수정, 삭제에 사용된다. -->
		<!-- 댓글 입력, 수정, 삭제 폼 -->
		<tr>
			<td width="100" align="center">
				<label for="name">이름</label>
			</td>
			<td width="200">
				<input id="name" type="text" name="name"/>
			</td>
			<td width="100" align="center">
				<label for="password">비밀번호</label>
			</td>
			<td width="200">
				<input id="password" type="password" name="password"/>
			</td>
		</tr>
	
		<tr>
			<td width="100" align="center">
				<label for="content">내용</label>
			</td>
			<td width="500" colspan="3">
				<textarea id="content" rows="5" cols="60" name="content" style="resize: none;"></textarea>
			</td>
		</tr>
		
		<tr>
			<td align="center" colspan="4">
				<input type="submit" value="댓글저장" name="commentBtn"/>
				<input type="button" value="다시쓰기" onclick="setting(0, 1, '댓글저장', '', '')"/>
			</td>
		</tr>
	
		<!-- 댓글 목록 -->
		<!-- 댓글이 없는 경우 -->
		<c:if test="${freeboardCommentList.list.size() == 0}">
		<tr>
			<td colspan="4">
				<marquee>댓글이 하나도 없네요!!!!! 인기가 꽝이에요~~~~~~</marquee>
			</td>
		</tr>
		</c:if>
		
		<!-- 댓글이 있는 경우 -->
		<c:if test="${freeboardCommentList.list.size() != 0}">
		<!--
		<c:forEach var="comment" items="${freeboardCommentList.list}">
		<tr>
			<td colspan="4">
				${comment.idx}.
				<c:set var="name" value="${fn:replace(fn:trim(comment.name), '<', '&lt;')}"/>
				<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>
				${name}(${comment.ip})님이 
				<fmt:formatDate value="${comment.writeDate}" pattern="yyyy.MM.dd(E) HH:mm"/>에 남긴글<br/>
				<c:set var="content" value="${fn:replace(fn:trim(comment.content), '<', '&lt;')}"/>
				<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"/>
				<c:set var="content" value="${fn:replace(content, enter, '<br/>')}"/>
				${content}
			</td>
		</tr>
		</c:forEach>
		-->
		<c:set var="list" value="${freeboardCommentList.list}"/>
		<c:forEach var="i" begin="0" end="${list.size() - 1}" step="1">
		<tr>
			<td colspan="4">
				<%-- ${i + 1}. --%>
				${list.get(i).idx}
				<c:set var="name" value="${fn:replace(fn:trim(list.get(i).name), '<', '&lt;')}"/>
				<c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>
				${name}(${list.get(i).ip})님이 
				<fmt:formatDate value="${list.get(i).writeDate}" pattern="yyyy.MM.dd(E) HH:mm"/>에 남긴글<br/>
				<c:set var="content" value="${fn:replace(fn:trim(list.get(i).content), '<', '&lt;')}"/>
				<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"/>
				<c:set var="content" value="${fn:replace(content, enter, '<br/>')}"/>
				${content}<br/>
				
				<!-- javascript의 인수로 문자열을 넘길때는 반드시 따옴표로 묶어줘야 한다. -->
				<!-- javascript의 함수로 인수를 넘겨줄 때 이스케이프 시퀀스(\r, \n)가 포함된 문자열을 넘기면 함수가 동작되지 않는다. -->
				
				<input type="button" value="수정" onclick="setting(${list.get(i).idx}, 2, '댓글수정', '${list.get(i).name}', '${content}')"/>
				<input type="button" value="삭제" onclick="setting(${list.get(i).idx}, 3, '댓글삭제', '${list.get(i).name}', '${content}')"/>
				
			</td>
		</tr>
		</c:forEach>
		</c:if>
	
	</table>
</form>

</body>
</html>















