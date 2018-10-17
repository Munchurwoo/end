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
            url:"getDevCatVOListAjax.do",
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
      
      $("#pictureUploadBtn").change(function(){
         var form = $("#pictureUploadForm")[0];   
         var formData = new FormData(form);
         $.ajax({
            type:"post",
            url:"normalPictureUpload.do",
            data:formData,            
            enctype: 'multipart/form-data',
            processData: false,
              contentType: false,
              cache: false,
            success:function(path){
               $("#normal-picture").attr('src', "/GoodJob/resources/upload/"+path);
               //$("#pictureInput").val(path);
               alert(path);
               $("#aaa").append("<input type='hidden' name='picturePath' value='"+path+"'>");   
            }
         });
      });//change
      
      $("#registerBtn").click(function() {
         $("#registerForm").submit();

      });//click
      
      
   });//ready
</script>

<!-- normal_register_portfolio -->
<h3>이력서 작성</h3>
<form action="registerPortfolio.do" method="get" id="registerForm">
   제목 <input type="text" name="title" placeholder="제목을 입력하세요" required="required"><br>
   내용<br>&nbsp;&nbsp;&nbsp;<textarea rows="10" cols="60" name="content" placeholder="내용을 입력하세요" required="required"></textarea><br><br>
      
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
   </c:forEach> <br>
   
   <h5>모집직군</h5> 
   
      <c:forEach items="${requestScope.recruitCatList}" var="recruitCat" varStatus="i">
         <input type="checkbox" class = "recruit" name="recruitCatNumList" value="${recruitCat.rcNum}" >${recruitCat.rcName}  &thinsp;&thinsp;
         <c:if test="${(i.index+1)%3==0}"><br></c:if>
      </c:forEach>
      <input type="hidden" name="a" value="b">   
   <h5>개발분야</h5>
   <div id="empTypeArea">      
   </div>   
   <span id="aaa"></span>
   
   <button type="reset">초기화</button>   
</form >
<h5>사진등록</h5>
<form enctype="multipart/form-data" action="" id="pictureUploadForm">
 <div class="resume_photo">
   <a href="##" class="box_photo" data-api_type="layer" data-api_id="basic_photo" >
       <img id="normal-picture" src="" border="0" width="100" height="140" class="user_image" />s</a>
  <!--  <a class="photo_delete" href="##" style=""><span class="blind">사진 삭제</span></a> -->
</div>
<input type="file" name="uploadPicture" id="pictureUploadBtn"><br>

</form>


<button type="submit"  id="registerBtn">등록하기</button>
<button type="reset" onclick="location.href='home.do'">홈으로</button>   
