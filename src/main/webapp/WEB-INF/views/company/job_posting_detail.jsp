<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(document).ready(function(){	
	$("#detail").hide();
	var jobPostingNum=${jpvo.jobPostingVO.jobPostingNum};
	$("#registerQuestionBtn").click(function(){
		 $.ajax({
		type:"get",
		url:"registerQuestion.do",
		data:"question="+$("#questionArea").val()+"&jobPostingNum="+jobPostingNum,
		success:function(result) {
			$("#questionArea").val("");
			document.location.reload();
				}	
			})//ajax 
		})//click	
	})//ready
</script>
<h3>${jpvo.jobPostingVO.title }</h3>
<div class="container">
<table class="table table-bordered">
	<thead>	
	<tr>
	<h4>${jpvo.jobPostingVO.content}</h4>
	</tr>
	</thead>
	<tbody>
	
	<tr>
	<th>모집직군</th>
	<td>
	<c:forEach items="${recruitCatList}" var="recruitCatList">
		${recruitCatList.rcName}&nbsp;/&nbsp;
	</c:forEach>
	</td>
	</tr>
	
	<tr>
	<th>개발분야</th>
	<td>
	<c:forEach items="${devCatList }" var="devCatList">
		${devCatList.devCatName}&nbsp;/&nbsp;
	</c:forEach>
	</td>
	</tr>
	
	<tr>
	<th>고용형태</th>
	<td>
	<c:forEach items="${empTypeCatList}" var="empTypeCatList">
		${empTypeCatList.empTypeName }&nbsp;/&nbsp;
	</c:forEach>
	</td>
	</tr>
	
	<tr>
	<th>근무지역</th>
	<td>
	<c:forEach items="${locCatList }" var="locCatList">
		${locCatList.locName }&nbsp;/&nbsp;
	</c:forEach>
	</td>
	</tr>
	<tr>
	<th>학력</th>
	<td>
	<c:forEach items="${acaCatList }" var="acaCatList">
		${acaCatList.academicName }&nbsp;/&nbsp;
	</c:forEach>
	</td>
	</tr>
	
	<tr>
	<th>회사명</th>
	<td>
	${jpvo.name }
	</td>
	</tr>
	
	<tr>
	<th>회사소개</th>
	<td>
	${jpvo.introduction }
	</td>
	</tr>
	
	<tr>
	<th>업종</th>
	<td>
	${jpvo.industry }
	</td>
	</tr>

	<tr>
	<th>매출액</th>
	<td>
	${jpvo.sales } 만원
	</td>
	</tr>
	
	<tr>
	<th>설립일</th>
	<td>
	${jpvo.dateOfEstablishment }
	</td>
	</tr>
	
	<tr>
	<th>사원수</th>
	<td>
	${jpvo.numOfEmployees } 명
	</td>
	</tr>
	
	<tr>
	<th>주소</th>
	<td>
	${jpvo.address }
	</td>
	</tr>
	
	<tr>
	<th>전화번호</th>
	<td>
	${jpvo.tel }
	</td>
	</tr>
	
	<tr>
	<th>담당자이메일</th>
	<td>
	${jpvo.email }
	</td>
	</tr>
	</tbody>
</table>
</div>
	<div class="panel panel-default ">
	<c:forEach items="컨트롤러에서 받아온 객체" var="변수명">
		<div class="panel-heading accordion-toggle question-toggle collapsed"
			data-toggle="collapse" data-parent="#faqAccordion"
			data-target="#question${status.index }">
			<h4 class="panel-title">
				<a href="#" class="ing">Q: 질문데이터 출력</a>
			</h4>
		</div>
		<div id="question${status.index }" class="panel-collapse collapse"
			style="height: 0px;">
			<div class="panel-body">
				<h5>
					<span class="label label-primary">Answer</span>
				</h5>
				<p id="qaText${qavo.qaNum }">답변데이터 출력</p>
				<div id="buttonSubmit${qavo.qaNum }">	
					<button type="submit" id="answerCancel${qavo.qaNum }" style="visibility: hidden;">취소</button>
					<button type="submit" id="answerOK${qavo.qaNum }" style="visibility: hidden;">완료</button><br>
					<button type="submit" id="answerUpdate${qavo.qaNum }" >수정</button>
					<button type="submit" id="answerDelete${qavo.qaNum }" >삭제</button>
				</div>
			</div>
		</div>
		<script type="text/javascript">
		$(document).ready(function() {
			var answer = "${qavo.answer}";
			$("#answerUpdate"+${qavo.qaNum}).click(function() {
				var qanum = ${qavo.qaNum};
				var text = "<textarea rows=\"5\" cols=\"100\" id=\"qaTextArea"+qanum+"\">";
				if(answer == null) {
					text += "";
				} else {
					text += answer;
				}
				text += "</textarea>";
				$("#qaText"+qanum).html(text);
				$("#qaTextArea"+qanum).focus();
				document.getElementById('answerOK'+qanum).style.visibility = 'visible';
				document.getElementById('answerCancel'+qanum).style.visibility = 'visible';
				document.getElementById('answerUpdate'+qanum).style.visibility = 'hidden';
				document.getElementById('answerDelete'+qanum).style.visibility = 'hidden';
			});
			$("#answerDelete"+${qavo.qaNum}).click(function() {
				var qanum = ${qavo.qaNum};
				if(answer == null) {
					alert("답변이 아직 등록되지 않았습니다.");
					return false;
				}
				var delConfirm = confirm("정말 삭제하시겠습니까?");
				if(delConfirm == false) {
					return false;
				} else {
					$.ajax({
						type:"get",
						data:"QANum="+qanum,
						url:"deleteQAToAnswer.do",
						success:function(result) {
							if(result.answer == null) {
								alert("해당 답변이 삭제 되었습니다.");
								answer = result.answer;
								$("#qaText"+qanum).text(" ");
							}
						}
					});
				}
			});
			$("#answerOK"+${qavo.qaNum}).click(function() {
				var qanum = ${qavo.qaNum};
				$.ajax({
					type:"get",
					data:"QANum="+qanum+"&answer="+$("#qaTextArea"+qanum).val(),
					url:"updateQAToAnswer.do",
					success:function(result) {
						if(result.answer != null) {
							alert("해당 답변이 수정되었습니다.");
							$("#qaText"+qanum).text(result.answer);
							answer = result.answer;
							document.getElementById('answerOK'+qanum).style.visibility = 'hidden';
							document.getElementById('answerCancel'+qanum).style.visibility = 'hidden';
							document.getElementById('answerUpdate'+qanum).style.visibility = 'visible';
							document.getElementById('answerDelete'+qanum).style.visibility = 'visible';
						} else {
						}
					}
				});
			});
			$("#answerCancel"+${qavo.qaNum}).click(function() {
				var qanum = ${qavo.qaNum};
				$("#qaText"+qanum).html(answer);
				document.getElementById('answerOK'+qanum).style.visibility = 'hidden';
				document.getElementById('answerCancel'+qanum).style.visibility = 'hidden';
				document.getElementById('answerUpdate'+qanum).style.visibility = 'visible';
				document.getElementById('answerDelete'+qanum).style.visibility = 'visible';
			});
		})
		</script>
	</c:forEach>
</div>
	






<!-- 세션에 있는 회원이 normalMember 이면 면접신청 을 할수있는 기능을 추가하려고 함 -->
<c:choose>
	<c:when test="${sessionScope.mvo.memberType==1}">
	<form action="goInterviewApply.do?id=${sessionScope.mvo.id}">
	<input type="hidden" name="jobPostingNum" value="${jpvo.jobPostingVO.jobPostingNum}">
	<input type="submit" value="면접신청">
	</form>
	</c:when>
	<c:otherwise>
	<c:if test="${sessionScope.mvo.id==jpvo.companyId}">
	<form action="updateJobPostingForm.do">
	<input type="hidden" name="companyId" value="${jpvo.companyId}">
	<input type="hidden" name="jobPostingNum" value="${jpvo.jobPostingVO.jobPostingNum}">
	<input type="submit" value="수정하기">
	</form>	
	<br>
	<form action="deleteJobPosting.do">
	<input type="hidden" name="companyId" value="${jpvo.companyId}">
	<input type="hidden" name="jobPostingNum" value="${jpvo.jobPostingVO.jobPostingNum}">
	<input type="submit" value="삭제하기">
	</form>
	</c:if>
	</c:otherwise>
</c:choose>
<br>

<!-- 181020 MIRI 세션에 있는 회원이 직접 올린 구인 공고 글이면 면접 신청자 리스트를 볼 수 있음 (작억중) -->
	<c:if test="${sessionScope.mvo.id == requestScope.jpvo.companyId}">
		<form action="getJobPostingInterviewerList.do?jobPostingNum=${requestScope.jpvo.jobPostingVO.jobPostingNum}" method="post">
			<input type="submit" value="면접 신청자 리스트">
		</form>
		<br>
		<form action="getJobPostingQAList.do?jobPostingNum=${requestScope.jpvo.jobPostingVO.jobPostingNum}" method="post">
			<input type="submit" value="구인 공고 질답 리스트">
		</form>
	</c:if>

