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

    <title>组织角色列表</title>

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
    </style>
    <script type="text/javascript" src="<%request.getServletContext().getContextPath();%>/js/common.js"></script>
      <!-- jQuery -->
    <script src="<%request.getServletContext().getContextPath();%>/vendor/jquery/jquery.min.js"></script>
    <!-- layer -->
    <script type="text/javascript" src="<%request.getServletContext().getContextPath();%>/layer/layer.js"></script>
    <script>
    var table;
    $(function() {
    	
    	//初始化datatables
        table=$('#list').DataTable({
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
                "ajax": "<%request.getServletContext().getContextPath();%>/org/role/roleListData",
               	"columns": [
               	             { "data": "name" },
               	             { "data": null }
               	      
               	],
        		"columnDefs": [ {
				            "render": function(data, type, row) {
				            	var component = "";
				            	component += "<a class='btn btn-info btn-xs 'onclick=query("+ row.id +")><i class='fa fa-pencil'> 查看</i></a>";
				            	if(row.orgId != null && row.orgId != 'null'){
					            	component += "&emsp;<a class='btn btn-info btn-xs 'onclick=upd("+ row.id +")><i class='fa fa-pencil'> 修改</i></a>";
					            	component += "&emsp;<a class='btn btn-danger btn-xs' onclick='del(" + row.id + ")'><i class='fa fa-trash-o'></i> 删除</a>";
				            	}
				            	if(row.hasSonNode){
				            		component += "&emsp;<a class='btn btn-success btn-xs' onclick='openAndClose(this,"+ row.id +");'><i class='fa fa-chevron-down'></i></a>"
				            	}
				                return component;
				            },
				            "targets": -1
        		}],
        		"createdRow": function ( row, data, index ) {
        			
                },
                "dom": '<"toolbar">frtip'
        }
        );
    	//添加组织按钮
        $("div.toolbar").html('<a class="btn btn-primary" href="javascript:;" onclick="showModel()" ><i class="fa fa-plus"></i> 添加角色</a>');
    	
    	//添加修改角色信息保存按钮点击事件
    	$("#saveRole").click(function(){
    		//验证
    		if($("#roleName").val() == null || $("#roleName").val() == 'null' || $("#roleName").val() == ''){
    			layer.msg('请输入角色名称', {icon: 5});
    			return;
    		}
    	   	$.post('/org/role/saveOrUpdate',$('#addForm').serialize(),function(data){
    	   		if(data.success){
    				//刷新表格
    				table.ajax.reload();
		    		//关闭模态框
		    		$("#addRoleModal").modal('hide');
		    		layer.msg(data.msg, {icon: 1});
    			}else{
    				layer.msg(data.msg, {icon: 2});
    			}
    	   	});
    	});

    	//模态框隐藏后事件
    	$('#addRoleModal').on('hidden.bs.modal', function (e) {
    		//清楚表单数据
    		$('#addForm')[0].reset();
    		
    		$("#saveRole").show();
    	});
    
    });
    
    //查看
    function query(id){
    	$.get('/org/role/info/1/'+id,function(res){
    		if(res.success){
    			$("#roleId").val(res.data.role.id);
    			$("#roleName").val(res.data.role.name);
    			//初始化权限
    			//createQxHtml(res.data.pers);
    			$("#roleName").attr("readonly",true);
    			var html = '';
    			$.each(res.data.pers,function(i,v){
    				html = html + v.name + '&nbsp;&nbsp;';
    			});
    			$("#qxlist").html(html);
    			$("#saveRole").hide();
    			$("#addRoleModal").modal({keyboard: false});
    		}else{
    			layer.msg(data.msg, {icon: 2});
    		}
    	});
    }
    
    //弹出修改页面
    function upd(id){
    	//获取角色信息
    	$.get('/org/role/info/2/'+id,function(res){
    		if(res.success){
    			$("#roleId").val(res.data.role.id);
    			$("#roleName").val(res.data.role.name);
    			//初始化权限
    			createQxHtml(res.data.pers);
    			$("#addRoleModal").modal({keyboard: false});
    		}else{
    			layer.msg(data.msg, {icon: 2});
    		}
    	});
    }
    
    //删除
    function del(id){
    	//询问框
    	layer.confirm('您确定要删除该角色？', {
    	  btn: ['确定','取消'] //按钮
    	}, function(){
    		$.get('/org/role/delete/'+id,function(data){
        		if(data){
        			//刷新表格
    				table.ajax.reload();
    				layer.msg('删除成功', {icon: 1});
        		}else{
        			layer.msg('删除失败', {icon: 2});
        		}
        	});  
    	});
    	
    }
    
   
    
    //显示模态框
    function showModel(){
    	$.get('/org/permission/list/${orgId}',function(res){
    		if(res.success){
	    		createQxHtml(res.data);
	    		$("#addRoleModal").modal({keyboard: false});
    		}else{
    			layer.msg(res.msg, {icon: 2});
    		}
    	});
    	
    }
    
    //创建checkbox
    function createCheckBox(id,name,tjname,state){
    	var html = '';
    	if(state){
    		html = ' <input type="checkbox" checked="checked" value="'+id+'" name="'+tjname+'"> ' + name;
    	}else{
    		html = ' <input type="checkbox" value="'+id+'" name="'+tjname+'"> ' + name;
    	}
    	return html;
    }
    //初始化权限页面
    function createQxHtml(data){
    	$("#qxlist").html('');
		var html = '';
		$.each(data,function(n,v){
			html = html + createCheckBox(v.id,v.name,'qxs',v.state);
		});
		$("#qxlist").html(html);
    }
    </script>
    
</head>

<body>
        <div  class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">角色管理</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           	 角色列表
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="list">
                                <thead>
                                    <tr>
                                        <th>角色名称</th>
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
		
		
		<!-- 新增角色弹出框 -->
		<div class="modal fade" id="addRoleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">添加角色信息</h4>
		      </div>
		      <div class="modal-body">
		      	<form id="addForm" method="post" action="<%request.getServletContext().getContextPath();%>/org/role/add">
			      	 <div class="form-group">
	                     <label>角色名称：</label>
	                     <input type="hidden" name="id" id="roleId" />
	                     <input class="form-control" type="text" id="roleName" name="name" placeholder="角色名称" />
	                 </div>
	                  <div class="form-group">
	                     <label>权限设置：</label>
	                     <br />
	                     <span id="qxlist">
	                     
	                     </span>
	                 </div>
		      	</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button type="button" class="btn btn-primary" id="saveRole">保存</button>
		      </div>
		    </div>
		  </div>
		</div>
		
    <script>
   
    </script>
	 <!-- /#wrapper -->
    <!-- Bootstrap Core JavaScript -->
    <script src="<%request.getServletContext().getContextPath();%>/vendor/bootstrap/js/bootstrap.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%request.getServletContext().getContextPath();%>/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="<%request.getServletContext().getContextPath();%>/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="<%request.getServletContext().getContextPath();%>/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="<%request.getServletContext().getContextPath();%>/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%request.getServletContext().getContextPath();%>/dist/js/sb-admin-2.js"></script>
	<script type="text/javascript">

	</script>
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
</body>

</html>
