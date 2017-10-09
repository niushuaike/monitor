/**
 * Created by niushuaike on 2017/9/7.
 */
//调用日期插件
$('.warn-time').cxCalendar();

//处理弹窗
function deal_modal(){
    $('.deal_modal').show()
}
//关闭弹窗
function closeDel(){
    $('.deal_modal').hide();
}

function saveDel() {
    $('.deal_modal').hide();

    var url = "/monitor/bjm/warnlog/updateWarnLogOperationDetail";
    var params = {
        id: $("input[type='checkbox']:checked").eq(0).val(),
        operationDetail:$('#decriptionfirst').val()+$('#decriptionlast').val()
    }

    $.post(url, params, function (data) {
        if (data == 1) {
            layer.msg("处理成功！");
            initwarnlog(1);
        } else {
            layer.msg("处理失败！");
        }
    })
}

function deal_modal(){
    $('.deal_modal').show();
}


function deletewarnlog() {

        var url = "/monitor/bjm/warnlog/delete";
        var params = {
            id: $("input[type='checkbox']:checked").eq(0).val()
        }

        $.post(url, params, function (data) {
            console.log("shanchufanhui", data);
            if (data == 1) {
                layer.msg("删除成功！");
                initwarnlog(1);
            } else {
                layer.msg("删除失败！");
            }
        })
}

function initwarnlogC(page) {
    var url = "/monitor/bjm/warnlog/list";
    var params = {
        page:page,
        pageSize:10,
        warntypeid:$("#warntypeid").val(),
        starttime:$("#starttime").val(),
        endtime:$("#endtime").val()
    }

    $.post(url, params, function (data) {
        console.log("告警日志：",data);
        html = template('t:table_tmpevenC', {
            list: data.data.rows
        });

        $("#table_contenteventC").html(html);
        pagesC(data.data.total,page);
        initwarntype();
    })
}

function pagesC(total,page){
    $("#PaginationC").pagination(total, {
        num_edge_entries: 2,
        num_display_entries: 4,
        callback: function(pageIndex){
            initwarnlogC(pageIndex+1);
        },
        items_per_page:10,
        current_page:page-1
    });
}

function initwarnlogR(page) {
    var url = "/monitor/bjm/warnlog/list";
    var params = {
        page:page,
        pageSize:10,
        warntypeid:$("#warntypeid").val(),
        starttime:$("#starttime").val(),
        endtime:$("#endtime").val()
    }

    $.post(url, params, function (data) {
        console.log("告警日志：",data);
        html = template('t:table_tmpevenR', {
            list: data.data.rows
        });

        $("#table_contenteventr").html(html);
        pagesR(data.data.total,page);
        initwarntype();
    })
}

function pagesR(total,page){
    $("#Pagination").pagination(total, {
        num_edge_entries: 2,
        num_display_entries: 4,
        callback: function(pageIndex){
            initwarnlogC(pageIndex+1);
        },
        items_per_page:10,
        current_page:page-1
    });
}

function initwarntype(){
    var url = "/monitor/bjm/warnlog/initwarntype";
    var params = {
    }

    $.post(url, params, function (data) {
        html = template('t:warntype_tmp', {
            list: data
        });

        $("#warntypeid").html(html);
    })
}

function querywarnlogR() {
    $("#querywarnlogid").click(function () {
       initwarnlogR(1);
    })
}

function querywarnlogC() {
    $("#querywarnlogid").click(function () {
        initwarnlogC(1);
    })
}