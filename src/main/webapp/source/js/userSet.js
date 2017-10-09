//添加
function addper() {
    var url = "/monitor/jm/user/listrole";
    var params = {}
    $.post(url, params, function (data) {
        var strrole = "";

        for (var i = 0; i < data.length; i++) {
            strrole += "<option value='" + data[i].id + "'>" + data[i].rolename + "</option>"
        }
        var str = "<tr><td><input type='checkbox' value='-1'/></td>" + "\r"
            + "<td>2</td>" +
            "<td><input type='text' value='' id='username' style='border:solid #ccc 1px'/></td>" + "\r"
            + "<td><input type='text' value='' id='password' style='border:solid #ccc 1px'/></td>" + "\r"
            + "<td><input type='text' value='' id='realname' style='border:solid #ccc 1px'/></td>" + "\r"
            + "<td><input type='text' value='' id='email' style='border:solid #ccc 1px'/></td>" + "\r"
            + "<td><input type='text' value='' id='phone' style='border:solid #ccc 1px'/></td>" + "\r"
            + "<td><select id='roleid'>" + strrole + "</select></td>" + "\r"
            + "<td><p class='person-p'><span class='time-notSave'onclick='usenot($(this))'>取消</span><span class='time-save' onclick='save($(this))'>保存</span></p></td></tr>";
        $('.yonghu-table .chk-body').append(str);
    })


}


function editper() {
    $(".chk-body input[type=checkbox]").each(function (){
        if ($(this).is(':checked') == true) {
            var mm = $(this);
            var ipt = mm.parents("tr").find("input[type=text]");
            ipt.attr('readonly', false);
            ipt.css("border", "solid #ccc 1px");
            var ipsel = mm.parents("tr").find("select");
            ipsel.attr('disabled',false);
            ipsel.removeClass("nosel");
            ipsel.addClass("select1");
            mm.parents("tr").find("p").show();
        }
    });

}

//取消
function usenot(obj) {
    var str = '';
    var ipt = obj.parents("tr").find("input[type=text]");
    var v1 = ipt.eq(0).val();
    var v2 = ipt.eq(1).val();
    var v3 = ipt.eq(2).val();
    var v4 = ipt.eq(3).val();
    var v5 = ipt.eq(4).val();
    if (v1 == '' && v2 == '' && v3 == '' && v4 == '' && v5 == '') {
        obj.parents("tr").remove();
    }
    else {
        ipt.attr('readonly', true);
        ipt.css('border', 'none');
        var val = obj.parents("tr").find('option:selected').text();
        obj.parents("tr").find('select').replaceWith("<input type='text' value='' />");
        obj.parents("tr").find('input[type=text]').eq(5).val(val);
        obj.parent().hide();

    }
}
//保存
function save(obj) {
    var ipt = obj.parents("tr").find("input[type=text]");
    var v1 = ipt.eq(0).val();
    var v2 = ipt.eq(1).val();
    var v3 = ipt.eq(2).val();
    var v4 = ipt.eq(3).val();
    var v5 = ipt.eq(4).val();
    var v6 = obj.parents("tr").find("select").eq(0).val();
    var v7 =  obj.parents("tr").find("input[type=checkbox]").eq(0).val();
    var url = "/monitor/jm/user/saveEdit";
    var params = {
        id:v7,
        username: v1,
        password: v2,
        realname: v3,
        email: v4,
        phone: v5,
        role: v6
    };
    $.post(url, params, function (data) {
        if (data == 1) {
            layer.msg("变动成功");
            inituseraccess();
        } else {
            layer.msg("变动失败");
        }
    })

    var save_ipt = obj.parents('tr').find("input[type=text]");
    save_ipt.css('border', 'none');
    save_ipt.attr('readonly', true);
    var val = obj.parents('tr').find('option:selected').text();
    obj.parents('tr').find('select').replaceWith("<input type='text' value='' />");
    obj.parents('tr').find('input[type=text]').eq(5).val(val);
    obj.parent().hide();


}


function inituseraccess() {
    var url = "/monitor/jm/user/list";
    var params = {}

    $.post(url, params, function (data) {
        console.log("用户信息：", data);
        html = template('userSet_tmp', {
            list: data
        });

        $("#table_contentuserSet").html(html);
    })
}

function deleteuser() {

    $(".chk-body input[type=checkbox]").each(function () {
        if ($(this).is(':checked') == true) {
            var mm = $(this);

            var url = "/monitor/jm/user/delete";
            var params = {
                id:$(this).val()
            }

            $.post(url, params, function (data) {
                if (data == 1) {
                    layer.msg("删除成功");
                    inituseraccess();
                } else {
                    layer.msg("删除失败");
                }
            })
        }

    })

}