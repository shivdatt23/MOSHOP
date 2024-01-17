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
<%@ include file="admin_nav.jsp" %>
	

	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Product Details</p>
						<table class="table">
							<thead>
								<tr>
									<th>Product Name</th>
									<th>Price</th>
									<th>Category</th>
									<th>Stock Left</th>
									<th>Stock Sold</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								
							/*	Admin admin=new AdminDao().fetchById(1);
								
								List<Merchant> merchants=admin.getMerchant();
								for(Merchant m:merchants){
									
								List<Product> products=m.getProduct();
								
								*/
								
								List<Product> products=new ProductDao().fetchAll();
								for (Product p : products) {
								%>
								<tr>
									<td><%=p.getName()%></td>
									<td><%=p.getPrice()%></td>
							
									<td><%=p.getStockLeft()%></td>
									<td><%=p.getStockSold()%></td>
									<td>Action</td>
								</tr>
								<%
								}
								
								%>





							</tbody>
						</table>

					</div>
				</div>


			</div>

		</div>


	</div>


</body>
</html>