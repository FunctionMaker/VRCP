<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>VRCP后台管理系统</title>

	<%String path = request.getContextPath(); %>
	
    <!-- Bootstrap Core CSS -->
    <link href="<%=path%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=path%>/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=path%>/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=path%>/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
      <!-- jQuery -->
    <script src="<%=path%>/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/layer/layer.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    	#page-wrapper{
    		min-height: 2000px;
    	}
    	#userSpan{
    		color: #87CEEB;
    		padding: 20px;
    	}
    </style>
    <script type="text/javascript">
    	$(function(){
    		var url=document.referrer;
    		if(url.indexOf("/organization/input") != -1){
    			$("#page-wrapper").load("<%=path%>/carfi/organization/index", {}, function(){});
    		}else{
    			//默认打开组织 
    			$("#page-wrapper").load("<%=path%>/carfi/organization/index", {}, function(){});
    		}
    	});
    </script>
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">VRCP后台管理系统</a>
            </div>
            <!-- /.navbar-header -->

            <!-- /.navbar-top-links -->
            <span class="nav navbar-top-links navbar-right">
            	<fmt:formatDate value="${USER_IN_SESSION.lastLoginTime}" var="loginTime" pattern="yyyy-MM-dd HH:mm:ss" />
            	<span id="userSpan">
            		欢迎:${username }&nbsp;上次登录:${loginTime}&nbsp;
            		<a href="<%=path%>/logout"><i class="fa fa-power-off"></i></a>
            	</span>
            </span>

            <div class="navbar-default sidebar" role="navigation">
               	<div class="sidebar-nav navbar-collapse">
	                <ul class="nav" id="side-menu">
	                    <li class="sidebar-search">
	                        <div class="input-group custom-search-form">
	                            <input type="text" class="form-control" placeholder="Search...">
	                            <span class="input-group-btn">
	                            <button class="btn btn-default" type="button">
	                                <i class="fa fa-search"></i>
	                            </button>
	                        </span>
	                        </div>
	                        <!-- /input-group -->
	                    </li>
	                    <c:forEach items="${menus}" var="menu">
	                    	<c:if test="${menu.parentId==null}">
		                    	<li>
		                        	<a href="${menu.url}"><i class="${menu.icon}"></i>${menu.name}
		                        	<c:if test="${menu.hasSonNode}"><span class="fa arrow"></span></c:if>
		                        	</a>
		                        	 <ul class="nav nav-second-level" aria-expanded="false">
		                        	 	<c:forEach items="${menus}" var="secondMenu">
		                     				<c:if test="${secondMenu.parentId==menu.menuId}">
		                     					<li>
		                                    		<a href="#">${secondMenu.name}</a>
		                                		</li>
		                     				</c:if>
		                        	 	</c:forEach>
                           			 </ul>
		                    	</li>
	                    	</c:if>
	                    </c:forEach>
	                </ul>
       			 </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
           	this is content
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->


    <!-- Bootstrap Core JavaScript -->
    <script src="<%=path%>/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=path%>/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=path%>/dist/js/sb-admin-2.js"></script>
    
     <script type="text/javascript">
    	function loadContent(url){
    		if(url!="#"){
    			$("#page-wrapper").load(url,{},function(){});
    		}
    	}
    	$("#side-menu a").bind("click", function(){
    		  loadContent($(this).attr("href"));
    	});
    </script>

</body>

</html>
