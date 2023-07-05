<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HYPE MUSIC 회원가입</title>
</head>
<link rel="stylesheet" href="/signup.css">
<body>
	<div id="wrap">
		<header class="pageHeader">
			<a href="http://localhost:8081/" class="logo"> <img width="180px"
				height="100px" src="/img/logo_ex.jpg">
			</a>
		</header>
		<form id="boxes" method="post" action="doSignup">
			<input type="hidden" id="isJsEnabled" name="jsCheck" value="">
			<div id="inputGroup">
				<div id="input">
					<div class="label-wrapper">
						<label for="id" id="lb">아이디</label><br>
					</div>
					<input type="text" name="id"><br>
					<div class="notice">영문과 숫자를 하나 이상 포함하는 4자리 이상 16자리 이하여야 합니다.</div>
				</div>
				<div id="input">
					<div class="label-wrapper">
						<label for="pw" id="lb">비밀번호</label><br>
					</div>
					<input type="password" name="pw"><br>
					<div class="notice">비밀번호는 영문, 숫자, 특수문자를 최소 한 글자 이상 포함하는</div>
					<div class="notice">8~16자여야 합니다.</div>
				</div>
				<div id="input">
					<div class="label-wrapper">
						<label for="pw-confirm" id="lb">비밀번호 확인</label><br>
					</div>
					<input type="password" name="pw-confirm"><br>
				</div>
				<div id="input">
					<div class="label-wrapper">
						<label for="name" id="lb">이름</label><br>
					</div>
					<input type="text" name="name"><br>
					<div class="notice">한글과 영문으로 이루어진 2자리 이상 30자리 이하여야합니다.</div>
				</div>
				<div id="input">
					<div class="label-wrapper">
						<label for="email" id="lb">이메일</label><br>
					</div>
					<input type="text" name="email"><br>
				</div>
				<br> <br>
				<div id="input">
					<input type="button" id="submit" value="회원가입">
				</div>
			</div>
		</form>
	</div>
	<!-- SHA-256 알고리즘 cryptoJS 라이브러리 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.0.0/crypto-js.min.js"></script>
	<script>
		document.querySelector("#submit").onclick = () => {
			/* 이름 */
			/* 이름 정규식 : 한글과 영문을 입력받고 공백은 입력가능하지만
			   연속된 공백 입력을 금지하는 2자리 이상 30자리 이하 */
			const name = document.querySelector('input[name="name"]').value.trim();
			const nameRegex = /^(?!\\s+$)[가-힣a-zA-Z\\s]{2,30}$/;
			
			/* 아이디 */
			/* id 정규식 : 영문과 숫자로만 이루어진 4자리 이상 16자리 이하 */
			const id = document.querySelector('input[name="id"]').value.trim();
			const idRegex = /^(?=.*[a-zA-Z0-9])[a-zA-Z0-9]{4,16}$/;
			
			/* 비밀번호 */
			/* 영문,숫자,특수문자 최소 하나씩 포함하는 최소 8자리 이상 16자리 이하인 정규식 */
			const pw = document.querySelector('input[name="pw"]').value.trim();
			const pw_confirm = document.querySelector('input[name="pw-confirm"]').value.trim();
			const pwRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*\W)(?!.*\s).{8,16}$/;
			
			/* 이메일 */
			/* 이메일 정규식 */
			const email = document.querySelector('input[name="email"]').value.trim();
			const emailRegex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
			
			/* 비밀번호 암호화 */
			/* 자바스크립트에서 암호화 시킨 뒤 암호화된 비밀번호를
			   자바에서 한 번 더 암호화 시켜 저장하기 위함 */
			const hashedPW = CryptoJS.SHA256(pw).toString();
			
			if (name.length === 0) {
				alert("이름을 입력해주세요.");
				event.preventDefault();
			} else if (!name.match(nameRegex)) {
				alert("유효하지 않은 입력입니다.");
				event.preventDefault();
			} else if (id.length === 0) {
				alert("아이디를 입력해주세요.");
				event.preventDefault();
			} else if (!id.match(idRegex)) {
				alert("유효하지 않은 입력입니다.");
				event.preventDefault();
			} else if (pw.length === 0) {
				alert("비밀번호를 입력해주세요.");
				event.preventDefault();
			} else if (!pw.match(pwRegex)) {
				alert("유효하지 않은 입력입니다.");
				event.preventDefault();
			} else if (pw !== pw_confirm) {
				alert("비밀번호가 일치하지 않습니다.");
				event.preventDefault();
			} else if (email.length === 0){
				alert("이메일을 입력해주세요.");
				event.preventDefault();
			} else if (!email.match(emailRegex)) {
				alert("유효하지 않은 입력입니다.");
				event.preventDefault();
			}
			
			document.querySelector("#boxes").onsubmit = () => {
				document.querySelector('input[name="pw"]').value = hashedPW;
			}
		}
	</script>

	<footer id="footer">
		<div class="copyright">ⓒ HMC HypeMusicStudio Corp. All rights
			reserved.</div>
	</footer>
</body>
</html>