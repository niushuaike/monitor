//索引 根据索引进行编辑

$(function () {
    $('.gao-table input').attr('readonly', true)
})//初始化input为只读

//编辑
function edit() {
    $('.gao-table input').attr('readonly', false).css('border-color', '#ccc')
}
//保存
function save() {
    $('.gao-table input').attr('readonly', true).css('border-color', '#e2e1e1');
    updatethreshold();
}


function initthreshold() {
    var url = "/monitor/bjm/alarmthreshold/queryOnlyOne";
    var params = {}

    $.post(url, params, function (data) {
        $("#threshold_form").formEdit(data);
    })
}

function updatethreshold() {
    var url = "/monitor/bjm/alarmthreshold/updateAlarmThreshold";
    var params = $("#threshold_form").serializeArray();

    $.post(url, params, function (data) {
        if (data == 1) {
            alert("修改成功");
            initthreshold();
        } else {
            alert("修改失败");
        }
    })
}

function recoverDefault() {
    var url = "/monitor/bjm/alarmthreshold/recoverDefault";
    alert("开始请求！");
    var params = {

    }
    $.post(url, params, function (data) {
        if (data == 1) {
            alert("恢复成功!");
            initthreshold();
        } else {
            alert("恢复失败!");
        }
    })
}