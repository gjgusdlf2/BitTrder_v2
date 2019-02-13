<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/employee/register.css" />
<div class="grid-item" id= "side_bar">
<h1>회원가입</h1>
</div>
<div class="grid-item" id= "content">
<form id="form" >
<div id="register-container">
	<div class="input-group">
	  <span class="input-group-addon" id="basic-addon1">아이디 </span>
	  <input type="text" id="customer_id" name="customer_id" class="form-control" placeholder="4자리이상 알파벳,숫자" aria-describedby="basic-addon1">
	</div><br />
	<div class="input-group">
	  <span class="input-group-addon" id="basic-addon1">비밀번호</span>
	  <input type="text" id="password" name="password"  class="form-control" placeholder="무조건 1" aria-describedby="basic-addon1">
	</div><br />
	<div class="input-group">
	  <span class="input-group-addon" id="basic-addon1" >이 름</span>
	  <input type="text" id="customer_name" name="customer_name" class="form-control" placeholder="한 글" aria-describedby="basic-addon1">
	</div><br />
	<div class="input-group">
	  <span class="input-group-addon" id="basic-addon1">주민번호</span>
	  <input type="text" id="ssn" name="ssn" class="form-control" placeholder="예.900101-1" aria-describedby="basic-addon1">
	</div><br />
	<div class="input-group">
	  <span class="input-group-addon" id="basic-addon1">우편번호</span>
	  <input type="text" id="postal_code" name="postal_code" class="form-control" placeholder="숫자 5자리" aria-describedby="basic-addon1">
	</div><br />
	<div class="input-group">
	  <span class="input-group-addon" id="basic-addon1">주 소 </span>
	  <input type="text" id="city" name="city" class="form-control" placeholder="도로명주소" aria-describedby="basic-addon1">
	</div><br />
	<div class="input-group">
	  <span class="input-group-addon" id="basic-addon1">상세주소</span>
	  <input type="text" id="address" name="address" class="form-control" placeholder="상세주소" aria-describedby="basic-addon1">
	</div><br /><br />
<button type="button" id = "confirm_btn" class="btn btn-default btn-lg">
 		<span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 확 인 
</button>
<button type="button" id = "cancel_btn" class="btn btn-default btn-lg">
 		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 취 소
</button>

<input type="hidden" name="cmd" value="signup"/>
<input type="hidden" name="page" value="signin"/>
</div>
</form>
</div>
<jsp:include page="../home/bottom.jsp"></jsp:include>
<script>
$('#confirm_btn').click(function(){
	

	$('#form')
	.attr('action', '${ctx}/customer.do')
	.submit();
	
	/*if(empno === ''){
		alert('사번은 필수입력값입니다 !!');
	}else if(name === ''){
		alert('이름은 필수입력값입니다 !!');
	}else if(manager === ''){
		alert('매니저는 필수입력값입니다 !!');
	}else if(birthDate === ''){
		
		alert('생년월일은 필수입력값입니다 !!');
	}else{
		//alert('사원 DOM 객체의 타입 속성값:'+$('#empno').attr('type'))
		alert('전송가능');
		// form.action= '/employee.do'; 
		// var form = $('#register_form');
		// form.attr('action', '${ctx}/employee.do');
		// form.submit();
		
	}
	
	*/});
$('#cancel_btn').click(function(){
	alert('취소버튼클릭!!');
	});	
</script>
<!-- var form = $('#register_form')
		form.action ='/';
		form.submit('employee.do') -->
	