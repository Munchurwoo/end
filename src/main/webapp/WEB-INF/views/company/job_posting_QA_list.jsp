<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-lg-12">
		<div class="row">
			<h4 class="heading">
				<div class="cta-text">
					<h2>
						<span>GoodJob</span> 질답 리스트
					</h2>
				</div>
			</h4>
			<div class="panel-group" id="faqAccordion">
				<c:forEach items="${requestScope.qavo }" var="qavo" varStatus="status">
					<div class="panel panel-default ">
						<div
							class="panel-heading accordion-toggle question-toggle collapsed"
							data-toggle="collapse" data-parent="#faqAccordion"
							data-target="#question${status.index }">
							<h4 class="panel-title">
								<a href="#" class="ing">Q: ${qavo.question }</a>
							</h4>
						</div>
						<div id="question${status.index }" class="panel-collapse collapse"
							style="height: 0px;">
							<div class="panel-body">
								<h5>
									<span class="label label-primary">Answer</span>
								</h5>
								<p id="qaText${qavo.qaNum }">${qavo.answer}</p>
								<div id="buttonSubmit${qavo.qaNum }">	
									<button type="submit" id="answerCancel${qavo.qaNum }" style="visibility: hidden;">취소</button>
									<button type="submit" id="answerOK${qavo.qaNum }" style="visibility: hidden;">완료</button><br>
									<button type="submit" id="answerUpdate${qavo.qaNum }" >수정</button>
									<button type="submit" id="answerDelete${qavo.qaNum }" >삭제</button>
								</div>
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
		</div>
	</div>
</div>
