<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script type="text/javascript">	
	$(document).ready(function(){				
		$("input[name='recruitCatNumList']").change(function() {	
			$("#empTypeArea").html('');
			var dataString='';				
			$.ajax({
				type:"get",
				url:"user-getDevCatVOListAjax.do",
				dataType:"json",
				data:$("#updateForm").serialize(),
				success:function(catList){		
					var catListString='';
					for(var i=0; i<catList.length; i++){			
						for(var j=0; j<catList[i].length; j++){
							catListString += '<input type="checkbox" class = "recruit" name="devCatNumList" value="'+catList[i][j].devCatNum+'">'+catList[i][j].devCatName+'&nbsp;';
						}
						catListString+='<br>';
					}
					$("#empTypeArea").html($("#empTypeArea").html()+catListString);
				}//success					
			});//ajax 			
		});//change
		
		if(${requestScope.jpvo.jobPostingVO != null}) {
			$('input:checkbox[name="locCatNumList"]').each(function() {
				<c:forEach items="${requestScope.locCatList}" var="locCat">
					if(this.value == ${locCat.locNum}) {
						this.checked = true;
					}
				</c:forEach>
			});
		
			 $('input:radio[name="acaCatNumList"]').each(function() {
				<c:forEach items="${requestScope.acaCatList}" var="acaCat">
					if(this.value == ${acaCat.academicNum}) {
						$('input:radio[name="acaCatNumList"][value="${acaCat.academicNum}"]').prop('checked',true);
					}
			</c:forEach>
			});

			$('input:checkbox[name="empTypeCatNumList"]').each(function() {
				<c:forEach items="${requestScope.empTypeCatList}" var="empTypeCat">
					if(this.value == ${empTypeCat.empTypeNum}) {
						this.checked = true;
					}
				</c:forEach>
			});

			$('input:checkbox[name="recruitCatNumList"]').each(function() {
				<c:forEach items="${requestScope.recruitCatList}" var="recruitCat">
					if(this.value == ${recruitCat.rcNum}) {
						this.checked = true;
					}
				</c:forEach>
			}); 
		}
		
		
	});//ready
</script>

<h4 class="heading">
	<div class="cta-text">
		<h2>
			<span>GoodJob</span> 구인 공고 수정
		</h2>
	</div>
</h4>	
<form action="updateJobPosting.do" method="post" id="updateForm">
<div class="col-md-4"></div>
<div class="col-md-6" style="text-align: left">
	<h5>제목</h5><br> <input type="text" name="title" placeholder="${jpvo.jobPostingVO.title}" required="required"required="required" style="height:40px; width:400px;"><br>
	<h5>내용</h5><br><textarea rows="10" cols="60" name="content" placeholder="${jpvo.jobPostingVO.content}" required="required"></textarea><br><br>
		
	<h5>지역</h5>
	<c:forEach items="${requestScope.allLocCatList}" var="allLocCat" varStatus="i">
		<input type="checkbox" name="locCatNumList" value="${allLocCat.locNum}" >${allLocCat.locName}&nbsp;
	</c:forEach> <br>
	
	<h5>학력</h5>
	<c:forEach items="${requestScope.allAcaCatList}" var="allAcaCat" varStatus="i">	
		<input type="radio" name="acaCatNumList" value="${allAcaCat.academicNum}" required="required">${allAcaCat.academicName}&nbsp;
	</c:forEach> <br>
	
	<h5>고용형태</h5>
	<c:forEach items="${requestScope.allEmpTypeCatList}" var="allEmpTypeCat" varStatus="i">
		<input type="checkbox" name="empTypeCatNumList" value="${allEmpTypeCat.empTypeNum}" >${allEmpTypeCat.empTypeName}&nbsp;
	</c:forEach> 
	<input type="text" name="careerStatus" placeholder="ex)경력3년" required="required"><br>
	
	<h5>모집직군</h5> 
	
		<c:forEach items="${requestScope.allRecruitCatList}" var="allRecruitCat" varStatus="i">
			<input type="checkbox" class = "recruit" name="recruitCatNumList" value="${allRecruitCat.rcNum}" >${allRecruitCat.rcName}  &thinsp;&thinsp;
			<c:if test="${(i.index+1)%3==0}"><br></c:if>
		</c:forEach>
		<input type="hidden" name="a" value="b">	
	<h5>개발분야</h5>
	<div id="empTypeArea">		
	</div>

<div class="col-md-2"></div>	
<div class="col-md-12">	
		<button type="reset" style="height:50px; width:150px;background: #81BEF7;font-size: 20px">초기화</button>	
		<input type="hidden" name="companyId" value="${jpvo.companyId}" style="height:50px; width:150px;background: #81BEF7;font-size: 20px">
		<input type="hidden" name="jobPostingNum" value="${jpvo.jobPostingVO.jobPostingNum}" style="height:50px; width:150px;background: #81BEF7;font-size: 20px">
		<input type="submit" value="수정하기" style="height:50px; width:150px;background: #81BEF7;font-size: 20px">	
	</div>
</div>
</form>	




