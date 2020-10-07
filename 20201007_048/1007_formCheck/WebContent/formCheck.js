//	javascript 함수의 형식
//	function 함수이름([인수, ...]) {
//		함수가 실행할 문장;
//		...;
//		[return 값;]
//	}

//	이벤트가 실행되는 객체에 최대 글자수 만큼의 문자가 입력되면 포커스를 넘겨줄 객체로 포커스를 넘겨주는 함수
//	moveNext(이벤트가 실행되는 객체, 최대 글자수, 포커스를 넘겨줄 객체)
	function moveNext(obj, len, nextObj) {
//		alert("moveNext() 함수가 실행됨");
//		value : 객체에 입력된 데이터, 객체의 value 속성으로 지정된 데이터
//		alert(obj.value);
//		value를 if 조건으로 사용하면 데이터가 입력되어 있으면 true, 그렇치 않으면 false를 의미한다.
//		length : 객체에 입력된 문자의 개수를 얻어온다.
		if (obj.value.length == len) {
			nextObj.focus();
		}
	}

//	인수로 넘어온 폼의 유효성을 검사하고 정상이면 true를 리턴하고 오류가 발생되면 오류 메시지를 출력하고 false를 리턴하는 함수
//	formCheck(유효성 검사를 실행할 폼)
	function formCheck(obj) {
//		obj로 this(폼)가 넘어오므로 obj에는 document.juminForm이 저장된다.
		
//		주민등록번호 앞 자리에 아무것도 입력되지 않았나 검사해서 입력되지 않았으면 메시지를 출력한 후 false를 리턴시킨다.
		if (!obj.jumin1.value || obj.jumin1.value.trim().length == 0) {
			alert("주민등록번호 앞 자리를 입력하세요!!!");
			obj.jumin1.value = "";
			obj.jumin1.focus();
			return false;
		}
		
//		주민등록번화 앞 자리에 6글자가 입력되었나 검사해서 입력되지 않았으면 메시지를 출력한 후 false를 리턴시킨다.
		if (obj.jumin1.value.trim().length != 6) {
			alert("주민등록번호 앞 자리는 6글자를 입력하세요!!!");
			obj.jumin1.value = "";
			obj.jumin1.focus();
			return false;
		}
		
//		주민등록번화 앞 자리에 숫자만 입력되었나 검사해서 숫자만 입력되지 않았으면 메시지를 출력한 후 false를 리턴시킨다.
//		Number() => 인수로 지정된 문자열을 숫자로 변환한다.
//		isNaN()  => NaN(Not a Number), 인수로 지정된 데이터가 숫자가 아니면 true, 숫자면 false를 리턴한다.
		if (isNaN(Number(obj.jumin1.value.trim()))) {
			alert("주민등록번호 앞 자리는 숫자만 입력하세요!!!");
			obj.jumin1.value = "";
			obj.jumin1.focus();
			return false;
		}
	
//		주민등록번호 뒷 자리를 검사한다.
		if (!obj.jumin2.value || obj.jumin2.value.trim().length == 0) {
			alert("주민등록번호 뒷 자리를 입력하세요!!!");
			obj.jumin2.value = "";
			obj.jumin2.focus();
			return false;
		}
		if (obj.jumin2.value.trim().length != 7) {
			alert("주민등록번호 뒷 자리는 7글자를 입력하세요!!!");
			obj.jumin2.value = "";
			obj.jumin2.focus();
			return false;
		}
		if (isNaN(Number(obj.jumin2.value.trim()))) {
			alert("주민등록번호 뒷 자리는 숫자만 입력하세요!!!");
			obj.jumin2.value = "";
			obj.jumin2.focus();
			return false;
		}
		
//		여기까지 왔다는 것은 주민등록번호가 13자리의 숫자가 입력되었다는 의미이다. => 주민등록번호 유효성 검사를 실행한다.
//		주민등록번호 유효성 검사를 하기 위해 따로 입력된 주민등록번호를 하나의 문자열로 합친다.
		jumin = obj.jumin1.value.trim() + obj.jumin2.value.trim();	// 문자열 연결
		
//		javascript는 숫자로만 구성된 문자열을 사칙연산을 할 경우 덧셈을 하는 경우는 문자열을 이어주지만 덧셈을 제외한 나머지 연산은 지가 알아서
//		숫자로 변환시킨 후 연산을 한다.
//		jumin = Number(obj.jumin1.value.trim()) + Number(obj.jumin2.value.trim());	// Number() 함수로 숫자로 바꾼 다음에 더해야 한다.
//		jumin = obj.jumin1.value.trim() - obj.jumin2.value.trim();
//		jumin = obj.jumin1.value.trim() * obj.jumin2.value.trim();
//		jumin = obj.jumin1.value.trim() / obj.jumin2.value.trim();
//		jumin = obj.jumin1.value.trim() % obj.jumin2.value.trim();
//		alert(jumin);
//		alert() 함수를 사용하면 메시지 창에서 일일히 닫아주는 작업을 해야하므로 console.log()를 사용해 개발자 모드의 colsole 창에 출력해서
//		연산의 중간 결과값을 확인할 수 있다.
		console.log(jumin);
		
//		주민등록번호 유효성을 검사한다. 가중치 => 234567892345, 둘리 주민등록번호 => 8304221185600 => 가중치와 곱해서 더하면 143
		sum = 0;
		for (var i = 0; i < 12; i++) {
//			sum += jumin.charAt(i) * (i < 8 ? i + 2 : i - 6);
			sum += jumin.charAt(i) * (i % 8 + 2);
		}
		console.log(sum);
		
//		sum에 저장된 값을 11로 나눈 나머지를 11에서 뺀 결과가 주민등록번호의 마지막 자리와 같아야 한다.
//		11로 나눈 나머지를 11에서 뺀 결과가 10 이상일 경우 10자리는 버려야 하므로 10으로 나눈 나머지와 주민등록번호의 마지막 자리를 비교한다.
		result = (11 - sum % 11) % 10;
		console.log(result);
		
//		"=="와 "!="는 데이터만 대충 비교한다. => 문자를 알아서 숫자로 바꿔 비교한다. => "1"와 1는 같은 데이터로 취급한다.
//		"==="와 "!=="는 데이터와 자료형을 모두 비교한다. => "1"와 1는 다른 값으로 취급한다.
		
		if (result !== Number(jumin.charAt(12))) {
			alert("주민등록번호가 올바르지 않습니다. 넌 누구냐~~~~~~~");
			obj.jumin1.value = "";
			obj.jumin2.value = "";
			obj.jumin1.focus();
			return false;
		}
		
//		모든 오류 체크를 무사히 통과하면 마지막에 true를 리턴시킨다.
		return true;
	}