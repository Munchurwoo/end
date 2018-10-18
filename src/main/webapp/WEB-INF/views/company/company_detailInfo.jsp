<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>${requestScope.cmvo.name} 기업의 상세정보</h3>
<div class="comtainer">
	<table class="table table-bordered">
		<thead>
			<tr>
			<th>아이디</th>
			<td>${requestScope.cmvo.companyId}</td>
			</tr>
			<tr>
			<th>이메일주소</th>
			<td>${requestScope.cmvo.email}</td>
			</tr>
			<tr>
			<th>회사명</th>
			<td>${requestScope.cmvo.name }</td>
			</tr>
			<tr>
			<th>회사 주소</th>
			<td>${requestScope.cmvo.address }</td>
			</tr>
			<tr>
			<th>연락처</th>
			<td>${requestScope.cmvo.tel }</td>
			</tr>
			<tr>
			<th>회사 소개</th>
			<td> ${requestScope.cmvo.introduction }</td>
			</tr>
			<tr>
			<th>기업 형태</th>
			<td>${requestScope.cmvo.companyType }</td>
			</tr>
			<tr>
			<th>업종</th>
			<td>${requestScope.cmvo.industry }</td>
			</tr>
			<tr>
			<th>매출액</th>
			<td>${requestScope.cmvo.sales }</td>
			</tr>
			<tr>
			<th>설립일</th>
			<td>${requestScope.cmvo.dateOfEstablishment }</td>
			</tr>
			<tr>
			<th>사원수</th>
			<td>${requestScope.cmvo.numOfEmployees }</td>
			</tr>
		</thead>
	</table>
	</div>
	<h2><a href="companyJobPostingList.do?companyId=${requestScope.cmvo.companyId}">${requestScope.cmvo.name} 님의 구인공고 바로가기</a></h2>