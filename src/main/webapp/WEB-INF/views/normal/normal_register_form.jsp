<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- normal_register_form -->

<style>
.container {
  padding: 2px;
}
button,
button::after {
  -webkit-transition: all 0.3s;
    -moz-transition: all 0.3s;
  -o-transition: all 0.3s;
    transition: all 0.3s;
}
button {
  background: #81BEF7;
  border: 3px solid #fff;
  border-radius: 5px;
  font-size: 40px;
  font-weight: bold;
  ;
  position: relative;
  text-transform: uppercase;
}
button:hover {
  color: white;
}
/* BUTTON 1 */
.btn-1::after {
  height: 0;
  left: 0;
  top: 0;
  width: 100%;
}
.btn-1:hover:after {
  height: 100%;
}
.btn-2::after {
  height: 100%;
  left: 0;
  top: 0;
  width: 0;
}
.btn-2:hover:after {
  width: 100%;
}


</style>

<script type="text/javascript">
	$(document).ready(function () {
		var gender = "${requestScope.nmvo.gender }";
		var val;
		if(gender == "여") val="female";
		else val="male";
		$("input:radio[name='gender']:radio[value="+val+"]").prop("checked", true);
		
		var retFirVal = false;
		var retSecVal = false;
		
		var idCheckFlag = "";
		var idCheckBtnFlag = false;
		
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
		
		$("#id").keyup(function() {
			idCheckBtnFlag = false;
		});
		
		$("#checkId").click(function() {
			$.ajax({
				type:"get",
				url:"user-checkMemberId.do",	/* 181018 MIRI 'user-'로 변경 */
				data:"id="+$("#id").val(),
				success:function(result) {
					if(result == "ok") {
						idCheckFlag = "ok";
						$("#idView").text("사용 가능합니다.").css("color", "blue").css("font-weight", "bold");
					} else {
						idCheckFlag = "fail";
						$("#idView").text("이미 사용중인 아이디 입니다.").css("color", "red").css("font-weight", "bold");
						$("#id").focus();
					}
				}
			});
			idCheckBtnFlag = true;
		});
		
		$("#normalRegisterForm").submit(function() {
			if(retFirVal == false || retSecVal == false) {
				$("#checkPass").val("");
				$("#password").val("");
				$("#password").focus();
				$("#passwordView").text("비밀번호는 8~10자로 입력하세요.").css("color", "red").css("font-weight", "bold");
				$("#checkPassView").text(" ");
				return false;
			}
			
			if(idCheckFlag == "") {
				alert("아이디 중복체크를 해주시기 바랍니다.");
				$("#id").focus();
				return false;
			} else if(idCheckFlag == "fail") {
				alert("이미 사용중인 아이디입니다.");
				$("#id").val("");
				$("#id").focus();
				return false;
			} else if(idCheckBtnFlag == false) {
				alert("아이디를 다시 한 번 확인해 주세요.");
				$("#id").val("");
				$("#id").focus();
				$("#idView").text("아이디 중복체크를 해주시기 바랍니다.").css("color", "red").css("font-weight", "bold");
				return false;
			}
		});//submit
	});//ready
</script>

<form id="normalRegisterForm" action="user-registerNormalMember.do" method="post">
<div class="container">
	<div class="col-md-2"></div>
<div class="col-md-8" style="text-align: center">
  <button class="btn-1" onclick="javascript:location.href='user-registerNormalMemberForm.do'" style="height:80px; width:300px;">개인회원</button>
  <button class="btn-2" onclick="javascript:location.href='user-registerCompanyMemberForm.do'" style="height:80px; width:300px;">기업회원</button><br><br>	
	<div class="col-md-2"></div>
	</div>
	</div>
	<div class="container">
	<div class="col-md-3"></div>
	<div class="col-md-6" style="text-align: left; font-size: 20px; font-weight: bold; " >
	아이디  <br><input type="text" id="id" name="id" required="required" style="height:40px; width:400px;">
	<input type="button" id="checkId" value="중복체크" style="height:40px; width:100px;"><br>
	<span id="idView"> </span><br><br>
	비밀번호  <br><input type="password" id="password" name="password" required="required" style="height:40px; width:500px;"><br>
	<span id="passwordView"> </span><br><br>
	비밀번호 확인  <br><input type="password" id="checkPass" name="checkPass" required="required" style="height:40px; width:500px;"><br>
	<span id="checkPassView"> </span><br><br>
	이메일 주소  <br><input type="text" name="email" required="required" style="height:40px; width:500px;"><br><br>
	이름<br><input type="text" name="name" required="required" style="height:40px; width:500px;"><br><br>
	주소  <br><input type="text" name="address" required="required" style="height:40px; width:500px;"><br><br>
	연락처  <br><input type="text" name="tel" required="required" style="height:40px; width:500px;"><br><br>
	경력사항 <br> <input type="text" name="careerStatus" required="required" style="height:40px; width:500px;"><br><br>
	성별  <br>&nbsp;<input type="radio" name="gender" value="male" required="required">남자 
			    <input type="radio" name="gender" value="female" required="required">여자 
	<br><br>
	
	</div>
	  <div class="col-md-3"></div>
	</div>
	<div class="container" style="text-align: center">
	<input type="submit" value="회원가입" style="height:50px; width:150px;background: #81BEF7;font-size: 20px">
	</div>
</form>



