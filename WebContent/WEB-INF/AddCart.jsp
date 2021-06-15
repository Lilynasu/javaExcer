<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Map,model.CartItem,model.*" %>
<% 
Cart cart = (Cart)session.getAttribute("cart");
Map<String, CartItem> items= cart.getItems();
int total = cart.getSubTotal();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カードに追加</title>
</head>
<body>
<jsp:include page="Header.jsp" />

<p>
<%
for(String isbn:items.keySet()){
	CartItem item = items.get(isbn);
	Book book = item.getBook();
	int amount = item.getAmount(); %>
	
	<table>
		<tr>
			<td><%=book.getTitle() %></td>
			<td><%=book.getPrice() %>円</td>
			<td><%=amount %>冊</td>
		</tr>
	</table>	
<%
}
%>
<hr>
小計：<%=total  %>円
</p>
</body>
</html>