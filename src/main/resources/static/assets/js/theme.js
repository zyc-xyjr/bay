var saveSelectColor = {
    'Name': 'SelcetColor',
    'Color': 'theme-black'
}



// 判断用户是否已有自己选择的模板风格
if (storageLoad('SelcetColor')) {
    $('body').attr('class', storageLoad('SelcetColor').Color)
} else {
    storageSave(saveSelectColor);
    $('body').attr('class', 'theme-black')
}


// 本地缓存
function storageSave(objectData) {
    localStorage.setItem(objectData.Name, JSON.stringify(objectData));
}

function storageLoad(objectName) {
    if (localStorage.getItem(objectName)) {
        return JSON.parse(localStorage.getItem(objectName))
    } else {
        return false
    }
}
/**
 * 基础请求方法
 * @param u
 * @param m
 * @param t
 * @param func
 */
function baseRequest(u,m,t,func){
    console.log("request before...");
    $.ajax({
        url:u,
        async:true,
        type:m,
        dataType:t,
        success:function(data){
            console.log("request success...");
            console.log(data);
            if (data.status==0){
                console.log("执行回调函数...");
                func(data.data);
            } else {
                console.log("请求失败,提示错误信息..."+data.msg);
                alert(data.msg);
            }
        },
        error:function(request,msg,obejct){
            console.log("request error..."+msg+"_"+obejct);
        }
    })
    console.log("request after...");

}

/**
 * 上传数据
 * @param u
 * @param d
 */
function postRequest(u,d,func){
    console.log("post request before...");
    $.ajax({
        url:u,
        async:true,
        data:d,
        type:"POST",
        dataType:"json",
        success:function(data){
            console.log("post request success...");
            if (data.status==0){
                console.log("执行回调函数...");
                alert("提交成功");
            } else {
                console.log("请求失败,提示错误信息..."+data.msg);
                alert(data.msg);
            }
        },
        error:function(request,msg,obejct){
            console.log("post request error..."+msg+"_"+obejct);
        }
    })
    console.log("post request after...");
}