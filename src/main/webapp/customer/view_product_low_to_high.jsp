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
						<p class="fs-3 text-center">Product Details</p>
						<p class="fs-5 text-center text-success"><%=session.getAttribute("added") %></p> 
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
								List<Product> products=new ProductDao().fetchByLowToHigh();
								
								for (Product p : products) {
								%>
								<tr>
									<td><%=p.getName()%></td>
									<td><%=p.getPrice()%></td>
									<td><%=p.getCategory() %></td>
							
									<td><%=p.getStockLeft()%></td>
									
									<td>
									<% 
									boolean flag=true;
									Customer customer=(Customer)session.getAttribute("customerObj");
									List<Items> items=customer.getCart().getItems();
									
									for(Items i:items){
										
										if(p.getId()==i.getId()){
											flag=false;
											break;
										}
									}
									if(flag){
										%>
								<a class="btn btn-warning btn-sm" href="add_to_cart?productId=<%=p.getId()%>">Add to Cart</a>
										
										<%
									}
									else{
											
										%>
									<a class="btn btn-success btn-sm" href="view_cart">Go to Cart</a>
										
										<%
								
								}
									
								%>
								<a class="btn btn-primary btn-sm" href="#" >Buy Now</a>
								<% 
								
								}
								%>
									
									
									
									
					
									</td>
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