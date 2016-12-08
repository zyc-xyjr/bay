var zTree;
var demoIframe;

var check_setting = {
    view: {
        dblClickExpand: false,
        showLine: true,
        selectedMulti: false,
        fontCss:{color:"#ffffff"}
    },
    data: {
        key:{
            name:"entryName"
        },
        simpleData: {
            enable:true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: ""
        }
    },
    callback: {
        beforeClick: function(treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("tree");
            if (treeNode.isParent) {
                zTree.expandNode(treeNode);
                return true;
            } else {
                demoIframe.attr("src",treeNode.file + ".html");
                return true;
            }
        },
        onClick:function zTreeOnClick(event, treeId, treeNode) {
            console.log(treeNode);
            $("#id").val(treeNode.id);
            $("#parentId").val(treeNode.parentId);
            $("#entryKey").val(treeNode.entryKey);
            $("#entryName").val(treeNode.entryName);
            $("#normalMinValue").val(treeNode.normalMinValue);
            $("#normalMaxValue").val(treeNode.normalMaxValue);
            $("#unit").val(treeNode.unit);
            $("#form").show();
            $("#itemForm").hide();
        }
    }
};


function loadReady() {
    var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
        htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
        maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
        h = demoIframe.height() >= maxH ? minH:maxH ;
    if (h < 530) h = 530;
    demoIframe.height(h);
}