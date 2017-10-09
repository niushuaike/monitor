//索引 根据索引进行编辑

$(function () {
    $('.gao-table input').attr('readonly', true)
})//初始化input为只读

//编辑
function edit() {
    $('.gao-table input').attr('readonly', false).css('border-color', '#ccc');
    $('.gao-con .gao-btn').show();

}
//取消
function gaoQuX(n) {
    n.parent().hide();
    $('.gao-table input').attr('readonly', true).css('border-color', '#e2e1e1');
}
//保存
function save() {
    $('.gao-table input').attr('readonly', true).css('border-color', '#e2e1e1');
    updatethreshold();
}


function initthreshold() {
    var url = "/monitor/bjm/alarmthreshold/queryByThresholdtype";
    var params = {
        thresholdtype:0
    }

    $.post(url, params, function (data) {
        $("#threshold_form").formEdit(data);
    })
}

function initdefaultthreshold() {
    var url = "/monitor/bjm/alarmthreshold/queryByThresholdtype";
    var params = {
        thresholdtype:1
    }

    $.post(url, params, function (data) {
        $("#threshold_default_form").formEdit(data);
    })
}

function updatethreshold() {
    var url = "/monitor/bjm/alarmthreshold/updateAlarmThreshold";
    var params = $("#threshold_form").serializeArray();

    $.post(url, params, function (data) {
        if (data == 1) {
            layer.msg("修改成功");
            initthreshold();
        } else {
            layer.msg("修改失败");
        }
    })
}

function updatedefaultthreshold() {
    var url = "/monitor/bjm/alarmthreshold/updateAlarmThreshold";
    var params = $("#threshold_default_form").serializeArray();

    $.post(url, params, function (data) {
        if (data == 1) {
            layer.msg("修改成功");
            yuzhiNotSave($("#setNot"));
            initthreshold();
        } else {
            layer.msg("修改失败");
        }
    })
}

function recoverDefault() {
    var url = "/monitor/bjm/alarmthreshold/recoverDefault";
    var params = {

    }
    $.post(url, params, function (data) {
        if (data == 1) {
            layer.msg("恢复成功");

            initthreshold();
        } else {
            layer.msg("恢复失败");
        }
    })
}


function yuzhiDefault() {
   $('.yuzhi_modal').show();

    initdefaultthreshold();

}
//关闭设定默认值弹窗
function yuzhiNotSave(obj) {
    obj.parents('.yuzhi_modal').hide();
}