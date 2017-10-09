/*动力参数设置页*/
$(function(){
    var ipt=$('.power-table input')
    $('.worker-edit').click(function(){
        ipt.css('border-color','#ccc');
        ipt.attr('readonly',false);
        $('.jigui_footer').show();
    })//编辑
    $('.worker-notSave').click(function(){
        ipt.css('border-color','#e2e1e1');
        ipt.attr('readonly','readonly');
        $('.jigui_footer').hide();
    })//取消
})
//修改默认设定值弹窗
function jiguiNotSave(obj) {
    obj.parents('.jigui_modal').hide();
}
//修改设定默认值弹窗出现
function jiguiDefault(){
   $('.jigui_modal').show();

    initCanibetDefaultSet();
}
function initCanibetSet() {
    var url = "/monitor/bjm/cabinetSet/queryParameterByType";
    var params = {
        parametertype:0
    }

    $.post(url, params, function (data) {
        $("#powerSetForm").formEdit(data);
    })
}

function initCanibetDefaultSet() {
    var url = "/monitor/bjm/cabinetSet/queryParameterByType";
    var params = {
        parametertype:1
    }

    $.post(url, params, function (data) {
        $("#powerDefaultSetForm").formEdit(data);
    })
}

function updateParameter() {
    var url = "/monitor/bjm/cabinetSet/updateCabinetByType";
    var params = $("#powerSetForm").serializeArray();

    $.post(url, params, function (data) {
        if (data == 1) {
            layer.msg("修改成功");
            initCanibetSet();
        } else {
            layer.msg("修改失败");
        }
    })
}

function updateDefaultParameter() {
    var url = "/monitor/bjm/cabinetSet/updateCabinetByType";
    var params = $("#powerDefaultSetForm").serializeArray();

    $.post(url, params, function (data) {
        if (data == 1) {
            layer.msg("修改成功");
            jiguiNotSave($("#powersetnot"));
            initCanibetDefaultSet();
        } else {
            layer.msg("修改失败");
        }
    })
}


function recoverCabinetSetDefault() {
    var url = "/monitor/bjm/cabinetSet/recoverDefault";
    var params = {

    }
    $.post(url, params, function (data) {
        if (data == 1) {
            layer.msg("恢复成功");
            initCanibetSet();
        } else {
            layer.msg("恢复失败");
        }
    })
}