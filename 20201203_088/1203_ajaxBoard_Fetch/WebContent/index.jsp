<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="./css/bootstrap.css"/>
<script type="text/javascript" src="./js/bootstrap.js"></script>

<!-- fetch ajax가 지원되지 않는 브라우저(IE11)를 위해 아래 cdn 2줄을 추가한다. -->
<script src=https://cdn.jsdelivr.net/npm/promise-polyfill@8.1/dist/polyfill.min.js></script>
<script src=https://cdn.jsdelivr.net/npm/whatwg-fetch@3.0/dist/fetch.umd.min.js></script>
<!-- fetch-2.0.4.zip 파일을 압축을 풀고 fetch.js 파일을 fetch ajax 사용하기 위해 추가한다. -->
<script type="text/javascript" src="./js/fetch.js"></script>

<script type="text/javascript">

	var searchRequest = new XMLHttpRequest();
	var insertRequest = new XMLHttpRequest();

//	javascript ajax
	/*
	function searchFunction() {
		var url = './AjaxSearch?name=' + encodeURIComponent(document.getElementById('userName').value);
		searchRequest.open('post', url, true);
		searchRequest.onreadystatechange = searchProcess;
		searchRequest.send(null);
	}
	
	function searchProcess() {
		if (searchRequest.readyState == 4 && searchRequest.status == 200) {
			var table = document.getElementById('ajaxTable');
			table.innerHTML = '';
			var object = eval("(" + searchRequest.responseText + ")");		// 주의요망.....
			var result = object.result;
			for (var i = 0; i < result.length; i++) {
				var row = table.insertRow(0);
				for (var j = 0; j < result[i].length; j++) {
					var cell = row.insertCell(j);
					cell.innerHTML = result[i][j].value;
				}
			}
		}
	}
	*/
	
//	fetch ajax
	function searchFunction() {
		var url = './AjaxSearch?name=' + encodeURIComponent(document.getElementById('userName').value);
		fetch(url, {
			method: 'post'
		}).then(function(response) {
			response.text().then(function(text) {
				
				if (response.status == 200) {
					
					var table = document.getElementById('ajaxTable');
					table.innerHTML = '';
//					javascript ajax 요청을 받는 searchRequest.responseText 대신 response 객체에서 text() 함수로 얻어낸 text를 써준다.
					var object = eval("(" + text + ")");
					var result = object.result;
					for (var i = 0; i < result.length; i++) {
						var row = table.insertRow(0);
						for (var j = 0; j < result[i].length; j++) {
							var cell = row.insertCell(j);
							cell.innerHTML = result[i][j].value;
						}
					}
					
				} else {
					alert('전송 에러!!!');
				}
				
			});
		});
	}
	
	onload = function() {
		searchFunction();
	}

	function insertFunction() {
		var url = './AjaxInsert?name=' + encodeURIComponent(document.getElementById('name').value) +
								'&age=' + encodeURIComponent(document.getElementById('age').value) +
								'&gender=' + encodeURIComponent($('input[name=gender]:checked').val()) +
								'&email=' + encodeURIComponent(document.getElementById('email').value);
		insertRequest.open('post', url, true);
		insertRequest.onreadystatechange = insertProcess;
		insertRequest.send(null);
	}
	
	function insertProcess() {
		if (insertRequest.readyState == 4 && insertRequest.status == 200) {
			var result = insertRequest.responseText;
			if (result != 1) {
				alert('저장실패!!!');
			} else {
				var userName = document.getElementById("userName");
				var name = document.getElementById("name");
				var age = document.getElementById("age");
				var email = document.getElementById("email");
				userName.value = '';
				name.value = '';
				age.value = '';
				email.value = '';
				searchFunction();
			}
		}
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
					<button class="btn btn-primary pull-right" type="button" onclick="insertFunction()">입력</button>
				</td>
			</tr>
		</tbody>
	</table>
</div>

</body>
</html>














