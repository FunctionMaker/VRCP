<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false' %>
<!doctype html>
<html lang="en">
<head>
	<%String path = request.getContextPath(); %>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/normalize.css"/>
    <link rel="stylesheet" href="css/flipclock.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/bebasneue.css"/>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/awe-style.css"/>

    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->

	<title>404 - 没找到页面</title>
</head>
<body>
	<div class="awe-panda">
		<div class="panda-body">
			<canvas class="snow"></canvas>
			<div class="snow-mobile"></div>
			<div class="panda-shadow"></div>
			<div class="parallax parallax404" data-position="6"></div>
			<div class="parallax parallax2" data-position="4"></div>
			<div class="parallax parallax3" data-position="2"></div>
			<div class="panda-content">
				<div class="panda-title">
					<h2 class="title md">Your page is underneath that hole</h2>
					<p class="sub-title">
						We have sent our best developer to find it already !<br>
						(but it seems hopeless)
					</p>
				</div>
				<div class="search-form panda-form">
					<form>
						<div class="form-item">
							<input type="text" placeholder="Try to search again">
						</div>
						<div class="form-actions">
							<input type="submit" value="" class="submit">
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="panda-footer">
			<div class="panda-logo">
				<img class="logo-pd-3" src="<%=path %>/img/logo-pd-3.png" alt="">
			</div>
		</div>
	</div>

	<script src="<%=path %>/js/modernizr.min.js"></script>
	<script type="text/javascript" src="vendor/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.let_it_snow.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/script.js"></script>
	<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','<%=path %>/js/analytics.js','ga');

  ga('create', 'UA-20585382-5', 'megadrupal.com');
  ga('send', 'pageview');

</script></body>
</html>