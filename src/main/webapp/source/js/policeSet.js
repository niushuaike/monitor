/*time*/
$('.datetimepicker').datetimepicker({
    datepicker: false,
    format: 'H:i',
    step: 5
});

/*Add 新增tr*/
function addtr() {
    var str = "<tr><td><input type='checkbox' value='-1'/></td><td></td><td><input type='text' name='ipt2'></td>" + "\r"
        + "<td><input type='text' class='datetimepicker'/><span>~</span><input type='text' class='datetimepicker'/><div class='pox' style='display: none;'></div></td>" + "\r"
        + "<td><input type='text' class='datetimepicker'/><span>~</span><input type='text' class='datetimepicker'/><div class='pox' style='display: none;'></div></td>" + "\r"
        + "<td><input type='text' class='datetimepicker'/><span>~</span><input type='text' class='datetimepicker'/><div class='pox' style='display: none;'></div></td>" + "\r"
        + "<td><input type='text' class='datetimepicker'/><span>~</span><input type='text' class='datetimepicker'/><div class='pox' style='display: none;'></div></td>" + "\r"
        + "<td><input type='text' class='datetimepicker'/><span>~</span><input type='text' class='datetimepicker'/><div class='pox' style='display: none;'></div></td>" + "\r"
        + "<td><input type='text' class='datetimepicker'/><span>~</span><input type='text' class='datetimepicker'/><div class='pox' style='display: none;'></div></td>" + "\r"
        + "<td><input type='text' class='datetimepicker'/><span>~</span><input type='text' class='datetimepicker'/><div class='pox' style='display: none;'></div><p><button class='police-notSave' onclick='notAddSave($(this))'>取消</button><button class='police-save' onclick='save($(this))'>保存</button></p></td></tr>"
    $('.chk-body').append(str);
    $('.datetimepicker').datetimepicker({
        datepicker: false,
        format: 'H:i',
        step: 5
    });
    $('.police-table tr:last').find("input[type=text]").css('border', 'solid #ccc 1px');
}

/*edit 编辑*/
$(function () {
    $(".police-edit").click(function () {

        $(".chk-body input[type=checkbox]").each(function () {
            if ($(this).is(':checked') == true) {
                $(this).parents("tr").find("input[type=text]").removeAttr("readonly");
                $(this).parents("tr").find("input[type=text]").css('border', 'solid #ccc 1px');
                $(this).parents("tr").find(".pox").hide();
                $(this).parents("tr").find("p").show()
            }
        })
    })

})

//保存  save
function save(obj) {
    console.log(1111);
    var ipt = obj.parents("tr").find("input[type=text]");
    ipt.attr("readonly", true)
    ipt.css({'border': 'none', 'background': 'none'});
    obj.parents("tr").find(".pox").show();
    obj.parent().hide();

    var url = "/monitor/jm/warntimeperiod/saveEdit";
    var params = {
        id: obj.parents("tr").find("input[type=checkbox]").eq(0).val(),
        timeperiodname:ipt.eq(0).val(),
        startmonday:ipt.eq(1).val(),
        endmonday:ipt.eq(2).val(),
        starttuesday:ipt.eq(3).val(),
        endtuesday:ipt.eq(4).val(),
        startwednesday:ipt.eq(5).val(),
        endwednesday:ipt.eq(6).val(),
        startthursday:ipt.eq(7).val(),
        endthursday:ipt.eq(8).val(),
        startfriday:ipt.eq(9).val(),
        endfriday:ipt.eq(10).val(),
        startsaturday:ipt.eq(11).val(),
        endsaturday:ipt.eq(12).val(),
        startsunday:ipt.eq(13).val(),
        endsunday:ipt.eq(13).val()
    }
    $.post(url, params, function (data) {
        if (data==1){
            alert("改动成功！");
            initPoliceSet();

        }else {
            alert("改动失败！");
        }
    });

}
//取消  notSave
function notSave(obj) {
    var str = '';
    var ipt = obj.parents("tr").find("input[type=text]");
    var v1 = ipt.eq(0).val();
    var v2 = ipt.eq(1).val();
    var v3 = ipt.eq(2).val();
    var v4 = ipt.eq(3).val();
    var v5 = ipt.eq(4).val();
    var v6 = ipt.eq(5).val();
    var v7 = ipt.eq(6).val();
    var v8 = ipt.eq(7).val();
    var v9 = ipt.eq(8).val();
    var v10 = ipt.eq(9).val();
    var v11 = ipt.eq(10).val();
    var v12 = ipt.eq(11).val();
    if (v1 == '' && v2 == '' && v3 == '' && v4 == '' && v5 == '' && v6 == '' && v7 == '' && v8 == '' && v9 == '' && v10 == '' && v11 == '' && v12 == '') {
        obj.parents('tr').remove();
    }

    else {
        ipt.attr("readonly", true)
        ipt.css({'border': 'none', 'background': 'none'});
        obj.parents("tr").find(".pox").show();
        obj.parent().hide();
    }

}

//取消  notSave
function notAddSave(obj) {
    obj.parents('tr').remove();
}

function initPoliceSet() {
    var url = "/monitor/jm/warntimeperiod/listpojo?";
    var params = {}

    $.post(url, params, function (data) {
        console.log("warnperiodpojo", data);
        html = template('t:table_tmp', {
            list: data
        });
        console.log("warnperhtml", html);

        $("#table_content").html(html);
    });
}

function deletewarnperiod() {
    $(".chk-body input[type=checkbox]").each(function () {
        if ($(this).is(':checked') == true) {
            var url = "/monitor/jm/warntimeperiod/delete?";
            var params = {
                id:$(this).val()
            }
            $.post(url, params, function (data) {
               if (data==1){
                   alert("删除成功！");
                   initPoliceSet();

               }else {
                   alert("删除失败！");
               }
            });
        }
    })
}
	

					 

		