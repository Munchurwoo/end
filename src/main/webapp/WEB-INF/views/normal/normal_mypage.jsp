<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- normal_mypage -->

<script>
	function deleteNormalMember() {
		var delConfirm = confirm("${requestScope.nmvo.id}님 정말 회원 탈퇴를 하시겠습니까?");
		if(delConfirm == true) {
			location.href="deleteMember.do";
		} else {
			return;
		}
	}
</script>

<h3 align="center">${sessionScope.mvo.name }님 마이페이지</h3><br><br>
<div class="container">
<div class="col-sm-3"></div>
<div class="col-sm-6" style="text-align: center">
<table class="table table-hover">
  <tr>
    <th>아이디</th>
    <td>${requestScope.nmvo.id }</td>
  </tr>
   <tr>
    <th>이메일</th>
    <td>${requestScope.nmvo.email }</td>
  </tr>
  <tr>
    <th>이름</th>
    <td>${requestScope.nmvo.name }</td>
  </tr>
  <tr>
    <th>주소</th>
    <td>${requestScope.nmvo.address }</td>
  </tr>
  <tr>
    <th>연락처</th>
    <td>${requestScope.nmvo.tel }</td>
  </tr>
  <tr>
    <th>경력사항</th>
    <td>${requestScope.nmvo.careerStatus }</td>
  </tr>
  <tr>
    <th>성별</th>
    <td>${requestScope.nmvo.gender}</td>
  </tr> 
</table>
<button class="btn-1" onclick="javascript:location.href='updateNormalMemberForm.do'" style="height:40px; width:100px;">회원정보수정</button>
<c:choose>
<c:when test="${empty povo.title }">
<button class="btn-1" onclick="javascript:location.href='registerPortfolioForm.do'" style="height:40px; width:100px;">이력서등록</button>
</c:when>
<c:otherwise>
<button class="btn-1" onclick="javascript:location.href='normalDetailPortfolio.do?normalId=${requestScope.nmvo.id }'" style="height:40px; width:100px;">이력서보기</button>
</c:otherwise>
</c:choose>
<button class="btn-1" onclick="deleteNormalMember()" style="height:40px; width:100px;">회원탈퇴</button>
<button class="btn-1" onclick="javascript:location.href='getMyQuestionList.do?normalId=${requestScope.nmvo.id }'" style="height:40px; width:100px;">나의 질문 목록</button>
</div>
<div class="col-sm-3"></div>
</div>
