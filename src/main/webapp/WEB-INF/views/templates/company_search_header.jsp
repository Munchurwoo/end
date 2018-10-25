<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	});//ready
</script>


<div class="row">
	<div class="col-lg-12">
		<div class="row">
			<h4 class="heading">
				<div class="cta-text">
					<h2>
						<span>채용정보 검색</span>
					</h2>
				</div>
			</h4>

<section id="featured">
	<!-- start slider -->
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<form action="user-company_detail_search_list.do" id="master">
	
		<h5>지역</h5>
	<c:forEach items="${requestScope.allLocCatList}" var="locCat" varStatus="i">
		<input type="checkbox" name="locCatNumList" value="${locCat.locNum}" >${locCat.locName}&nbsp;
	</c:forEach> <br>
	
	<h5>학력</h5>
	<c:forEach items="${requestScope.allAcaCatList}" var="acaCat" varStatus="i">	
		<input type="checkbox" name="acaCatNumList" value="${acaCat.academicNum}">${acaCat.academicName}&nbsp;
	</c:forEach> <br>
	
	<h5>고용형태</h5>
	<c:forEach items="${requestScope.allEmpTypeCatList}" var="empTypeCat" varStatus="i">
		<input type="checkbox" name="empTypeCatNumList" value="${empTypeCat.empTypeNum}" >${empTypeCat.empTypeName}&nbsp;
	</c:forEach>경력여부<input type="text" placeholder="ex)개발3년" id="recru"> <br>
	
	<h5>모집직군</h5> 
	
		<c:forEach items="${requestScope.allRecruitCatList}" var="recruitCat" varStatus="i">
			<input type="checkbox" class = "recruit" name="recruitCatNumList" value="${recruitCat.rcNum}" >${recruitCat.rcName}  &thinsp;&thinsp;
			<c:if test="${(i.index+1)%3==0}"><br></c:if>
		</c:forEach>
		<input type="hidden" name="a" value="b">	
	<h5>개발분야</h5>
	<div id="empTypeArea">		
	</div>	
	<button type="submit" >상세조건 검색하기</button>
	<button type="reset">초기화</button>
	<button type="reset" onclick="location.href='home.do'">홈으로</button>	
</form>
<br>
				<form action="user-findJobPostingByTitle.do" >
					<input type="radio" name="searchType" value="keyword">키워드 
					<input type="radio" name="searchType" value="title">제목
					<input type="text" name="searchText" required="required">
					<input type="submit" id="searchBtn" value="검색하기">
				</form>
			</div>
		</div>
	</div>
</section>

		</div>
	</div>
</div>