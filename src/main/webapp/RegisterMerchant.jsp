<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="components/allcss.jsp" %>
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
						<p class="fs-4 text-center">Register Merchant</p>
						<p class="text-center color-success">${success}</p>
						<form action="register_merchant" method="post">
						<div class="mb-3">
								<label class="form-label">Name</label> <input
									name="name" type="text" class="form-control" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">mobile</label> <input
									name="mobile" type="tel" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Shop Name</label> <input
									name="shop" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Address</label> <input
									name="address" type="text" class="form-control" required>
							</div>
							
							<input type="hidden" name="status" value="active">
							
							<button type="submit" class="btn bg-primary text-white col-md-12">Register</button>
						</form>
						<a class="" href="LoginMerchant.jsp">Go to Login</a>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>