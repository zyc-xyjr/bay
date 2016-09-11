<!doctype html>
<html>
<head>

</head>
<body>
<div >
    <div >
        <form action="/admin/dictionary/checkEntry/add" method="post">
            <div>

                上级：<select name="parentId" >
                <option value="0">无</option>
            </select>
                名称：<input type="text" name="entryName" placeholder="设个密码">
                代码：<input type="text" name="entryKey" placeholder="填下邮箱">
            </div>

            <div>
                范围：<input type="text" name="itemLabel" placeholder="">
                描述：<input type="text" name="itemSection" placeholder="">
                <a >添加</a>
            </div>
            <div>
                范围：<input type="text" name="itemLabel" placeholder="">
                描述：<input type="text" name="itemSection" placeholder="">
                <a >添加</a>
            </div>
            <button type="submit" >注册个账号</button>
        </form>
    </div>
</div>
</body>
</html>
