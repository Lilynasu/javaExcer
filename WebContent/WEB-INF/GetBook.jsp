<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Book" %>
<%Book book = (Book)request.getAttribute("book"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>詳細一覧</title>
</head>
<body>
<jsp:include page="Header.jsp" />
<p>
	<h2><%=book.getTitle() %></h2>
	ISBN: <%=book.getIsbn() %><br>
	価格: <%=book.getPrice() %>円<br>
	著者: <%=book.getAuthor() %><br>
</p>
<p>
	<%=book.getFeature() %><br>
	<form action="AddCart" method="post">
	<input type="hidden" name="isbn" value="<%=book.getIsbn()%>">
	<input type="submit" value="カートに追加">
	</form>
</p>

</body>
</html>