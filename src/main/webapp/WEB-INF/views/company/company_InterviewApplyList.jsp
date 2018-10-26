<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	$(document).ready(function(){
		$(".checkContent").parent().next().hide();
		$(".checkContent").click(function() {
			$(this).parent().next().toggle();	
		});
	});//ready
</script>

<div class="container">

<table class="table table-bordered">
<tbody>
<tr>
	<th>접수번호</th><th>제목</th><th>접수자</th>	
</tr>

<c:forEach items="${requestScope.interviewerList}" var="ivList">
<tr>
	<td>${ivList.interviewNum}</td>
	<td class="checkContent"><a href="#">${ivList.title}</a></td>
	<td>${ivList.normalMemberVO.name}</td>
</tr>
<tr>
	<td></td>
	<td colspan="2" class="toggle">	
	${ivList.content}<br>
	<a href="normalDetailPortfolio.do?normalId=${ivList.normalMemberVO.normalId}">이력서 열람하기</a>
	</td>
	
</tr>
</c:forEach>


</tbody>	
</table>
</div>
 --%>