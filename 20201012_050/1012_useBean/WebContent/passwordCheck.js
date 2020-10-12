	function passwordCheck(obj) {
		
		/*
//		입력한 비밀번호가 8자 이상 12자 이하인가 검사한다.
		len = obj.password.value.trim().length;		// 비밀번호에 입력한 글자수
		if (len < 8 || len > 12) {
			alert('비밀번호는 8자 이상 12자 이하로 입력해야 합니다.');
			obj.password.value = "";
			obj.password.focus();
			return false;
		}
		
//		영문자, 숫자, 특수문자가 각각 1개 이상 입력되었나 검사한다.
		alphaCount = 0;		// 영문자의 개수를 셀 변수
		numberCount = 0;	// 숫자의 개수를 셀 변수
		etcCount = 0;		// 특수문자의 개수를 셀 변수
//		입력된 비밀번호의 문자 개수만큼 반복하며 영문자, 숫자, 특수문자의 개수를 센다.
		pw = obj.password.value.trim();
		for (i = 0; i < len; i++) {
			if (pw.charAt(i) >= 'a' && pw.charAt(i) <= 'z' || pw.charAt(i) >= 'A' && pw.charAt(i) <= 'Z') {
				alphaCount++;
			} else if (pw.charAt(i) >= '0' && pw.charAt(i) <= '9') {
				numberCount++;
			} else {
				etcCount++;
			}
		}
//		alert('영문자: ' + alphaCount + '개\n숫자: ' + numberCount + '개\n특수문자: ' + etcCount + '개');
		console.log('영문자: ' + alphaCount + '개\n숫자: ' + numberCount + '개\n특수문자: ' + etcCount + '개');
		if (alphaCount == 0 || numberCount == 0 || etcCount == 0) {
			alert('비밀번호는 영문자, 숫자, 특수문자를 각각 1개 이상 입력해야 합니다.');
			obj.password.value = "";
			obj.password.focus();
			return false;
		}
		*/
		
		pw = obj.password.value.trim();
//		정규 표현식(정규식)을 사용한 영문자 대소문자, 숫자, 특수문자가 각각 1개 이상 입력되었고 8자 이상 12자 이하인가 검사한다.
//		new RegExp('정규식')
//		pattern = new RegExp('^.{8,12}$');				// 글자수 제한 => 8자 이상 12자 이하만 허용한다.
//		pattern = new RegExp('^.{8}$');					// 글자수 제한 => 무조건 8자만 허용한다.
//		pattern = new RegExp('^.{8,}$');				// 글자수 제한 => 8자 이상만 허용한다.
//		pattern = new RegExp('^.{1,8}$');				// 글자수 제한 => 8자 까지 허용한다.
//		pattern = new RegExp('^[0-9]{8,12}$');			// 글자수 제한, 숫자만 입력가능
//		pattern = new RegExp('^[A-Z]{8,12}$');			// 글자수 제한, 대문자만 입력가능
//		pattern = new RegExp('^[a-z]{8,12}$');			// 글자수 제한, 소문자만 입력가능
//		pattern = new RegExp('^[a-zA-Z]{8,12}$');		// 글자수 제한, 영문자만 입력가능
//		pattern = new RegExp('^[!@#$%^&*]{8,12}$');		// 글자수 제한, 특수문자 !@#$%^&*만 입력가능
//		pattern = new RegExp('^[0-9a-zA-Z!@#$%^&*]{8,12}$');

//		(?=.*[a-zA-Z])      => 영문자가 포함되어 있나 검사한다.
//		(?=.*[a-z])         => 영문자 소문자가 포함되어 있나 검사한다.
//		(?=.*[A-Z])         => 영문자 대문자가 포함되어 있나 검사한다.
//		(?=.*[0-9])         => 숫자가 포함되어 있나 검사한다.
//		(?=.*[!@#$%^&*])    => 특수문자 !@#$%^&* 중 하나 이상 포함되어 있나 검사한다.
//		[0-9a-zA-Z!@#$%^&*] => [] 안에 지정된 문자들로만 구성되어있나 검사한다.
		pattern = new RegExp('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[0-9a-zA-Z!@#$%^&*]{8,12}$');
		
//		test() 함수로 인수로 지정된 문자열이 정규식 패턴을 만족하는가 검사해서 만족하면 true, 만족하지 않으면 false를 리턴한다.
		if (!pattern.test(pw)) {
			alert('비밀번호는 8자 이상 12자 이하로 영문자 대소문자, 숫자, 특수문자를 1개 이상 입력해야 합니다.');
			obj.password.value = "";
			obj.password.focus();
			return false;
		}
		
//		입력한 두 개의 비밀번호가 같은가 검사한다.
		if (obj.password.value.trim() != obj.repassword.value.trim()) {
			alert('비밀번호가 일치하지 않습니다.');
			obj.password.value = "";
			obj.repassword.value = "";
			obj.password.focus();
			return false;
		}
		
		return true;
		
	}