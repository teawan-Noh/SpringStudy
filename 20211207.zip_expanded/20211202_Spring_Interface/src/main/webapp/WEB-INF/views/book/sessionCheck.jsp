<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 확인</title>
</head>
<body>
   <fieldset>
      <legend>@SessionAttribute 확인</legend>
      <h1>${sessionScope.sessionAttribute_Test}</h1>   
   </fieldset>
   
   
   <fieldset>
      <legend>HttpSession 확인</legend>
      <h1>${sessionScope.HttpSession_Test}</h1>
   </fieldset>
   <br>
   <button value="01">같은 컨트롤러 sessionStatus.setComplete();</button>
   <button value="02">같은 컨트롤러 session.invalidate();</button>
   <button value="03">다른 컨트롤러 sessionStatus.setComplete();</button>
   <button value="04">다른 컨트롤러 session.invalidate();</button>

<script type="text/javascript">
   var btns = document.getElementsByTagName("button");
   for(let b in btns){
      btns[b].onclick = function(e){
         console.log(e.target.value);
         let val = e.target.value;
         location.href='./del'+val+'.do'
      }
   }
</script>

</body>
</html>