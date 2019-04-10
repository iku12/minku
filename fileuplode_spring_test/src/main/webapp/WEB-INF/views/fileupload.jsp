<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html;charset=utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인덱스</title>
</head>
<body>

<h1>파일업로드2(DB에 정보 저장)</h1>
<form action="fileinsert.do" method="post" enctype="multipart/form-data">
	
	<table border="1">
  <tr>
    <td>파일업로드</td>
    <td><input type="file" name="filename" required="required" /></td>
  </tr>
  
    <tr>
    <td>파일 다운로드</td>
    <td><a href="downloadList.do">파일목록보기</a></td>
  </tr>
  
   <tr>
   
    <td colspan="2"><input type="submit" value="파일첨부"> </td>
  </tr>
</table>



</form>










</body>
</html>