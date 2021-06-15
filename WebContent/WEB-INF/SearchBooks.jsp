<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.Book"%>
<% 
//リクエストスコープから取得
List<Book> books = (List<Book>)request.getAttribute("books");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
<jsp:include page="Header.jsp" />
<p>
<table border="0" width="80%">
	<tr>
		<th><strong>タイトル</strong></th>
    	<th><strong>価格</strong></th>
	</tr>
	<%for(Book book:books){ %>
	<tr>
		<td><a href="GetBook?isbn=<%=book.getIsbn()%>"><%=book.getTitle() %></a></td>
		<td><%=book.getPrice() %>円</td>
	</tr>
	<%} %>
</table>
</p>
</body>
</html>