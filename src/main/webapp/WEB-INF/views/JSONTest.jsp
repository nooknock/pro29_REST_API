<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<title>JSONTest</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>  
<script>
  $(function() {
      $("#checkJson").click(function() {
      	var member = { id:"hong", 
  			    name:"홍길동",
  			    pwd:"1234", 
  			    email:"hong@test.com" };
  	$.ajax({
        type:"post",
        url:"${contextPath}/test/info",
        contentType: "application/json",
        data :JSON.stringify(member),
     success:function (data,textStatus){
     },
     error:function(data,textStatus){
        alert("에러");
     },
     complete:function(data,textStatus){
     }
  });  //end ajax	

   });
});
</script>
</head>
<body>
  <input type="button" id="checkJson" value="클릭"/><br><br>
  <div id="output"></div>
</body>
</html>