<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP AJAX 회원가입</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="./css/bootstrap.css"/>
<link rel="stylesheet" href="./css/custom.css"/>
<script type="text/javascript" src="./js/bootstrap.js"></script>
<script type="text/javascript">

//	비밀번호 일치 체크 함수
	function passwordCheckFunction() {
		var userPassword1 = $('#userPassword1').val();
		var userPassword2 = $('#userPassword2').val();
		if (userPassword1 != userPassword2) {
			$('#passwordCheckMessage').html('비밀번호가 서로 일치하지 않습니다.');
		} else {
			$('#passwordCheckMessage').html('');
		}
	}

//	아이디 중복 체크 함수
	function registerCheckFunction() {
		var userID = $('#userID').val();
//		alert(userID);
		$.ajax({
			type: 'POST',					// 요청방식
			url: './UserRegisterCheck',		// 서블릿 이름
			data: {							// 서블릿으로 전송할 데이터
				userID: userID
			},
			success: function(result) {		// ajax 요청이 성공하면 실행할 함수
//				alert('연결 성공!!!');
//				alert(result);
//				switch 명령은 문자와 숫자를 구별하므로 result로 넘어오는 데이터가 문자열 데이터 이므로 case에서 문자열로 비교해야 한다.
				switch (result) {
					case '0':
//						alert('이미 존재하는 회원 아이디 입니다.');
						$('#idCheckMessage').html('사용할 수 없는 아이디 입니다.');
						$('#checkMessage').html('사용할 수 없는 아이디 입니다.');
						$('#checkType').attr("class", "modal-content panel-warning");
						break;
					case '1':
//						alert('가입 가능한 아이디 입니다.');
						$('#idCheckMessage').html('사용할 수 있는 아이디 입니다.');
						$('#checkMessage').html('사용할 수 있는 아이디 입니다.');
						$('#checkType').attr("class", "modal-content panel-success");
						break;
					case '2':
//						alert('아이디를 입력하고 중복체크 버튼을 클릭하세요');
						$('#idCheckMessage').html('아이디를 입력하고 중복체크 버튼을 클릭하세요');
						$('#checkMessage').html('아이디를 입력하고 중복체크 버튼을 클릭하세요');
						$('#checkType').attr("class", "modal-content panel-warning");
						break;
					default:
						$('#idCheckMessage').html('');
						break;
				}
				$('#checkModal').modal('show');
			},
			error: function(error) {		// ajax 요청이 실패하면 실행할 함수
				alert('에러 발생!!!');
			} 
		});
	}

</script>

</head>
<body>

<div class="container">
	<form action="./UserRegister" method="post">
		<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="3">
						<h4>회원 등록 양식</h4>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width: 110px;">
						<h5>아이디</h5>
					</td>
					<td>
						<input id="userID" class="form-control" type="text" name="userID" placeholder="아이디를 입력해주세요."/>
					</td>
					<td style="width: 110px;">
						<button class="btn btn-primary" type="button" onclick="registerCheckFunction()">중복체크</button>
					</td>
				</tr>
				<tr>
					<td style="width: 110px;">
						<h5>비밀번호</h5>
					</td>
					<td colspan="2">
						<input id="userPassword1" class="form-control" type="password" name="userPassword1" onkeyup="passwordCheckFunction()" 
							placeholder="비밀번호를 입력해주세요."/>
					</td>
				</tr>
				<tr>
					<td style="width: 110px;">
						<h5>비밀번호 확인</h5>
					</td>
					<td colspan="2">
						<input id="userPassword2" class="form-control" type="password" name="userPassword2" onkeyup="passwordCheckFunction()" 
							placeholder="비밀번호를 다시 한 번 입력해주세요."/>
					</td>
				</tr>
				<tr>
					<td style="width: 110px;">
						<h5>이름</h5>
					</td>
					<td colspan="2">
						<input id="userName" class="form-control" type="text" name="userName" placeholder="이름을 입력해 입력해주세요."/>
					</td>
				</tr>
				<tr>
					<td style="width: 110px;">
						<h5>나이</h5>
					</td>
					<td colspan="2">
						<input id="userAge" class="form-control" type="text" name="userAge" placeholder="나이를 입력해 입력해주세요."/>
					</td>
				</tr>
				<tr>
					<td style="width: 110px;">
						<h5>성별</h5>
					</td>
					<td colspan="2">
						
						<div class="form-group" style="text-align: center; margin: 0 auto">
							<!-- data-toggle 속성이 사용된 div 태그로 묶어주면 체크 상자 대신 버튼으로 표시된다. -->
							<div class="bth-group" data-toggle="buttons">
								<label class="btn btn-primary active">
									<!-- autocomplete="off" => 자동완성 기능 해제 -->
									<input type="radio" name="userGender" autocomplete="off" value="남자" checked="checked"/>남자
								</label>
								<label class="btn btn-primary">
									<input type="radio" name="userGender" autocomplete="off" value="여자"/>여자
								</label>
							</div>						
						</div>
						
					</td>
				</tr>
				<tr>
					<td style="width: 110px;">
						<h5>이메일</h5>
					</td>
					<td colspan="2">
						<input id="userEmail" class="form-control" type="email" name="userEmail" placeholder="이메일을 입력해 입력해주세요."/>
					</td>
				</tr>
				<tr>
					<td colspan="3" style="text-align: center;">
						<!-- 비밀번호 일치 검사 결과 메시지가 출력될 영역 -->
						<h5 id="passwordCheckMessage" style="color: red;"></h5>
						<h5 id="idCheckMessage" style="color: red;"></h5>
						<input class="btn btn-primary" type="submit" value="회원가입"/>
						<input class="btn btn-primary" type="reset" value="다시쓰기"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>

<%
//	메시지 출력
	String messageType = null;
	if (session.getAttribute("messageType") != null) {
 		messageType = (String) session.getAttribute("messageType");
		out.println("messageType : " + messageType + "<br/>");
	}
	String messageContent = null;
	if (session.getAttribute("messageContent") != null) {
		messageContent = (String) session.getAttribute("messageContent");
		out.println("messageContent : " + messageContent + "<br/>");
	}
	
	if (messageContent != null) {
%>
	
	<!-- 오류 메시지 모달 팝업창 -->
	<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-hidden="true">
		<!-- vertical-alignment-helper class는 bootstrap에 없으므로 만들어 사용한다. -->
		<div class="vertical-alignment-helper">
			<!-- vertical-align-center class는 bootstrap에 없으므로 만들어 사용한다. -->
			<div class="modal-dialog vertical-align-center">
			
				<!-- 모달 팝업 창의 종류를 설정한다. -->
				<!-- modal-content class에 스타일 추가 -->
				<div class="modal-content 
<%

				if (messageType.equals("오류 메시지")) {
					out.println("panel-warning");
				} else {
					out.println("panel-success");
				}

%>
				">
					<!-- 헤더 -->
					<div class="modal-header panel-heading">
						<!-- 헤더 왼쪽 'x' 버튼 -->
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span>
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">
							<%=messageType%>
						</h4>
					</div>
					<!-- 바디 -->
					<div class="modal-body">
						<%=messageContent%>
					</div>
					<!-- 풋터 -->
					<div class="modal-footer">
							<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
					</div>
				</div>
			
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$('#messageModal').modal('show');
	</script>

<%
//		세션에 저장된 정보를 지운다.
		session.removeAttribute("messageType");
		session.removeAttribute("messageContent");
	}
%>

	<!-- 로그인 메시지 모달 팝업창 => 위의 오류 메시지 모달 팝업창을 복사해서 수정한다. -->
	<!-- id 속성을 "checkModal"로 수정 -->
	<div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="vertical-alignment-helper">
			<div class="modal-dialog vertical-align-center">
				<!-- id 속성에 "checkType"을 추가, class 속성을 "modal-content panel-info"로 수정 -->
				<div id="checkType" class="modal-content panel-info">
					<div class="modal-header panel-heading">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span>
							<span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">
							아이디 중복 체크 확인 메시지
						</h4>
					</div>
					<!-- id 속성에 "checkMessage"를 추가 -->
					<div id="checkMessage" class="modal-body"></div>
					<div class="modal-footer">
							<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>










