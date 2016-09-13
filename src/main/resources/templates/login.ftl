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
<form action="/sysUser/login" method="post" class="easyui-window" title="请先登录" data-options="modal:true,closed:true,iconCls:'Lockgo',closable:false,minimizable:false" style="width:400px;height:300px;padding:20px 70px 20px 70px;">

    <div style="margin-bottom:10px">
        用户名：<input class="easyui-textbox" name="username" style="width:80%;height:7px;padding:12px" data-options="prompt:'登录邮箱',iconCls:'icon-man',iconWidth:38">
    </div>
    <div style="margin-bottom:20px">
        密码：<input class="easyui-textbox" name="password" type="password" style="width:80%;height:7px;padding:12px" data-options="prompt:'登录密码',iconCls:'icon-lock',iconWidth:38">
    </div>

    <div style="text-align:center;padding:5px 0">
        <button class="easyui-linkbutton" type="submit" style="width:80px">登录</button>
    </div>


</form>

</body>
</html>