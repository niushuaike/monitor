/*动力参数设置页*/
$(function(){
    var ipt=$('.power-table input')
    $('.worker-edit').click(function(){
        ipt.css('border','solid #ccc 1px');
        ipt.attr('readonly',false)
    })//编辑
    $('.worker-notSave').click(function(){
        ipt.css('border','none');
        ipt.attr('readonly','readonly')
    })//取消
})


function initCanibetSet() {
    var url = "/monitor/bjm/cabinetSet/queryOnlyOne";
    var params = {}

    $.post(url, params, function (data) {
        $("#powerSetForm").formEdit(data);
    })
}

function updatethreshold() {
    var url = "/monitor/bjm/cabinetSet/updateCabinet";
    var params = $("#powerSetForm").serializeArray();

    $.post(url, params, function (data) {
        if (data == 1) {
            alert("修改成功");
            initCanibetSet();
        } else {
            alert("修改失败");
        }
    })
}

function recoverCabinetSetDefault() {
    var url = "/monitor/bjm/cabinetSet/recoverDefault";
    alert("开始请求！");
    var params = {

    }
    $.post(url, params, function (data) {
        if (data == 1) {
            alert("恢复成功!");
            initCanibetSet();
        } else {
            alert("恢复失败!");
        }
    })
}