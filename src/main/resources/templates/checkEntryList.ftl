<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="assets/css/admin.css">
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/app.js"></script>

</head>
<body>
<div style="width: 30%;float: left;">

    <ul class="am-list admin-sidebar-list">
    <#list checkEntryList as entry>
        <li class="am-panel">
            <a >
                <i class="am-icon-users am-margin-left-sm"></i> ${entry.entryName} <i class="am-icon-angle-right am-fr am-margin-right"></i>
            </a>
            <ul class="am-list am-collapse admin-sidebar-sub" id="user-nav">
                <#list entry.childrenEntries as child>
                    <li><a href="#/userAdd"><i class="am-icon-user am-margin-left-sm"></i> ${child.entryName}  </a></li>
                </#list>

            </ul>
        </li>
    </#list>



    </ul>
</div>
<div style="width: 70%;float: left">

    <div >
        <div >
            <form>
                <select data-am-selected>
                    <option value="a">Apple</option>
                    <option value="b" selected>Banana</option>
                    <option value="o">Orange</option>
                    <option value="m">Mango</option>
                    <option value="d" disabled>禁用鸟</option>
                </select>
                <div>

                    <input type="text" placeholder="取个名字">
                </div>
                <div>

                    <input type="text" placeholder="取个名字">
                </div>
                <button type="submit" class="am-btn am-btn-primary am-btn-block">注册个账号</button>
            </form>
        </div>
    </div>
</div>
<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->

</body>
</html>