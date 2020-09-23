<%@page import="com.koreait.onLinePoll.PollWrite"%>
<%@page import="com.koreait.onLinePoll.PollRead"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- pollRead.jsp 투표한 항목을 넘겨받아 득표수를 증가시켜 텍스트 파일에 저장한다. -->
<%
//	post 방식으로 데이터가 넘어올 때 한글 깨짐을 방지한다.
	request.setCharacterEncoding("UTF-8");
//	pollRead.jap에서 넘어오는 투표 데이터를 받는다.
	String temp = request.getParameter("poll");
//	out.println(temp);

//	투표 데이터가 넘어왔나(null 이나 공백이 아닌가) 검사한다. => 반드시 null 검사를 먼저 한다.
	if (temp != null && temp.trim().length() != 0) {
		
//		넘어온 데이터가 숫자인가 검사한다.
		try {
			int result = Integer.parseInt(temp);
			
//			넘어온 투표 데이터가 숫자인 경우 정상적인 투표 범위의 데이터인가 검사하기 위해서 텍스트 파일을 읽어서 투표 항목의 개수를
//			계산한다.
			String filepath = application.getRealPath("/") + "poll.txt";
			ArrayList<String> poll = PollRead.pollRead(filepath);
			int itemCount = (poll.size() - 1) / 2;
			
//			넘어온 투표 데이터가 정상적인 투표 범위인가 검사한다.
			if (result >= 1 && result <= itemCount) {
				
//				여기까지 왔다는 것은 정상적인 투표 데이터가 넘어왔다는 것이므로 투표한 항목의 득표수를 증가시킨다.
//				득표수를 1증가 시킬 위치를 계산한다.
				int index = result + itemCount;
//				득표수를 증가시킨다. => ArrayList의 index 번째 데이터를 1증가 시킨다.
				result = Integer.parseInt(poll.get(index)) + 1;
//				증가된 득표수를 다시 ArrayList에 저장시킨다.
				poll.set(index, result + "");
				
//				ArrayList의 데이터를 텍스트 파일에 저장하는 메소드를 실행한다.
				PollWrite.pollWrite(filepath, poll);

//				투표 결과 보기 페이지로 넘겨준다.
				response.sendRedirect("pollResult.jsp");

			} else {
//				투표 데이터가 정상적인 투표 범위의 숫자가 아니므로 오류 메시지를 출력하고 pollRead.jsp로 돌려보낸다.
				out.println("<script>");
				out.println("alert('투표 데이터가 정상 투표 범위가 아닙니다.')");
				out.println("location.href='pollRead.jsp'");
				out.println("</script>");
			}
			
		} catch (NumberFormatException e) {
//			투표 데이터가 숫자가 아니므로 오류 메시지를 출력하고 pollRead.jsp로 돌려보낸다.
			out.println("<script>");
			out.println("alert('투표 데이터가 숫자가 아닙니다.')");
			out.println("location.href='pollRead.jsp'");
			out.println("</script>");
		}
		
	} else {
//		투표 데이터가 넘어오지 않았으므로 오류 메시지를 출력하고 pollRead.jsp로 돌려보낸다.
		out.println("<script>");
		out.println("alert('투표하세요~~~~~ 콱~~~~~')");
		out.println("location.href='pollRead.jsp'");
		out.println("</script>");
		
//		jsp는 서버용 스크립트 언어이고 javascript는 클라이언트용 스크립트 언어이다.
//		하나의 jsp 파일에 서버용 스크립트로 클라이언트용 스크립트를 모두 사용한 경우 서버용 스크립트가 먼저 다 실행되고 난 후 클라이언트용
//		스크립트가 실행된다. => 코딩 순서와 상관없다.
		
//		sendRedirect() : 인수로 지정된 페이지로 이동한다.		
//		response.sendRedirect("pollRead.jsp");
	}
%>

</body>
</html>















