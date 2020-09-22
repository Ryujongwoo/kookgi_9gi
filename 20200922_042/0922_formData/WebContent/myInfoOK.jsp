<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

myInfoOK.jsp 입니다.<br>

<!-- myInfo.jsp에서 전송되는 데이터를 받는다. -->
<%
//	form에 입력된 데이터가 post 방식으로 전송될 때 한글이 깨지는 현상을 방지한다.
//	한글 깨짐을 방지하려면 최초의 request.getParameter()가 실행되기 전에(맨 처음에) 아래의 내용을 코딩하면 된다.
	request.setCharacterEncoding("UTF-8");

//	get 방식도 한글이 깨졌었다. => tomcat server 7.0 부터 get 방식을 사용할 때 한글이 깨지지 않고 처리된다.
//	get 방식에서 한글이 깨지지 않고 하려면 서버에서 한글이 깨지지 않도록 설정해야 한다.
//	Servers 폴더의 server.xml 파일을 열고 64번 줄의 Connector 태그에 URIEncoding="UTF-8" 속성을 추가하면 get 방식에서 한글이 깨지지 않는다.

//	request.getParameter() : 이전 페이지에서 submit 버튼이 클릭되서 넘어오는 데이터를 무조건 문자열로 받는다.
	String name = request.getParameter("name");
	out.println(name + "님 안녕하세요<br>");
	String id = request.getParameter("id");
	out.println(name + "님(" + id + ") 안녕하세요<br>");
	String password = request.getParameter("password");
	out.println(name + "님(" + id + ")의 비밀번호는 " + password + " 입니다.<br>");
	
	try {
		int age = Integer.parseInt(request.getParameter("age"));
		out.println(name + "님은 " + age + "살 입니다.<br>");
		out.println(name + "님은 내년에 " + (age + 1) + "살 입니다.<br>");
	} catch (NumberFormatException e) {
		out.println("잘못된 나이가 입력되었습니다.<br>");
		out.println("<script>");
		out.println("alert('잘못된 나이가 입력되었습니다.')");
		out.println("</script>");
	}
	
	boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
	out.println(name + "님은 " + (gender ? "남자" : "여자") + " 입니다.<br>");
	
//	String hobbies = request.getParameter("hobbies");
//	out.println(name + "님의 취미는 " + hobbies + " 입니다.<br>");
	
//	checkbox는 여러 항목을 선택할 수 있는데 위와 같이 getParameter() 메소드를 이용해서 받으면 맨 처음 선택한 값 한 개만 받을 수 있다.
//	checkbox에서 넘어오는 데이터를 받을 때는 넘어오는 ㅎ아목이 여러개일 수 있기 때문에 getParameterValues() 메소드로 받아서 배열에
//	저장시켜 처리해야 한다.
	String[] hobbies = request.getParameterValues("hobbies");
	out.println(name + "님의 취미는 ");
	try {
		for (int i = 0; i < hobbies.length; i++) {
			out.println(hobbies[i] + " ");
		}
		out.println("입니다.<br>");
	} catch (NullPointerException e) {
		out.println("없어요.... 저는 공부밖에 안해서...<br>");
	}
	
	String trip = request.getParameter("trip");
	out.println(name + "님은 " + trip + "에 가고싶어합니다.<br>");

	String[] travel = request.getParameterValues("travel");
	out.println(name + "님은 ");
	try {
		for (int i = 0; i < travel.length; i++) {
			out.println(travel[i] + " ");
		}
		out.println("에 가고싶어합니다.<br>");
	} catch (NullPointerException e) {
		out.println("없어요.... 역병이 돌고있는데 가기는 어딜가요...<br>");
	}
	
	String content = request.getParameter("content");
//	태그 사용 가능, 줄바꿈 불가능
//	out.println(name + "님이 남긴말<br>" + content + "<br>");
//	태그 사용 불가능, 줄바꿈 불가능
//	out.println(name + "님이 남긴말<br>" + content.replace("<", "&lt;").replace(">", "&gt;") + "<br>");
//	태그 사용 가능, 줄바꿈 가능
//	out.println(name + "님이 남긴말<br>" + content.replace("\r\n", "<br>") + "<br>");
//	태그 사용 불가능, 줄바꿈 가능
	out.println(name + "님이 남긴말<br>" + content.replace("<", "&lt;").replace(">", "&gt;").replace("\r\n", "<br>") + "<br>");
%>



<a href="myInfo.jsp">돌아가기</a>

</body>
</html>

















