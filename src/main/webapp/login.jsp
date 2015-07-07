<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>JAX-RS</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<style>
.fieldlabel {
	display: block;
}

.loginpanel {
	width: 400px;
	margin: 0px auto;
	border: 1px solid #999;
}
</style>
</head>
<body>
	<div class="login-panel">
		<h2>JAX-RS</h2>
		<form action="j_security_check" method="post">
			<label for="j_username" class="fieldlabel">User:</label> 
			<input type="text" name="j_username" size="25"> <br /> 
			<label for="j_password" class="fieldlabel">Password:</label>
			<input type="password" name="j_password" size="25">
			<p />
			<input type="submit" value="Submit"> <input type="reset" value="Reset">
		</form>
	</div>
</html>
</body>