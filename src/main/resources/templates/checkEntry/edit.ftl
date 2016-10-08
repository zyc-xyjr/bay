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
    <form id="ff" action="/admin/dictionary/checkEntry/add" method="post">
        <div style="margin-bottom:20px">
            <label>上级：</label>
            <select class="easyui-combobox" name="parentId" label="Language" style="width:100%">
                <option value="0">无</option>
                <#list parentEntries as entry>
                    <option value="${entry.id}">${entry.entryName}</option>
                </#list>
            </select>
        </div>
        <div style="margin-bottom:20px">
            <label>检查项名称：</label>
            <input class="easyui-textbox" name="entryName" style="width:100%" data-options="label:'Name:',required:true" placeholder="检查值名称：红细胞计数">
        </div>
        <div style="margin-bottom:20px">
            <label>检查项代码：</label>
            <input class="easyui-textbox" name="entryKey" style="width:100%" data-options="label:'Name:',required:true" placeholder="检查值代码">
        </div>
        <div style="margin-bottom:20px">
            <label>单位：</label>
            <input class="easyui-textbox" name="unit" style="width:100%" data-options="label:'Name:',required:true" placeholder="单位">
        </div>

        <p>添加检查项评估标准：</p>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="apendPreDiv(this);">添加</a>

        <div style="margin-bottom:20px">

            异常情况：<input class="easyui-textbox" name="itemLabel" style="width:75%" data-options="label:'Name:',required:true" placeholder="检查结果：中度偏低">
            区间：<input class="easyui-textbox" name="smallValue" style="width:30%"  >
            -<input class="easyui-textbox" name="bigValue" style="width:30%" >
            异常指标解析：<input class="easyui-textbox" name="analysis" style="width:75%" data-options="label:'Name:',required:true" placeholder="检查结果：中度偏低">
            诊疗建议：<input class="easyui-textbox" name="medicalAdvice" style="width:75%" data-options="label:'Name:',required:true" placeholder="检查结果：中度偏低">
            生活指导：<input class="easyui-textbox" name="lifeGuidance" style="width:75%" data-options="label:'Name:',required:true" placeholder="检查结果：中度偏低">
            就诊科室：<input class="easyui-textbox" name="clinicDepartment" style="width:75%" data-options="label:'Name:',required:true" placeholder="检查结果：中度偏低">

        <#--         <select class="easyui-combobox" name="pathogenId" label="Language" style="width:100%">
                         <#list pathogenList as pathogen>
                             <option value="${pathogen.id}">${pathogen.causeName}</option>
                         </#list>
                     </select>-->

        </div>
    </form>
    <div style="text-align:center;padding:5px 0">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
    </div>
</div>
<script>

    function apendPreDiv(obj){
        var htmStr=$(obj).next("div").html();
        $(obj).next("div").after("<div style=\"margin-bottom:20px\">"+htmStr+"</div>");
    }

    function submitForm(){
        $('#ff').submit();
    }

</script>
</body>
</html>