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
				data:$("#registerForm").serialize(),
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
	});//ready
</script>



<div class="col-md-4"></div>
<form action="registerJobPosting.do" method="get" id="registerForm">
<div class="col-md-6" style="text-align: left">
<h4 class="heading">
	<div class="cta-text">
		<h2>
			<span>GoodJob</span> 구인 공고 작성
		</h2>
	</div>
</h4>	
	<h5>제목</h5><br> <input type="text" name="title" placeholder="제목을 입력하세요" required="required" style="height:40px; width:400px;"><br>
	<h5>내용</h5><br><textarea rows="10" cols="60" name="content" placeholder="내용을 입력하세요" required="required"></textarea><br>	
	<h5>지역</h5>
	<c:forEach items="${requestScope.locCatList}" var="locCat" varStatus="i">
		<input type="checkbox" name="locCatNumList" value="${locCat.locNum}" >${locCat.locName}&nbsp;
	</c:forEach> <br>
	
	<h5>학력</h5>
	<c:forEach items="${requestScope.acaCatList}" var="acaCat" varStatus="i">	
		<input type="radio" name="acaCatNumList" value="${acaCat.academicNum}" required="required">${acaCat.academicName}&nbsp;
	</c:forEach> <br>
	
	<h5>고용형태</h5>
	<c:forEach items="${requestScope.empTypeCatList}" var="empTypeCat" varStatus="i">
		<input type="checkbox" name="empTypeCatNumList" value="${empTypeCat.empTypeNum}" >${empTypeCat.empTypeName}&nbsp;
	</c:forEach> 
	<input type="text" name="careerStatus" placeholder="ex)경력3년" required="required"><br>
	
	<h5>모집직군</h5> 
	
		<c:forEach items="${requestScope.recruitCatList}" var="recruitCat" varStatus="i">
			<input type="checkbox" class = "recruit" name="recruitCatNumList" value="${recruitCat.rcNum}" >${recruitCat.rcName}  &thinsp;&thinsp;
			<c:if test="${(i.index+1)%3==0}"><br></c:if>
		</c:forEach>
		<input type="hidden" name="a" value="b">	
	<h5>개발분야</h5>
	<div id="empTypeArea">		
	</div>	
		
		<div class="col-md-2"></div>
		<div class="col-md-12">
		<button type="reset"style="height:50px; width:150px;background: #81BEF7;font-size: 20px">초기화</button>	
		<input type="submit" value="등록하기"style="height:50px; width:150px;background: #81BEF7;font-size: 20px">
		</div>
		</div>
</form>	





