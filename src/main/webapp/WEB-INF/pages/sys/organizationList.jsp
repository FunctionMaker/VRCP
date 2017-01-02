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

    <title>组织列表</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%request.getServletContext().getContextPath();%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%request.getServletContext().getContextPath();%>/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="<%request.getServletContext().getContextPath();%>/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="<%request.getServletContext().getContextPath();%>/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%request.getServletContext().getContextPath();%>/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%request.getServletContext().getContextPath();%>/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
		/*     	工具条左靠 */
    	.toolbar {
    		float: left;
		}
		table{
			width: 100%;
		}
		th{
			width: 16.6666%;
		}
		tr{
			width: 100%;
		}
		td {
			width: 16.6666%;
		}
    </style>
    <script type="text/javascript" src="<%request.getServletContext().getContextPath();%>/js/common.js"></script>
      <!-- jQuery -->
    <script src="<%request.getServletContext().getContextPath();%>/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript">
	  	//修改事件
	   	function upd(id){
	  		window.top.loadContent("<%request.getServletContext().getContextPath();%>/organization/input?id="+id);
	    };
	    
		//删除事件
		function del(id){
			$.get("<%request.getServletContext().getContextPath();%>/organization/del?id="+id,function(data){
				if(data.success){
					 table.ajax.reload();
				}
			});
	    }
    </script>
    
</head>

<body>
        <div  class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">组织管理</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           	 组织列表
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover table-full-width" id="dataTables-organization">
                                <thead>
                                    <tr>
                                        <th>组织别名</th>
                                        <th>组织全名</th>
                                        <th>联系人</th>
                                        <th>联系电话</th>
                                        <th>下辖终端数量</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <script>
    var table;
    $(function() {
    	
    	//初始化datatables
        table=$('#dataTables-organization').DataTable({
            "responsive": true,
            "ordering":false,
            "oLanguage" : {
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "抱歉， 没有找到",
                "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                "sInfoEmpty": "没有数据",
                "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
                "sZeroRecords": "没有检索到数据",
                "sSearch": "名称关键字:",
                "oPaginate": {
		                "sFirst": "首页",
		                "sPrevious": "前一页",
		                "sNext": "后一页",
		                "sLast": "尾页"
                	}
        		},
                "processing": true,
                "serverSide": true,
                "ajax": "<%request.getServletContext().getContextPath();%>/organization/getDatas",
               	"columns": [
               	             { "data": "alias" },
               	             { "data": "fullName" },
               	             { "data": "contactMan" },
               	             { "data": "contactTel" },
               	             { "data": "terminalNum" },
               	             { "data": null }
               	      
               	],
        		"columnDefs": [ {
				            "render": function(data, type, row) {
				            	var component = "";
				            	component += "<a class='btn btn-info btn-xs ' onclick=upd("+ row.id +")><i class='fa fa-pencil'> 修改</i></a>";
				            	component += "&emsp;<a class='btn btn-danger btn-xs' onclick='del(" + row.id + ")'><i class='fa fa-trash-o'></i> 删除</a>";
				            	if(row.hasSonNode){
				            		component += "&emsp;<a class='btn btn-success btn-xs' onclick='openAndClose(this,"+ row.id +");'><i class='fa fa-chevron-down'></i></a>"
				            	}
				                return component;
				            },
				            "targets": -1
        		}],
                "dom": '<"toolbar">frtip'
        }
        );
    	//添加组织按钮
        $("div.toolbar").html('<a class="btn btn-primary" href="<%request.getServletContext().getContextPath();%>/organization/input"><i class="fa fa-plus"></i> 添加组织</a>');
    }
    );
    </script>
	 <!-- /#wrapper -->
    <!-- Bootstrap Core JavaScript -->
    <script src="<%request.getServletContext().getContextPath();%>/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%request.getServletContext().getContextPath();%>/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="<%request.getServletContext().getContextPath();%>/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="<%request.getServletContext().getContextPath();%>/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="<%request.getServletContext().getContextPath();%>/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%request.getServletContext().getContextPath();%>/dist/js/sb-admin-2.js"></script>
	<script type="text/javascript">
	function openAndClose(target,parentId){
		var tr = $(target).parents('tr');
	    var row = table.row(tr);
	    var arrowI = $(tr.find("i")[2]);
	    if ( row.child.isShown() ) {
	        row.child.hide();
	        arrowI.removeClass();
	        arrowI.addClass("fa");
	        arrowI.addClass("fa-chevron-down");
	    }
	    else {
	    	 arrowI.removeClass();
	         arrowI.addClass("fa");
	         arrowI.addClass("fa-chevron-up");
	         getExpandRows(row,parentId );
	    }
	}
	function getExpandRows(row,parentId){
		var trArray = new Array();
	
		$.get("<%request.getServletContext().getContextPath();%>/organization/getDatas",
			{"parentId":parentId},
			function(result){
				for(var i=0;i<result.data.length;i++){
					var rowData = result.data[i];
					var component = "";
	            	component += "<a class='btn btn-info btn-xs 'onclick=upd("+ rowData.organizationId +")><i class='fa fa-pencil'> 修改</i></a>";
	            	component += "&emsp;<a class='btn btn-danger btn-xs' onclick='del(" + rowData.organizationId + ")'><i class='fa fa-trash-o'></i> 删除</a>";
	            	if(rowData.hasSonNode){
	            		component += "&emsp;<a class='btn btn-success btn-xs' onclick='openAndClose(this,"+ rowData.organizationId +");'><i class='fa fa-chevron-down'></i></a>"
	            	}
	            	
	            	var trEle = document.createElement("tr");
	            	trEle.css="info";
	            	var aliasTdEle = document.createElement("td");
	            	aliasTdEle.innerHTML = rowData.alias;
	            	trEle.appendChild(aliasTdEle);
	            	
	            	var fullNameTdEle = document.createElement("td");
	            	fullNameTdEle.innerHTML = rowData.fullName;
	            	trEle.appendChild(fullNameTdEle);
	            	
	            	var contactManTdEle = document.createElement("td");
	            	contactManTdEle.innerHTML = rowData.contactMan;
	            	trEle.appendChild(contactManTdEle);
	            	
	            	var contactTelTdEle = document.createElement("td");
	            	contactTelTdEle.innerHTML = rowData.contactTel;
	            	trEle.appendChild(contactTelTdEle);
	            	
	            	var terminalNumTdEle = document.createElement("td");
	            	terminalNumTdEle.innerHTML = rowData.terminalNum;
	            	trEle.appendChild(terminalNumTdEle);
	            	
	            	var operationTdEle = document.createElement("td");
	            	operationTdEle.innerHTML = component;
	            	trEle.appendChild(operationTdEle);
	            	
					trArray.push($(trEle).addClass("info"));
	            	
				}
				row.child(trArray).show();
		});
	}
	</script>
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
</body>

</html>
