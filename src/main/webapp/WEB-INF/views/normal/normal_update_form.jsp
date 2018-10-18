<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- normal_update_form -->

<h3 align="center">회원 정보 수정</h3><br><br>

<script type="text/javascript">
	$(document).ready(function () {
		var gender = "${requestScope.nmvo.gender }";
		var val;
		if(gender == "여") val="female";
		else val="male";
		$("input:radio[name='gender']:radio[value="+val+"]").prop("checked", true);
		
		var retFirVal = false;
		var retSecVal = false;
		
		if($("#password").val() == "") {
			$("#passwordView").text("비밀번호는 8~10자로 입력하세요.").css("color", "red").css("font-weight", "bold");
			retFirVal = false;
		}
		
		$("#password").keyup(function() {
			if($(this).val()  == "") {
				$("#passwordView").text("비밀번호를 입력해주세요.").css("color", "red").css("font-weight", "bold");
				retFirVal = false;
			} else if($(this).val().length < 8 || $(this).val().length > 10) {
				$("#passwordView").text("비밀번호는 8~10자로 입력하세요.").css("color", "red").css("font-weight", "bold");
				retFirVal = false;
			} else if($(this).val().length >= 8 && $(this).val().length <= 10) {
				$("#passwordView").text("사용 가능한 비밀번호입니다.").css("color", "blue").css("font-weight", "bold");
				retFirVal = true;
			}
			
			if($("#checkPass").val() == "") {
				$("#checkPassView").text("비밀번호 확인 황목을 입력해주세요.").css("color", "red").css("font-weight", "bold");
				retSecVal = false;
			} else if($(this).val() != $("#checkPass").val()) {
				$("#checkPassView").text("비밀번호가 일치하지 않습니다.").css("color", "red").css("font-weight", "bold");
				retSecVal = false;
			} else if($(this).val() == $("#checkPass").val()) {
				$("#checkPassView").text("비밀번호가 일치합니다.").css("color", "blue").css("font-weight", "bold");
				retSecVal = true;
			}
		});
	
		$("#checkPass").keyup(function() {
			if($("#password").val() == "") {
				$("#checkPassView").text("비밀번호 항목을 먼저 입력해주세요.").css("color", "red").css("font-weight", "bold");
				retSecVal = false;
			} else if ($(this).val() == "") {
				$("#checkPassView").text("비밀번호 확인 황목을 입력해주세요.").css("color", "red").css("font-weight", "bold");
				retSecVal = false;
			} else if ($("#password").val() != $(this).val()) {
				$("#checkPassView").text("비밀번호가 일치하지 않습니다.").css("color", "red").css("font-weight", "bold");
				retSecVal = false;
			} else if($(this).val() == $("#password").val()){
				$("#checkPassView").text("비밀번호가 일치합니다.").css("color", "blue").css("font-weight", "bold");
				retSecVal = true;
			}
		});
		
		$("#normalUpdateForm").submit(function() {
			if(retFirVal == false || retSecVal == false) {
				$("#checkPass").val("");
				$("#password").val("");
				$("#password").focus();
				$("#passwordView").text("비밀번호는 8~10자로 입력하세요.").css("color", "red").css("font-weight", "bold");
				$("#checkPassView").text(" ");
				return false;
			}
		});
	});
</script>

<form id="normalUpdateForm" action="updateNormalMember.do" method="post">
	<div class="container">
	<div class="col-md-3"></div>
	<div class="col-md-6" style="text-align: left; font-size: 20px; font-weight: bold; " >
	아이디  <input type="text" value="${requestScope.nmvo.id }" name="id" readonly="readonly" style="height:40px; width:500px;"><br><br>
	비밀번호  <input type="password" id="password" name="password" required="required" style="height:40px; width:500px;"><br>
	<span id="passwordView"> </span><br><br>
	비밀번호 확인  <input type="password" id="checkPass" name="checkPass" required="required"style="height:40px; width:500px;"><br>
	<span id="checkPassView"> </span><br><br>
	이메일 주소  <input type="text" value="${requestScope.nmvo.email }" name="email" required="required"style="height:40px; width:500px;"><br><br>
	이름 <input type="text" value="${requestScope.nmvo.name }" name="name" required="required" style="height:40px; width:500px;"><br><br>
	주소  <input type="text" value="${requestScope.nmvo.address }" name="address" required="required"style="height:40px; width:500px;"><br><br>
	연락처  <input type="text" value="${requestScope.nmvo.tel }" name="tel" required="required"style="height:40px; width:500px;"><br><br>
	경력사항  <input type="text" value="${requestScope.nmvo.careerStatus }" name="careerStatus" required="required"style="height:40px; width:500px;"><br><br>
	<%--
				사진경로 에러
	 사진경로 * <input type="text" value="${requestScope.nmvo.picturePath }" name="picturePath" required="required"><br><br> --%>
	성별 <br><br>
	<input type="radio" name="gender" value="male" required="required">남자 &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="radio" name="gender" value="female" required="required">여자<br><br>
	</div>
	<div class="col-md-3"></div>
	</div>
	<div class="container" style="text-align: center">
	<input type="submit" value="회원정보수정"  style="height:50px; width:150px;background: #81BEF7;font-size: 20px">
	</div>
</form>
