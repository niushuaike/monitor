/**
 * Created by niushuaike on 2017/9/11.
 */
/*全选反选*/
$('.allChk').click(function () {
    if (this.checked) {

        $(".chk-body :checkbox").prop("checked", true);

    }
    else {
        $(".chk-body :checkbox").prop("checked", false);

    }
})
$('.allChk2').click(function () {
    if (this.checked) {

        $(".chk-body2 :checkbox").prop("checked", true);

    }
    else {
        $(".chk-body2 :checkbox").prop("checked", false);

    }
})

//编辑弹窗
$('.jigui-btn').click(function () {
    toeditCaseSet();
    $('.jigui_modal').show();

})

$('.jigui_sel').click(function () {
    $('.jigui_modal').hide();
    initusers();
    $('.jigui_modal2').show();
})
/*冻结弹窗出现*/
$('.report-btn .btn-warning').click(function () {
    $('.report-btn .block').fadeToggle(500)
})
/*冻结弹窗关闭*/
$('.fadin').click(function () {
    $('.block').fadeOut(500)
})

/*单选按钮状态*/
/*$('.jigui_modal input[type=radio]').change(function () {
    if ($("#sex-1").is(':checked')) {
        $('.mail').show();
    }
    else {
        $('.mail').hide();
    }
})*/
//取消  关闭
function closeOpen(obj) {
    obj.parents('.modal_close').hide();
}

function initdevicewarnset() {
    var url = "/monitor/jm/device/getdevicepojoselflist";
    var params = {}

    $.post(url, params, function (data) {
        console.log("机柜设置：", data);
        html = template('t:table_tmp', {
            list: data
        });
        console.log("html", html);
        $("#table_content").html(html);
    })
}

function toeditCaseSet() {
    $(".chk-body input[type=checkbox]").each(function () {
        if ($(this).is(':checked') == true) {
            var mm = $(this);
            var url = "/monitor/jm/device/toadd";
            var params = {
                data: ""
            }
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
                var url = "/monitor/jm/device/getDeviceById";
                var params = {
                    id: mm.val()
                }
                console.log("开始获取但设备信息。。。。");
                $.post(url, params, function (data) {
                    console.log("获取到设备信息：", data);
                    $("#deviceNameModal").val(data.device.deviceName);
                    $("#timeperiodModal").val(data.device.timeperiod);
                    $("#deviceIdModal").val(data.device.id);
                    $("#deviceTypeModal").val(data.device.deviceType);
                    $("#warnstyle input[value='" + data.device.warnstyleid + "']").attr("checked", true);

                    if ($("#warnstyle input[value='" + data.device.warnstyleid + "']").val() == 1) {
                        var struserssubmit = "";
                        var struserss = "";
                        for (var i = 0; i < data.usersList.length; i++) {
                            struserss += data.usersList[i].username;
                            struserssubmit += data.usersList[i].id;
                        }
                        console.log("user 和 id",struserss+"--"+struserssubmit);
                        $('#userssubmit').val(struserssubmit);
                        $('#users').val(struserss);
                        $('#repeattime').val(data.device.intervaltime);

                        $('.mail').show();
                    }

                    $('.modal-01 input[type=radio]').change(function () {

                        if ($("#sex-1").is(':checked')) {
                            $('.mail').show();
                        }
                        else if ($("#sex-1").is(':checked')) {
                            $('.mail').hide();
                        }
                    });

                });

            })
        }
    })
}


function saveEdit() {
    var data = $("#formadd").serialize();
    var url = "/monitor/jm/device/saveedit?" + data;
    var params = {}
    console.log("请求数据data", data);
    $.post(url, params, function (data) {
        if (data == 1) {
            alert("修改成功！");
            $('.modal-01').hide();
        } else {
            alert("修改失败");
            $('.modal-01').hide();
        }
        initdevicewarnset()
    });
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
                alert("冻结成功！");
                $('.block').fadeOut(500)
                initdevicewarnset();
            } else {
                alert("冻结失败！");
                $('.block').fadeOut(500)
            }
        })
    })

}

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
