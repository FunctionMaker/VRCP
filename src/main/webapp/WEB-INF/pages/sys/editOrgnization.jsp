<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

   	<c:if test="${org==null}">
   		<title>添加组织</title>
   	</c:if>
   	<c:if test="${org!=null}">
   		<title>修改组织</title>
   	</c:if>

    <!-- Bootstrap Core CSS -->
    <link href="<%request.getServletContext().getContextPath();%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%request.getServletContext().getContextPath();%>/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%request.getServletContext().getContextPath();%>/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%request.getServletContext().getContextPath();%>/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
   	<!-- 验证 -->
    <link rel="stylesheet" href="<%request.getServletContext().getContextPath();%>/bootstrapValidator/css/bootstrapValidator.min.css"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
     <!-- jQuery -->
    <script src="<%request.getServletContext().getContextPath();%>/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%request.getServletContext().getContextPath();%>/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%request.getServletContext().getContextPath();%>/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%request.getServletContext().getContextPath();%>/dist/js/sb-admin-2.js"></script>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <script class="resources library" src="<%request.getServletContext().getContextPath();%>/cityselect/area.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%request.getServletContext().getContextPath();%>/bootstrapValidator/js/bootstrapValidator.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
	    $(function(){
	    	$("#submitBtn").click( function () {
	    		var validator = $("#orgForm").data("bootstrapValidator");
	    		  validator.validate();
	    		  if(validator.isValid()){
	    			  save();
	    		  }else{
	    			  return false;
	    		  }
	    	} );
	    });
    	function save(){
    		var data = {};
    		var addr = "";
    		var formArray = $("#orgForm").serializeArray();
    		for(var i=0;i<formArray.length;i++){
    			var formObj = formArray[i];
    			var key = formObj.name;
    			var value = formObj.value;
    			if(key == "s_province" || key == "s_city" || key == "s_county" || key == "s_detail_addr"){
    				addr += (value + "_");
    			}else{
    				data[key]=value;
    			}
    		}
    		data["address"] = addr.substring(0, addr.length-1);
    		$.post("<%request.getServletContext().getContextPath();%>/carfi/organization/edit",data,function(result){
    			if(result.success){
    				window.location.href = "<%request.getServletContext().getContextPath();%>/carfi/index/main";
    			}
    		});
    	}
 
    </script>
</head>

<body>

    <div id="wrapper">
        <div >
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-lg-6">
                	<c:if test="${org==null}">
                		<h1 class="page-header">添加组织</h1>
                	</c:if>
                	<c:if test="${org!=null}">
                		<h1 class="page-header">修改组织</h1>
                	</c:if>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-lg-6">
                    <div class="panel panel-default">

                        <div class="panel-body">
                            <div class="row">
                                <!-- /.col-lg-6 (nested) -->
                                <div class="col-lg-12">
                                    <h1>组织信息</h1>
                                    <hr>
                                    <form role="form" id="orgForm">
                                            <div class="form-group">
                                                <label>组织全名：</label>
                                                <input class="form-control"  type="text" placeholder="Organization name" name="fullName" value="${org.fullName}" data-bv-notempty data-bv-notempty-message="组织全名必填">
                                            </div>
                                            <div class="form-group">
                                                <label>组织别名：</label>
                                                <input class="form-control"  type="text" placeholder="Organize the alias" name="alias" value="${org.alias}">
                                            </div>
                                            <div class="form-group">
                                                <label>联系电话：</label>
                                                <input class="form-control"  type="text" placeholder="Phone number" name="contactTel" value="${org.contactTel}">
                                            </div>
                                            <div class="form-group">
                                                <label>固定电话：</label>
                                                <input class="form-control"  type="text" placeholder="Fixed telephone" name="fixedTel" value="${org.fixedTel}">
                                            </div>
                                            <div class="form-group">
                                                <label>备用联系方式：</label>
                                                <input class="form-control"  type="text" placeholder="Alternate phone" name="spareContact" value="${org.spareContact}">
                                            </div>
                                            <div class="form-group">
                                                <label>邮箱：</label>
                                                <input class="form-control"  type="text" placeholder="Email" name="email" value="${org.email}">
                                            </div>
                                            <div class="form-group">
                                                <label>联系人：</label>
                                                <input class="form-control"  type="text" placeholder="The contact" name="contactMan" value="${org.contactMan}">
                                            </div>
                                            <div class="form-group">
                                                <label>组织地址：</label>
                                                <div id="citySelect"  >
                                                    <select id="s_province" name="s_province"></select>  
                                                    <select id="s_city" name="s_city"  required data-bv-notempty-message="The full name is required"></select>  
                                                    <select id="s_county" name="s_county"></select>
                                                    <script type="text/javascript">_init_area();</script>
                                                    <label style="font-weight: normal">详细位置：</label>
                                                    <input class="" type="text" placeholder="Detailed address" size="50" name="s_detail_addr" id="s_detail_addr">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>备注：</label>
                                                <input class="form-control"  type="text" placeholder="Remark" name="remark" value="${org.remark}">
                                            </div>
                                            <input type="hidden" name="orgId" value="${org.id}">
                                            <input type="hidden" name="orgTerminalNum" value="${org.terminalNum}">
                                            <input type="hidden" name="hasSonNode" value="${org.hasSonNode}">
                                            <input type="hidden" name="parent.id" value="${org.parent.id}">
                                    <hr>
                                    <h1>组织超级管理员信息</h1>
                                    <hr>
                                        <div class="form-group">
                                            <label>账号名称：</label>
                                            <input class="form-control"  type="text" placeholder="Account" name="accountName" value="${orgUser.accountName}">
                                        </div>
                                        <div class="form-group">
                                            <label>登录密码：</label>
                                            <input class="form-control"  type="password" placeholder="Password" name="password" value="${orgUser.password}">
                                        </div>
                                        <div class="form-group">
                                            <label>确认密码：</label>
                                            <input class="form-control"  type="password" placeholder="Password" value="${orgUser.password }" name="confirmPassword">
                                        </div>
                                        <div class="form-group">
                                            <label>管理人：</label>
                                            <input class="form-control"  type="text" placeholder="The administrator" name="manager" value="${orgUser.manager }">
                                        </div>
                                        <div class="form-group">
                                            <label>联系电话：</label>
                                            <input class="form-control"  type="text" placeholder="Phone number" name="phone" value="${orgUser.phone }">
                                        </div>
                                        <div class="form-group">
                                        	<button type="button" id="submitBtn" class="btn btn-primary">提交</button>
                                         </div>
                                        <input type="hidden" name="orgUserId" value="${orgUser.id}">
                                        <input type="hidden" name="orgUserTerminalNum" value="${orgUser.terminalNum}">
                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

	<script type="text/javascript">
		var addr = "${org.address}"
		var addrs = addr.split("_");
		$("#s_province").val(addrs[0]);
		change(1);
		$("#s_city").val(addrs[1]);
		change(2);
		$("#s_county").val(addrs[2]);
		$("#s_detail_addr").val(addrs[3]);
	</script>

	<script>
		$(function(){
			$('#orgForm').bootstrapValidator({
		        message: 'This value is not valid',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		        	fullName: {
		                 validators: {
		                     notEmpty: {
		                         message: '组织全名不能为空'
		                     }
		                 }
		             },
		        	 alias: {
		                 validators: {
		                     notEmpty: {
		                         message: '组织别名不能为空'
		                     }
		                 }
		             },
		             contactTel: {
		            	 validators: {
		                     notEmpty: {
		                         message: '联系电话不能为空'
		                     }
		                 }
		             },
		             fixedTel: {
		            	 validators: {
		                     notEmpty: {
		                         message: '固定电话不能为空'
		                     }
		                 }
		             },
		             email: {
		                 validators: {
		                     emailAddress: {
		                         message: '邮箱格式不正确'
		                     }
		                 }
		             },
		             contactMan: {
		                 validators: {
		                     notEmpty: {
		                         message: '联系人不能为空'
		                     }
		                 }
		             },
		             s_province: {
		                 validators: {
		                     notEmpty: {
		                         message: '省份不能为空'
		                     }
		                 }
		             },
		             s_city: {
		                 validators: {
		                     notEmpty: {
		                         message: '城市不能为空'
		                     }
		                 }
		             },
		             s_county: {
		                 validators: {
		                     notEmpty: {
		                         message: '区县不能为空'
		                     }
		                 }
		             },
		             s_detail_addr: {
		                 validators: {
		                     notEmpty: {
		                         message: '组织地址不能为空'
		                     }
		                 }
		             },
		             //组织地址待验证
		             accountName: {
		                 validators: {
		                     notEmpty: {
		                         message: '账号名称不能为空'
		                     }
		                 }
		             },
		             password: {
		                 validators: {
		                     notEmpty: {
		                         message: '密码不能为空'
		                     }
		                 }
		             },
		             confirmPassword: {
		                 validators: {
		                     identical: {
		                         field: 'password',
		                         message: '两次密码输入不一致'
		                     }
		                 }
		             },
		             manager: {
		                 validators: {
		                     notEmpty: {
		                         message: '管理人不能为空'
		                     }
		                 }
		             },
		             phone: {
		            	 validators: {
		                     notEmpty: {
		                         message: '联系电话不能为空'
		                     }
		                 }
		             }
		        }
		});
		})
	</script>

</body>

</html>
