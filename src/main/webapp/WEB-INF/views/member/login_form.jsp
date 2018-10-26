<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- login_form -->

<h4 class="heading">
	<div class="cta-text">
		<h2>
			<span>GoodJob</span> 로그인
		</h2>
	</div>
</h4>	

<form action="user-login.do" method="post">
	<div class="container">
		<div class="col-sm-8" style="text-align: right">
			<input type="text" name="id" required="required" placeholder="아이디"
				style="height: 40px; width: 500px;"><br>
			<br> <input type="password" name="password" required="required"
				placeholder="비밀번호" style="height: 40px; width: 500px;"><br>
			<br> <a href="user-registerNormalMemberForm.do">회원가입</a> &nbsp;
			&nbsp; <a href="#">비밀번호를 잊으셨나요?</a>
		</div>
		<div class="col-sm-4" style="text-align: left">
			<input type="submit" value="로그인"
				style="height: 100px; width: 100px; background: #81BEF7; font-size: 20px">
		</div>
	</div>
</form>

<!-- <form class="form-horizontal" role="form">
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
		<div class="col-sm-10">
			<input type="email" class="form-control" id="inputEmail3"
				placeholder="Email">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="inputPassword3"
				placeholder="Password">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label> <input type="checkbox"> Remember me
				</label>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Sign in</button>
		</div>
	</div>
</form>
 -->