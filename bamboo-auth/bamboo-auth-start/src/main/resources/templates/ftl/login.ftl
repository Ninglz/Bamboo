<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="utf-8">
	<meta name="author" content="ninglz">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>Bamboo微服务统一认证</title>
	<link rel="stylesheet" href="/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/css/login.css">
</head>

<body class="login-page">
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-md-center h-100">
				<div class="card-wrapper">
					<div class="brand">
						<img src="/img/logo.jpg" alt="logo">
						<h2>Bamboo统一认证系统</h2>
					</div>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title" align="center">统一认证系统</h4>
							<form method="POST"  action="/token/form" class="login-validation" novalidate="">
								<div class="form-group">
									<label for="username">账号</label>
									<input id="username" type="text" class="form-control" name="username" value="" required autofocus>
									<div class="invalid-feedback">
										账号无效
									</div>
								</div>

								<div class="form-group">
									<label for="password">密码
<#--										<a href="forgot.html" class="float-right">-->
<#--											Forgot Password?-->
<#--										</a>-->
									</label>
									<input id="password" type="password" class="form-control" name="password" required data-eye>
								    <div class="invalid-feedback">
								    	密码是必填项
							    	</div>

								</div>

<#--								<div class="form-group">-->
<#--									<div class="custom-checkbox custom-control">-->
<#--										<input type="checkbox" name="remember" id="remember" class="custom-control-input">-->
<#--										<label for="remember" class="custom-control-label">Remember Me</label>-->
<#--									</div>-->
<#--								</div>-->

								<div class="form-group m-0">
									<button type="submit" class="btn btn-primary btn-block">
										登录
									</button>
								</div>
<#--								<div class="mt-4 text-center">-->
<#--									Don't have an account? <a href="register.html">Create One</a>-->
<#--								</div>-->
								<#if error??>
									<span style="color: red; ">${error}</span>
								</#if>
							</form>
						</div>
					</div>
					<div class="footer">
						Copyright &copy; 2021 &mdash; Bamboo
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="/js/jquery-3.3.1.slim.min.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/login.js"></script>
</body>
</html>
