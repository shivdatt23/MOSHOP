<%@page import="com.org.dao.CustomerDao"%>
<%@page import="com.org.dto.Items"%>
<%@page import="com.org.dto.Customer"%>
<%@page import="com.org.dao.ProductDao"%>
<%@page import="com.org.dto.Admin"%>
<%@page import="com.org.dao.AdminDao"%>
<%@page import="com.org.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dto.Merchant"%>
<%@page import="com.org.dao.MerchantDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@ include file="customer_nav.jsp" %>
	

	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Your Cart Items</p>
					<!--  	<p class="fs-5 text-center text-success"><%=session.getAttribute("remove") %></p> -->
						<table class="table">
							<thead>
								<tr>
								
									<th>Product Name</th>
									<th>Price</th>
									<th>Category</th>
									<th>Stock Left</th>
									
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								Customer c=(Customer)session.getAttribute("customerObj");
								Customer customer=new CustomerDao().fetchById(c.getId());
								List<Items> items=customer.getCart().getItems();
								for(Items i:items){
								%>
								<tr>
									
									<td><%=i.getName()%></td>
									<td><%=i.getPrice()%></td>
									<td><%=i.getCategory() %></td>
									<td><%=i.getStockLeft()%></td>
									
									<td>
								
									<a class="btn btn-danger btn-sm" href="remove_item?itemId=<%=i.getId() %>" >remove</a>
						
									</td>
									
									<%
									}%>
								</tr>
							





							</tbody>
						</table>

					</div>
				</div>


			</div>

		</div>


	</div>


</body>
</html>