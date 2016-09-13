<#--
<!doctype html>
<html>
<head>

</head>
<body>
<div >
    <div >
        <form action="/admin/dictionary/pathogen/add" method="post">
            <div>

                <label>类型 ：</label>
                <select name="pathogenType" >
                    <option value="PHYSIOLOGY">生1</option>
                    <option value="PATHOLOGICAL">22</option>
                </select>

            </div>
            <div>
                <label>名称（描述）：</label>
                <input type="text" name="causeName" placeholder="描述">

            </div>


            <button type="submit" >提交</button>
        </form>
    </div>
</div>
</body>
</html>
-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic Form - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="/js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="/js/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="/js/themes/demo.css" />
<#--
    <script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.4.2/jquery-1.4.2.min.js"></script>
-->
    <script type="text/javascript" src="/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.js"></script>
</head>
<body>
<#--<h2>Basic Form</h2>
<p>Fill the form and submit it.</p>-->
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="New Topic" style="width:500px;height:600px;max-width:400px;padding:30px 60px;">
    <form id="ff" action="/admin/dictionary/pathogen/add" method="post">

        <div style="margin-bottom:20px">
            <select class="easyui-combobox" name="pathogenType" label="Language" style="width:100%">
                <option value="PHYSIOLOGY">生1</option>
                <option value="PATHOLOGICAL">22</option>
            </select>
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="causeName" style="width:100%" data-options="label:'Name:',required:true" placeholder="名称">
        </div>

    </form>
    <div style="text-align:center;padding:5px 0">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
    </div>
</div>
<script>

    function submitForm(){
        $('#ff').submit();
    }

</script>
</body>
</html>
