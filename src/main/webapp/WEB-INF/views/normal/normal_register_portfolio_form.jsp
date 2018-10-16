<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">	
	$(document).ready(function(){				
		$(".recruit").change(function() {	
			//alert(1);
			var recruitCatList = document.getElementsByName("recruitCatNumList");
			$("#empTypeArea").html('');
			for(var i=0; i<recruitCatList.length; i++){
				if(recruitCatList[i].checked){					
					//alert(j);
					$.ajax({
						type:"get",
						url:"getDevCatVOListAjax.do",
						dataType:"json",
						data:"rcNum="+recruitCatList[i].value,
						success:function(catList){		
							var catListString='';
							for(var i=0; i<catList.length; i++){											
								catListString += '<input type="checkbox" class = "recruit" name="devCatNumList" value="'+catList[i].devCatNum+'">'+catList[i].devCatName+'&nbsp;';								
							}							
							catListString+='<br>';						
							$("#empTypeArea").html($("#empTypeArea").html()+catListString);
						}//success					
					});//ajax
				}//if				
			}//for   			
		});//change
	});//ready
</script>

<!-- normal_register_portfolio -->
<h3>이력서 작성</h3>
<form action="registerPortfolio.do" method="get">
	제목 <input type="text" name="title" placeholder="제목을 입력하세요" required="required"><br>
	내용<br>&nbsp;&nbsp;&nbsp;<textarea rows="10" cols="60" name="contents" placeholder="내용을 입력하세요" required="required"></textarea><br><br>
		
	<h5>지역</h5>
	<c:forEach items="${requestScope.locCatList}" var="locCat" varStatus="i">
		<input type="checkbox" name="empTypeCatNumList" value="${locCat.locNum}" >${locCat.locName}&nbsp;
	</c:forEach> <br>
	
	<h5>학력</h5>
	<c:forEach items="${requestScope.acaCatList}" var="acaCat" varStatus="i">	
		<input type="radio" name="acaCatNumList" value="${acaCat.academicNum}" required="required">${acaCat.academicName}&nbsp;
	</c:forEach> <br>
	
	<h5>고용형태</h5>
	<c:forEach items="${requestScope.empTypeCatList}" var="empTypeCat" varStatus="i">
		<input type="checkbox" name="empTypeCatNumList" value="${empTypeCat.empTypeNum}" >${empTypeCat.empTypeName}&nbsp;
	</c:forEach> <br>
	
	<h5>모집직군</h5>
	<c:forEach items="${requestScope.recruitCatList}" var="recruitCat" varStatus="i">
		<input type="checkbox" class = "recruit" name="recruitCatNumList" value="${recruitCat.rcNum}" >${recruitCat.rcName}  &thinsp;&thinsp;
		<c:if test="${(i.index+1)%3==0}"><br></c:if>
	</c:forEach>
	
	<h5>개발분야</h5>
	<div id="empTypeArea">
		
	</div>
	<!-- recruitCatList 모집직군
	devCatList 개발분야
	empTypeCatList 고용형태
	locCatList 지역
	acaCatList 학력 -->
	<button type="submit" >등록하기</button>
	<button type="reset">초기화</button>
</form>
