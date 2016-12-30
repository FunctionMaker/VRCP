<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>VRCP后台登录</title>
    
    <%String path = request.getContextPath(); %>

    <!-- Bootstrap Core CSS -->
    <link href="<%= path%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%= path%>/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%= path%>/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%= path%>/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- 校验数据 -->
    <link rel="stylesheet" href="<%= path%>/bootstrapValidator/css/bootstrapValidator.min.css"/>
    
    
    <link rel="stylesheet" href="<%= path%>/css/animate.min.css"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
		#verifyCode{
			width: 100px;
			height: 30px;
			border: 1px solid #cccccc;
		}
		td{
			padding-left:10px; 
			margin:10px; 
		}
		.vInputTd{
			padding:0px; 
			margin-left:0px; 
		}
		.panel{
			margin-top: 160px;
		}
		.header{
			border-bottom: 1px solid #d9d9d9;
		    color: #999;
		    height: 70px;
		    line-height: 70px;
		    width: 100%
		}
		.footer{
			border-top: 1px solid #d9d9d9;
		    bottom: 0;
		    color: #999;
		    height: 70px;
		    left: 0;
		    line-height: 70px;
		    position: absolute;
		    text-align: center;
		    width: 100%;
		    padding: 10px;
		    
		}
		.slideContainer{
			margin-top: 125px;
		}
		.slideContent{
			border-radius:20px;
		}
		#logo{
			width:60px;
			margin-left: 400px;
		}
		#headLabel{
			margin-left: 20px;
		}
		.btn{
			color:white;
			background-color: #00a1e9;
		}
    </style>
    
    <script src="<%= path%>/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="<%= path%>/bootstrapValidator/js/bootstrapValidator.min.js"></script>
    
    <script type="text/javascript">
    	function changeImg(){
    		$("#verifyCode").attr("src","<%= path%>/getVerifyCode?r=" + Math.random());
    	}
    </script>
    
    <script type="text/javascript">
    	$(function(){
    		
    		//初始化轮播
    	    $("#adsCarousel").carousel('cycle');
    		
    		//设置间隔时间
    	    $('.carousel').carousel({  
    	        interval: 1000  
    	    }); 
    		
    		//数据校验
    		$('#userForm').bootstrapValidator({
    	        message: 'This value is not valid',
    	        feedbackIcons: {
    	            valid: 'glyphicon glyphicon-ok',
    	            invalid: 'glyphicon glyphicon-remove',
    	            validating: 'glyphicon glyphicon-refresh'
    	        },
    	        fields: {
    	        	 username: {
    	                 message: 'The username is not valid',
    	                 validators: {
    	                     notEmpty: {
    	                         message: '用户名不能为空'
    	                     }
    	                 }
    	             },
    	        	 password: {
    	                 message: 'The username is not valid',
    	                 validators: {
    	                     notEmpty: {
    	                         message: '密码不能为空'
    	                     }
    	                 }
    	             },
    	             verifyCode: {
    	                 validators: {
    	                     remote: {
    	                         message: '验证码不正确',
    	                         url: '<%= path%>/validVerifyCode'
    	                     }
    	                 }
    	             }
    	        }
    	});
    	})
    </script>

</head>

<body>
	
	<!-- 头部 -->
	<div class="container-fluid header">
		<img id="logo" alt="" src="<%=path %>/img/logo.png"><label id="headLabel">金融风控管理系统</label>
	</div>
	
    <div class="container">
        <div class="row">
        	<div class="col-md-5 col-md-offset-1">
        		<div class="slideContainer">
			        <div id="adsCarousel" class="carousel">
						<!-- 轮播（Carousel）指标 -->
						<ol class="carousel-indicators">
							<li data-target="#adsCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#adsCarousel" data-slide-to="1"></li>
							<li data-target="#adsCarousel" data-slide-to="2"></li>
						</ol>   
						<!-- 轮播（Carousel）项目 -->
						<div class="carousel-inner animated slideContent">
							<div class="item active fadeIn">
								<img src="<%=path %>/ads/1.jpg" alt="First slide">
							</div>
							<div class="item animated fadeIn">
								<img src="<%=path %>/ads/2.jpg" alt="Second slide">
							</div>
							<div class="item animated fadeIn">
								<img src="<%=path %>/ads/3.jpg" alt="Third slide">
							</div>
						</div>
					</div>
				</div>
        	</div>
            <div class="col-md-4 col-md-offset-1">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">登录</h3>
                    </div>
                    <div class="panel-body">
                        <form id="userForm" role="form" method="post" action="<%= path%>/login">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="用户名" name="username" value="${user.username}" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="密码" name="password" value="${user.password}" type="password">
                                </div>
								 <div class="form-group" >
					 				<table>
					 					<tr>
					 						<td class="vInputTd">
					 							<input class="form-control" placeholder="验证码" name="verifyCode" type="text" style="width:100px">
					 						</td>
					 						<td>
					 							<img id="verifyCode" src="<%= path%>/getVerifyCode" class="img-responsive" alt="验证码 " onClick="changeImg();"/>
					 						</td>
					 					<tr/>
					 				</table>
								 </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <input type="submit" class="btn btn-lg btn-block" value="登录" style="margin-top:25px"/>
                            </fieldset>
                        </form>
                        <label style="color:#a94244">${message}</label>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 底部 -->
    <div class="container-fluid footer">
		四川咖范网络科技有限公司  Copyright © 2016 Carfi Limited All Rights Reserved
	</div>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%= path%>/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%= path%>/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%= path%>/dist/js/sb-admin-2.js"></script>

</body>

</html>
