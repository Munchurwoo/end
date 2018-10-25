<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
$(document).ready(function(){	
	$("input[name='recruitCatNumList']").change(function() {
		$("#empTypeArea").html('');
		var dataString='';				
		$.ajax({
			type:"get",
			url:"user-getDevCatVOListAjax.do",
			dataType:"json",
			data:$("#master").serialize(),
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
	$("#SearchBtn").click(function(){
			$("#master").submit();
	});

});//ready

</script>

<div class="cta-text">
	<h2>
		<span>채용 정보</span> 검색하기
	</h2>
</div>
<div class="container"
	style="padding-left: 120px; padding-right: 120px;">
	<form action="user-company_detail_search_list.do" method="get" id="master">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">지역</h3>
			</div>
			<div class="panel-body">
				<c:forEach items="${requestScope.allLocCatList}" var="locCat"
					varStatus="i">
					<input type="checkbox" id="locCatNumList" name="locCatNumList"
						value="${locCat.locNum}">${locCat.locName}&nbsp;
				</c:forEach>
			</div>
		</div>

		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">학력</h3>
			</div>
			<div class="panel-body">
				<c:forEach items="${requestScope.allAcaCatList}" var="acaCat"
					varStatus="i">
					<input type="checkbox" id="acaCatNumList" name="acaCatNumList"
						value="${acaCat.academicNum}" required="required">${acaCat.academicName}&nbsp;
	</c:forEach>
			</div>
		</div>

		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">고용 형태</h3>
			</div>
			<div class="panel-body">
				<c:forEach items="${requestScope.allEmpTypeCatList}" var="empTypeCat"
					varStatus="i">
					<input type="checkbox" name="empTypeCatNumList"
						id="empTypeCatNumList" value="${empTypeCat.empTypeNum}">${empTypeCat.empTypeName}&nbsp;
	</c:forEach>
			</div>
		</div>

		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">모집 직군</h3>
			</div>
			<div class="panel-body">
				<c:forEach items="${requestScope.allRecruitCatList}" var="recruitCat"
					varStatus="i">
					<input type="checkbox" class="recruit" name="recruitCatNumList"
						id="recruitCatNumList" value="${recruitCat.rcNum}">${recruitCat.rcName}  &thinsp;&thinsp;
			<c:if test="${(i.index+1)%3==0}">
						<br>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">개발 분야</h3>
			</div>
			<div class="panel-body">
				<input type="hidden" name="a" value="b">
				<div id="empTypeArea"></div>

			</div>
		</div>
		<span id="enter"></span>
	<div class="cta-text">
		<button type="reset" class="btn btn-default">초기화</button>

		<button type="submit" id="SearchBtn" class="btn btn-default">상세
			검색</button>
		<button type="reset" onclick="location.href='home.do'"
			class="btn btn-default" id="reset">홈으로</button>
	</div>
	</form>

	<div class="cta-text" id="row">
	<form action="user-findJobPostingByKeyword.do">
					<input type="text" name="keyword" required="required">
					<button type="submit" class="btn btn-primary">키워드로 검색하기</button>
				</form>
				</div>
</div>
<hr>