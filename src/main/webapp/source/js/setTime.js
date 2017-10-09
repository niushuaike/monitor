/*编辑*/


function cancleAndSave() {
    /*取消*/
    $('.time-notSave').click(function () {
        $(this).hide();
        $(this).siblings().hide();
        var sel = $(this).parent().parent().find('select');
        sel.css('border', 'none');
        sel.attr('disabled', true);
        $('.time-ipt').css('border', 'none');
        $('.time-ipt').attr('readonly', true)
    })
    /*保存*/
    $('.time-save').click(function () {
        $(this).hide();
        $(this).siblings().hide();
        var sel = $(this).parent().parent().find('select');
        sel.css('border', 'none');
        sel.attr('disabled', true);
        $('.time-ipt').css('border', 'none');
        $('.time-ipt').attr('readonly', true)
    })
}

function toEdit() {
    var time_index;
    $('.time-table tbody tr').click(function () {
        time_index = $(this).index()
    })
    $('.time-edit').click(function () {
        $('.time-table span').show();
        $('.time-ipt').css('border', 'solid #ccc 1px');
        $('.time-ipt').attr('readonly', false)
        var sel = $('.time-table tbody tr').eq(time_index).find('select');
        sel.css('border', 'solid #ccc 1px')
        sel.attr('disabled', false)
    })
    cancleAndSave();
}

function initsaveconfig() {
    var url = "/monitor/jm/saveconfig/list";
    var params = {
        /*  page:page,
         warntypeid:$("#warntypeid").val(),
         starttime:$("#starttime").val(),
         endtime:$("#endtime").val()*/
    }

    $.post(url, params, function (data) {
        console.log("定时保存配置：", data);
        html = template('setTime_tmp', {
            list: data
        });

        $("#table_contentsetTime").html(html);
        toEdit();
    })
}

function savetimesave() {
    var url = "/monitor/jm/saveconfig/update";
    var params = {
        id: $("#id").val(),
        saveConfigTitle: $("#saveConfigTitle").val(),
        starttime: $("#starttime").val(),
        endtime: $("#endtime").val(),
        deltatime: $("#deltatime").val()
    }

    $.post(url, params, function (data) {
        if(data==1){
            layer.msg("修改成功");
            initsaveconfig();
        }else{
            layer.msg("修改失败");
        }
    })
}