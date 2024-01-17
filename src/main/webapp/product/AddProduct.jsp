<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>

	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Add Product</p>
						<p class="text-center text-success">${success}</p>
						<!--  <form action="add_product?mid=<%=session.getAttribute("id")%>" method="post"> -->
						<form action="register_product" method="post">
					
				
						
						<div class="mb-3">
								<label class="form-label">Name</label> <input
									name="name" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Price</label> <input
									name="price" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Category</label> <input
									name="category" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Quantity</label> <input
									name="stockLeft" type="text" class="form-control" required>
							</div>
							
							<input type="hidden" name="mid" value="<%=session.getAttribute("id") %>">
							
							<button type="submit" class="btn bg-primary text-white col-md-12">Add</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>