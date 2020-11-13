<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="./css/bootstrap.css"/>
<script type="text/javascript" src="./js/bootstrap.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

//	서버와의 통신에 사용할 객체를 선언한다.
//	XMLHttpRequest : javascript object로 http를 통한 송수신을 지원해주는 객체
	var searchRequest = new XMLHttpRequest();

//	ajax 요청 함수
	function searchFunction() {
//		alert('searchFunction() 함수 실행');
//		alert(document.getElementById('userName').value);
		
//		XMLHttpRequest객체.open('요청방식', url, 동기방법)
//		동기방법 : 동기식 => false, 비동기식 => true
//		encodeURIComponent() : 문자열을 유니코드로 인코딩 한다.
//		decodeURIComponent() : encodeURIComponent() 함수로 인코딩한 문자열을 디코딩 한다.
		var url = './AjaxSearch?name=' + encodeURIComponent(document.getElementById('userName').value);
		searchRequest.open('post', url, true);
		
//		onreadystatechange : ajax 요청이 완료되면 실행할 콜백 함수를 지정한다.
		searchRequest.onreadystatechange = searchProcess;
		
//		send() : 서버에 요청한다.
		searchRequest.send(null);
	}
	
//	ajax 요청에 의해 처리된 결과를 받아서 화면에 출력하는 작업이 실행되는 함수
	function searchProcess() {
//		alert('나는야~~~ searchFunction() 함수에서 ajax가 완료되면 자동으로 실행하는 함수');
		
//		onreadystatechange로 지정한 콜백 함수의 readyState
//		0 : 실행되지 않음
//		1 : 로드 중
//		2 : 로딩 됨
//		3 : 통신 됨
//		4 : 통신 완료
//		console.log('readyState : ' + searchRequest.readyState);
		
//		onreadystatechange로 지정한 콜백 함수의 status
//		200 : 수신 성공
//		300 : 금지
//		400 : 페이지 없음
//		500 : 서버 오류
//		console.log('status : ' + searchRequest.status);

//		통신이 완료됨을 확인하고 필요한 작업을 실행한다.
		if (searchRequest.readyState == 4 && searchRequest.status == 200) {
//			console.log(searchRequest.responseText);

//			서블릿에서 수신한 데이터를 출력하기 위해 기존에 표시되던 데이터를 제거한다.
			var table = document.getElementById('ajaxTable');
			table.innerHTML = '';
			
//			서블릿에서 리턴된 문자열 데이터를 json 타입으로 변환하기 위해 괄호를 붙여서 받아 객체에 저장한다.
//			eval() : 인수로 지정된 문자열로 구성된 javascript를 실행한다.
			var object = eval("(" + searchRequest.responseText + ")");		// 주의요망.....
//			json 객체에서 result 라는 이름이 지정된 데이터를 얻어온다. => 화면에 출력할 데이터
			var result = object.result;
//			console.log(result);

//			검색되서 넘어온 데이터의 개수만큼 반복하며 테이블에 행을 만들어 추가한다.
			for (var i = 0; i < result.length; i++) {
//				<tbody> 태그에 넣어줄 행을 만든다.
				var row = table.insertRow(0);
//				한 행에 출력할 열의 개수만큼 반복하며 행에 열을 만들어 추가한다.
				for (var j = 0; j < result[i].length; j++) {
//					행에 넣어줄 열을 만든다.
					var cell = row.insertCell(j);
//					열에 화면에 표시될 데이터를 넣어준다.
					cell.innerHTML = result[i][j].value;
				} // for j
			}     // for i
		}         // if
		
	}             // searchProcess()
	
//	페이지가 로드되자마자 화면에 전체 데이터가 보여지게 하기 위해혀 onload 이벤트에서 searchFunction() 함수를 실행한다.
	onload = function() {
		searchFunction();
	}

</script>

</head>
<body>

<br/>
<div class="container">
	<div class="form-group row pull-right">
		<div class="col-xs-8">
			<input class="form-control" type="text" size="20" id="userName" onkeyup="searchFunction()"/>
		</div>
		<div class="col-xs-2">
			<button class="btn btn-primary" type="button" onclick="searchFunction()">검색</button>
		</div>
	</div>
</div>

<table class="table" align="center" style="text-align: center; border: 1px solid #dddddd">
	<thead>
		<tr>
			<th style="background-color: #fafafa; text-align: center;">번호</th>
			<th style="background-color: #fafafa; text-align: center;">이름</th>
			<th style="background-color: #fafafa; text-align: center;">나이</th>
			<th style="background-color: #fafafa; text-align: center;">성별</th>
			<th style="background-color: #fafafa; text-align: center;">이메일</th>
		</tr>
	</thead>
	<tbody id="ajaxTable">
		<tr></tr>
	</tbody>
</table>

<!-- 회원 가입 양식 추가 -->
<div class="container">
	<table class="table" align="center" style="text-align: center; border: 1px solid #dddddd">
		<thead>
			<tr>
				<th colspan="2" style="background-color: #fafafa; text-align: center;">회원 가입</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>이름</h5></td>
				<td>
					<input id="name" class="form-control" type="text" size="20"/>
				</td>
			</tr>
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>나이</h5></td>
				<td>
					<input id="age" class="form-control" type="text" size="20"/>
				</td>
			</tr>
			
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>성별</h5></td>
				<td>
					<div class="form-group" style="text-align: center; margin: 0 auto;">
						<!-- <div class="btn-group" data-toggle="buttons"> -->
							<label class="btn btn-primary active">
								<input type="radio" name="gender" value="남자" checked="checked" autocomplete="off">남자
							</label>
							<label class="btn btn-primary">
								<input type="radio" name="gender" value="여자" autocomplete="off">여자
							</label>
						<!-- </div> -->
					</div>
				</td>
			</tr>
			
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>이메일</h5></td>
				<td>
					<input id="email" class="form-control" type="text" size="20"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<button class="btn btn-primary pull-right" type="button">입력</button>
				</td>
			</tr>
		</tbody>
	</table>
</div>

</body>
</html>














