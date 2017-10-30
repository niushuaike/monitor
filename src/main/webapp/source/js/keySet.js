$('#editModal input[type=radio]').change(function () {
    if ($("#sex-3").is(':checked')) {
        $('.mail').show();
    }
    else {
        $('.mail').hide();
    }
})

/*冻结弹窗出现*/
$('.tit-btn .btn-warning').click(function () {
    $('.tit-btn .block').fadeToggle(500)
})
/*冻结弹窗关闭*/
$('.fadin').click(function () {
    $('.block').fadeOut(500)
})

/*添加*/
$('.key-btn').click(function () {
    $('.modal-01 input').val("");
    toadd();
    $('.modal-01').show()
})

$('.modal-sel').click(function () {
    $('.modal-01').hide();
    initusers();
    $('.modal-02').show();
})
/*编辑*/
$('.key-edit').click(function () {
    $('.modal-01 input').val("");
    toedit();
    $('.modal-01').show()
})
$('button.close').click(function () {
    $(this).parent().parent().parent().parent().hide();
})
/*取消*/
$('.modal-01 .btn-default').click(function () {
    $('.modal-01').hide();
})
$('.modal-02 .btn-default').click(function () {
    $('.modal-02').hide();
})


/*初始化表格*/
function init() {
    var url = "/monitor/jm/device/list";
    var params = {
        data: ""
    };

    $.post(url, params, function (data) {
        var str = "";
        for (var i = 0; i < data.length; i++) {
            str = str + "<tr>" +
                "<td><input type=" + "\"checkbox\"" + " name=" + "\"id\"" + " id=" + "\"deviceid" + data[i].devicebase.id + "\"" + " value=" + "\"" + data[i].devicebase.id + "\"" + " /></td>" +
                "<td>" + (i + 1) + "</td>" +
                "<td>" + data[i].devicebase.deviceName + "</td>" +
                "<td>" + data[i].devicebase.deviceIp + "</td>" +
                "<td>" + data[i].devicestatus + "</td>" +
                "<td>" + data[i].warntimeperiod + "</td>" +
                "<td>" + data[i].warnstyle + "</td>" +
                "<td>" + data[i].users + "</td>" +
                "<td>" + data[i].intervaltime + "</td>" +
                "</tr>";
        }
        $("#list").html(str);

    })
}

/*弹窗 添加 并初始化 时间段方案，告警方式，添加用户弹窗*/
function toadd() {
    var url = "/monitor/jm/device/toadd";
    var params = {
        data: ""
    }

    $.post(url, params, function (data) {
        console.log(data);

        var str1 = "";
        for (var i = 0; i < data.warntimeperiod.length; i++) {
            str1 += "<option name='warnperiod' value='" + data.warntimeperiod[i].id + "'>" + data.warntimeperiod[i].timeperiodname + "</option>";
        }
        $("#timeperiodModal").html(str1);
        console.log("str1", str1);

        var str2 = "";
        for (var i = 0; i < data.warnstyle.length; i++) {
            str2 += "<label class=\"radio-inline\">" +
                "   <input type=\"radio\" id=\"sex-" + data.warnstyle[i].id + "\" name=\"warnstyleid\" value=\"" + data.warnstyle[i].id + "\"> " + data.warnstyle[i].warnstylename + "" +
                "</label>";
        }
        console.log("str2", str2);
        $("#warnstyle").html(str2);

        $("#warnstyle input[type='radio']").attr("checked", true)

        $('.modal-01 input[type=radio]').change(function () {

            if ($("#sex-1").is(':checked')) {
                $('.mail').show();
            }
            else  {
                $('.mail').hide();
            }
        });
        $('#btn-sava').unbind("click");
        $('#btn-sava').click(function () {
            saveadd();
        })

    })
}

/*初始化用户列表，设置选择用户点击事件*/
function initusers() {
    var url = "/monitor/jm/user/listusers";
    var params = {};
    var str = "";
    $.post(url, params, function (data) {
        console.log("初始化的用户列表：", data);
        for (var i = 0; i < data.length; i++) {
            str += "<tr>" +
                "<td><input type='checkbox' name='u' id='userid" + data[i].id + "' value='" + data[i].id + "' /></td>" +
                "<td id='name" + data[i].id + "'>" + data[i].username + "</td>" +
                "<td>" + data[i].email + "</td>" +
                "<td>" + data[i].phone + "</td>" +
                "<td>" + data[i].role + "</td>" +
                "</tr>";
        }
        $("#selectuser").html(str);
    });

    $("#btn_selectuser").click(function () {

        var l = $("input[name='u']:checked");
        var strid = "";
        var strname = "";
        for (var i = 0; i < l.length; i++) {
            var id = l.val();
            var name = $("#name" + id).text();
            if (i == 0) {
                strid += id;
                strname += name;
            } else {
                strid = strid + "," + id;
                strname = strname + "," + name;
            }
        }
        $("#users").val(strname);
        $("#userssubmit").val(strid);

        $('.modal-02').hide();

        $('.modal-01').show();
    });

}


/*保存添加设备*/
function saveadd() {
    var data = $("#formadd").serialize();
    var url = "/monitor/jm/device/saveadd?" + data;
    var params = {
        /* "submitparam":data*/
    }

    $.post(url, params, function (data) {
        if (data == 1) {
            layer.msg("添加成功！");
            $('.modal-01').hide();
            init();
        } else {
            layer.msg("添加失败");
            $('.modal-01').hide();
        }

    });

}

function toedit() {
    var url = "/monitor/jm/device/toadd";
    var params = {
        data: ""
    }
    $('#deviceId').val($("input[name='id']:checked").val());
    $.post(url, params, function (data) {

        var str1 = "";
        for (var i = 0; i < data.warntimeperiod.length; i++) {
            str1 += "<option name='warnperiod' value='" + data.warntimeperiod[i].id + "'>" + data.warntimeperiod[i].timeperiodname + "</option>";
        }
        $("#timeperiodModal").html(str1);

        var str2 = "";
        for (var i = 0; i < data.warnstyle.length; i++) {
            str2 += "<label class=\"radio-inline\">" +
                "   <input type=\"radio\" id=\"sex-" + data.warnstyle[i].id + "\" name=\"warnstyleid\" value=\"" + data.warnstyle[i].id + "\"> " + data.warnstyle[i].warnstylename + "" +
                "</label>";
        }
        $("#warnstyle").html(str2);
        console.log("准备获取但设备信息。。。。");
        var url = "/monitor/jm/device/getDeviceById";
        var params = {
            "id": $("input[name='id']:checked").val()
        }
        console.log("开始获取但设备信息。。。。");
        $.post(url, params, function (data) {
            console.log("获取到设备信息：", data);
            $("#deviceNameModal").val(data.device.deviceName);
            $("#deviceTypeModal").val(data.device.deviceType);
            $("#deviceIpModal").val(data.device.deviceIp);
            $("#devicePortModal").val(data.device.devicePort);
            $("#loginNameModal").val(data.device.loginName);
            $("#loginPassedModal").val(data.device.loginPasswd);
            $("#timeperiodModal").val(data.device.timeperiod);
            $("#warnstyle input[value='" + data.device.warnstyleid + "']").attr("checked", true);

            if ($("#warnstyle input[value='" + data.device.warnstyleid + "']").val() == 1) {
                var struserssubmit = "";
                var struserss = "";
                for (var i = 0; i < data.usersList.length; i++) {
                    struserss += data.usersList[i].username;
                    struserssubmit += data.usersList[i].id;
                }
                $('#userssubmit').val(struserssubmit);
                $('#users').val(struserss);

                $('.mail').show();
            }

            $('.modal-01 input[type=radio]').change(function () {

                if ($("#sex-1").is(':checked')) {
                    $('.mail').show();
                }
                else {
                    $('.mail').hide();
                }
            });
        });

        $('#btn-sava').unbind("click");
        $('#btn-sava').click(function () {
            saveedit();
        })

    })
}


function saveedit() {
    var data = $("#formadd").serialize();
    var url = "/monitor/jm/device/saveedit?" + data;
    var params = {
        /* "submitparam":data*/
    }

    $.post(url, params, function (data) {
        if (data == 1) {
            layer.msg("变动成功！");
            $('.modal-01').hide();
            init();
        } else {
            layer.msg("变动失败");
            $('.modal-01').hide();
        }

    });
}

function deletebyid() {


    $("#deletebyid").click(function () {
        if($(".chk-body :checkbox").is(':checked')==false)
        {
            $('.del').show();
        }
        else{

        }
        var url = "/monitor/jm/device/delete";
        var params = {
            id: $("input[name='id']:checked").val()
        }

        $.post(url, params, function (data) {
            console.log("shanchufanhui", data);
            if (data == 1) {
                layer.msg("删除成功！");
                init();
            } else {
                layer.msg("删除失败！");
            }
        })

    })

}
//删除关闭
function closeDel(n){
    n.parents('.del').hide();
}

function savepause() {

    $("#savepauseid").click(function () {
        var url = "/monitor/jm/device/pauseDeviceWarnConfig";
        var params = {
            id: $("input[name='id']:checked").val(),
            intervaltime: $("#intervaltimeid").val()
        }

        $.post(url, params, function (data) {
            if (data == 1) {
                layer.msg("冻结成功！");
                init();
            } else {
                layer.msg("冻结失败！");
            }
        })
    })

}
