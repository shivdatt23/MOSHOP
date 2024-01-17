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
						<p class="fs-4 text-center">Login Merchant</p>
						<p class="text-center text-danger fs-4">${fail }</p>
						
						<form action="login_merchant" method="post">
						<div class="mb-3">
						<label class="form-label">Email Address</label>
						<input class="form-control" name="email" type="email" required>
						</div>
						
						<div class="mb-3">
						<label class="form-label">Password</label>
						<input class="form-control" name="password" type="password" required>
						</div>
						
						<div>
						<button type="submit" class="btn bg-secondary text-white col-md-12">
						Login
						</button>
						</div>
						
						</form>
						<a class="" href="hello">Click to Register</a>
						
						
					</div>
				
				</div>
			</div>
		
		
		</div>
	</div>
</body>
</html>