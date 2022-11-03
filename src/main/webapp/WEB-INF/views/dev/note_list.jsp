<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HELLO</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script> <%-- jQuery --%>
</head>
<body>
<%-- <jsp:include page="/WEB-INF/views/header.jsp"/> --%>
	<a href="/dev/note_form?cmd=insert">등록</a>	
	<button type="button" id="del">삭제</button>
	<table border="1">
		<thead>
			<tr>
				<th><input type="checkbox" name="all_chk" value="1"/></th>
				<th>No</th>
				<th>제목</th>
<!-- 				<th>내용</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item">
				<tr>
					<td><input type="checkbox" name="chk" value="${item.no}"/></td>
					<td>${ item.no }</td>
					<td>
						<a href="/dev/detail?no=${item.no}">${ item.title }</a>
					</td>
<%-- 					<td>${ item.content }</td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
<script type="text/javascript">

	var checkedList = [];

	// 체크박스 목록
	$("input:checkbox[name='chk']").click(function(e) {
		if (e.target.checked) {
			checkedList.push(e.target.value);
		} else {
			checkedList.pop(e.target.value);
		}
	})
	
	// 삭제
	$("#del").click(function(){		
		var len = $("input:checkbox[name='chk']:checked").length;
		
		var nos = $("input:checkbox[name='chk']:checked").val();
		console.log("len : ",len);
		console.log("nos : ",nos);
		if (len == 0) {
			alert("삭제할 게시물을 선택해주세요.");
			return;
		}
		
		$.ajax({
			type:"post",
			url:"/del_proc",
			data:{
				nos : checkedList
				},
			success: (data) => {alert("삭제되었습니다.")},
			error: (err) => {alert("error : "+err)}
		});
	});
</script>	
</body>
</html>