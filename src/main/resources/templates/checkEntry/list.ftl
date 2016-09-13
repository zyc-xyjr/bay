<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="/js/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="/js/themes/demo.css" />
    <script type="text/javascript" src="/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.js"></script>
</head>
<body>
<#--<h2>Custom DataGrid Pager</h2>
<p>You can append some buttons to the standard datagrid pager bar.</p>-->
<div style="margin:20px 0;"></div>
<table id="dg" title="Custom DataGrid Pager" style="width:700px;height:550px">
</table>
<script type="text/javascript">
    $(function(){
        var pager = $('#dg').datagrid({
            title:'应用系统列表',
            iconCls:'icon-edit',//图标
            width: 700,
            height: 700,
            nowrap: false,
            striped: true,
            border: true,
            collapsible:false,//是否可折叠的
            fit: false,//自动大小
            url:'/admin/dictionary/checkEntry/ajax/list',
            remoteSort:false,
            idField:'id',
            singleSelect:false,//是否单选
            pagination:true,//分页控件
            rownumbers:true,//行号
            columns:[[
                {field:'id',title:'主键',width:100},
                {field:'parentId',title:'父级主键',width:100},
                {field:'entryName',title:'检查项名称',width:100},
                {field:'entryKey',title:'检查项代码',width:100}
            ]],
            toolbar: [{
                text: '添加',
                iconCls: 'icon-add',
                handler: function() {
                    location.href="/admin/dictionary/checkEntry/toEdit";
                }
            }, '-',{
                text: '删除',
                iconCls: 'icon-remove',
                handler: function(){
                    var rows = pager.datagrid("getSelections");
                    var ids="";
                    rows.forEach(function(row){
                        ids+=row.id+","
                    })
                    console.log(ids);
                    location.href="/admin/dictionary/checkEntry/del?ids="+ids;
                }
            }]
        }).datagrid('getPager');	// get the pager of datagrid

        pager.pagination({
            buttons:[{
                iconCls:'icon-search',
                handler:function(){
                    alert('search');
                }
            },{
                iconCls:'icon-add',
                handler:function(){
                    alert('add');
                }
            },{
                iconCls:'icon-edit',
                handler:function(){
                    alert('edit');
                }
            }]
        });
    })
</script>
</body>
</html>