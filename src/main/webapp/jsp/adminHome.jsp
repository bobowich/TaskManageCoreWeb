<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/23
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--需要添加basepath相对引用 不然easyui样式不生效--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<shiro:hasRole name="manager">
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <%--兼容IE--%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/plugins/bootstrap-table/bootstrap-table.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/plugins/bootstrap3-editable/css/bootstrap-editable.css">
    <script src="<%=basePath%>/plugins/jquery/jquery-3.1.1.js"></script>
    <%--json 与 array 之间相互转化--%>
    <script src="<%=basePath%>/plugins/jquery-json/jquery.json.js"></script>
    <script src="<%=basePath%>/plugins/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/plugins/bootstrap3-editable/js/bootstrap-editable.js"></script>
    <script src="<%=basePath%>/plugins/bootstrap-table/bootstrap-table.js"></script>
    <script src="<%=basePath%>/plugins/bootstrap-table/bootstrap-table-zh-CN.js"></script>
    <script src="<%=basePath%>/plugins/bootstrap-table-editable/bootstrap-table-editable.js"></script>
    <script>
        $(function init() {
            console.log("初始化");
            //1.初始化Table
            var oTable = new TableInit();
            oTable.Init();

            //2.初始化Button的点击事件
            var oButtonInit = new ButtonInit();
            oButtonInit.Init();

        });


        var TableInit = function () {
            var oTableInit = new Object();
            //初始化Table
            console.log("初始化表格");
            oTableInit.Init = function () {
//                $('#tb_company').bootstrapTable('destroy');
                $('#tb_company').bootstrapTable({
                    url: '<%=basePath%>company/getAll',         //请求后台的URL（*）
                    method: 'post',                      //请求方式（*）
                    //dataType:'json',
                    contentType:'application/x-www-form-urlencoded', //客户端数据格式
                    //dataField:'list',            //表格数据的所在key
                    toolbar: '#toolbar',                //工具按钮用哪个容器
                    striped: true,                      //是否显示行间隔色
                    cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                    pagination: true,                   //是否显示分页（*）
                    sortable: false,                     //是否启用排序
                    sortOrder: "asc",                   //排序方式
                    queryParams: oTableInit.queryParams,//传递参数（*）
                    sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                    pageNumber:1,                       //初始化加载第一页，默认第一页
                    pageSize: 5,                       //每页的记录行数（*）
                    pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                    search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                    strictSearch: true,
                    showColumns: true,                  //是否显示所有的列
                    showRefresh: true,                  //是否显示刷新按钮
                    minimumCountColumns: 1,             //最少允许的列数
                    clickToSelect: true,                //是否启用点击选中行
                    height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                    uniqueId: "companyId",                     //每一行的唯一标识，一般为主键列
                    showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
                    cardView: false,                    //是否显示详细视图
                    detailView: false,                   //是否显示父子表
                    //注意 这里是columns ，NOT NOT  NOT column
                    columns:[
                           {title:'编辑',
                            checkbox:true
                           },

                           {field:'companyId',
                            title:'公司编号'
                           },

                           {field:'companyName',
                            title:'公司名',
                               editable: {
                                   type: 'text',
                                   validate: function(value) {
                                       if($.trim(value) == '') {
                                           return '测量值不能为空';
                                       }
                                   }
                               }
                           },

                           {
                               field:'realName',
                               title:'领导'
                           }
                    ],

                    onEditableSave: function (field, row, oldValue, $el) {
                        $.ajax({
                            type: "post",
                            url: "<%=basePath%>company/update",
                            contentType:"application/x-www-form-urlencoded",
                            data: row,
                            dataType: 'text',
                            success: function (data, status) {
                                if (data == "success") {
                                    alert('提交数据成功');
                                }
                            },

                            error: function () {
                                alert('编辑失败');
                            },

                            complete: function () {

                            }

                        });
                    },

                    onLoadSuccess:function () {
                        console.log("success");
                    },

                    responseHandler:function (res) {
                        console.log(res);
                        return {
                            //responseHandler用于对不符合bootstrap table要求的格式重新如下转化
                            "total":res.total, //总数
                            "rows":res.list  //数据
                        };
                    }
                });
            };

            //得到查询的参数
            oTableInit.queryParams = function (params) {
                var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                    pageSize: params.limit,   //页面大小
                    pageIndex: params.offset/(params.limit) + 1 //页码

//                    departmentname: $("#txt_search_departmentname").val(),
//                    statu: $("#txt_search_statu").val()
                };
                return temp;
            };
            return oTableInit;
        };

        function filter(data,args) {
            var array = new Array();
            $.map(data, function (item, index) {
                var company = {};
                company.companyId = item.companyId;
                company.companyName = item.companyName;
                company.realName = item.realName;
                array.push(company);
            });
            console.log(array);
            return array;
        }

        var ButtonInit = function () {
            var $tb_company = $('#tb_company');
            var $bt_del = $('#button_del');
            var oInit = new Object();
            var postdata = {};

            oInit.Init = function () {
                //初始化新增按钮事件,弹出模态框
                $('#button_add').click(function () {
                    $('div').remove('.form-group');
                    var array = new Array();
                    var $tr =$('#tb_company thead tr');
                    var $th = $tr.children('th');
                    //var $th = $tb_company.find('thead');
                    $.each($th,function (index,item) {
                        if(index > 0) {
                            console.log(index);
                            //通过attr（"key"）方法获取data-field属性的值
                            console.log($(this).attr("data-field"));
                            var company = {};
                            company.companyName = $(this).attr("data_field");
                            company.title = $(this).text();
                            array.push(company);
                        }

                    });
                    for(i=0;i<array.length;i++){
                        var lable = 'lable'+i;
                        var single = '<div class="form-group">'+'<label for='+lable+'>'+array[i].title
                            +'</label> <input type="text" class="form-control" id='+lable+'name='+array[i].companyName+'>'
                            + '</div>';
                        $('#form_add').append(single);
                    }

                    $('#myModal').modal('show');
                });
                
                //初始化模态框提交事件
                $('#button_insert').click(function () {

                });
                //初始化删除的按钮事件
                $bt_del.click(function () {
                    console.log("点击删除按钮");
                    var rows = $tb_company.bootstrapTable("getSelections");
                    console.log(rows);
                    if (rows != null) {
                        console.log("发起删除请求");
                        var datas = $.toJSON(filter(rows));
                        $.ajax(
                            {
                                type:"post",
                                url:"<%=basePath%>company/del",
                                contentType:"application/json",
                                data:datas,
                                dataType:'text',
                                success:function (data,status) {
                                    if (data=="success"){
                                        alert("删除数据成功");
                                    }
                                },

                                error:function () {
                                    alert("删除数据失败");
                                }
                            }
                        );
                    }
                });
            };

            return oInit;
        };


        $(function () {
            $('.panel-heading').click(function () {
                $(this).find("span").toggleClass("glyphicon glyphicon-chevron-right");
                $(this).find("span").toggleClass("glyphicon glyphicon-chevron-down");
            });
        });

        
    </script>
</head>
<body >
<header class="navbar navbar-inverse" role="banner">
    <div class="navbar-header">
        <button id="menu-toggle" class="navbar-toggle btn-primary" type="button" data-toggle="collapse">
            <span class="sr-only"></span>
            <span class="text-info">Menu</span>
        </button>
        <a class="navbar-brand" href="index.html"><img src="<%=basePath%>/img/logo.png"></a>
    </div>
    <ul class="nav nav-pills pull-right">
        <li class="active"><a href="#">首页 <span class="badge">4</span></a></li>
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Java
                <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li>
                    <a href="#">Swing</a></li>
                <li>
                    <a href="#">jMeter</a></li>
                <li>
                    <a href="#">EJB</a></li>
                <li class="divider"></li>
                <li>
                    <a href="#">退出登录</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">消息
                <span class="badge">3</span></a>
            <ul class="dropdown-menu">
                <li>
                    <a href="#">Swing</a></li>
                <li>
                    <a href="#">jMeter</a></li>
                <li>
                    <a href="#">EJB</a></li>
            </ul>

        </li>
    </ul>
</header>
<div class="row">
    <div class="col-md-3">
        <div class="panel-group" id="accordion">
            <div class="panel panel-primary">
                <div class="panel-heading" data-toggle="collapse" data-parent="#accordion"
                     data-target="#collapseOne">
                    <h4 class="panel-title">
                        <a href="#">
                            系统管理<span class="glyphicon glyphicon-chevron-right pull-right"></span>
                        </a>
                    </h4>
                </div>

                <div id="collapseOne" class="panel-collapse collapse">
                    <div class="panel-body">
                        <ul class="list-group">
                            <li class="list-group-item">
                                <button class="btn btn-info" style="width: 100%">
                                    <span class="pull-left"> 公司管理</span>
                                    <span class="glyphicon glyphicon-chevron-right pull-right"></span>
                                </button>
                            </li>
                            <li class="list-group-item">
                                <button class="btn btn-info" style="width: 100%">
                                    <span class="pull-left"> 部门管理</span>
                                    <span class="glyphicon glyphicon-chevron-right pull-right"></span>
                                </button>
                            </li>
                            <li class="list-group-item">
                                <button class="btn btn-info" style="width: 100%">
                                    <span class="pull-left"> 部门管理</span>
                                    <span class="glyphicon glyphicon-chevron-right pull-right"></span>
                                </button>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="col-md-9">
        <div class="navbar-default pull-left" id="toolbar">
            <ul class="nav nav-pills pull-right">
                <li>
                    <button id="button_add" class="btn">增加<span class="glyphicon glyphicon-plus"> </span></button>
                </li>

                <li>
                    <button id="button_del" class="btn">删除<span class="glyphicon glyphicon-plus"> </span></button>
                </li>
            </ul>
        </div>
        <table id="tb_company"></table>
    </div>
</div>
<!-- Modal -->
<div class="modal" id="myModal" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-head">
                <%--<a href="#" class="close pull-right" data-dismiss="modal">×</a>--%>
                <h4 class="h3 text-center">用户登陆</h4>
            </div>
            <div class="modal-body">
                <form id="form_add">
                    <%--<div class="form-group">--%>
                        <%--<label for="exampleInputEmail1">Email address</label>--%>
                        <%--<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="exampleInputPassword1">Password</label>--%>
                        <%--<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="exampleInputFile">File input</label>--%>
                        <%--<input type="file" id="exampleInputFile">--%>
                        <%--<p class="help-block">Example block-level help text here.</p>--%>
                    <%--</div>--%>

                    <%--<div class="checkbox">--%>
                        <%--<label>--%>
                            <%--<input type="checkbox"> Check me out--%>
                        <%--</label>--%>
                    <%--</div>--%>
                    <%--<button type="submit" class="btn btn-default">Submit</button>--%>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="button_insert" type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div></div>
</body>
</html>
</shiro:hasRole>