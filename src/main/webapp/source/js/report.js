$(function(){
	$('.report-state').click(function(){
		$('.state-list').show();
	})
	$('.report-state2').click(function(){
		$('.state-list2').show();
	})
})
//时间
	function nowDay(){
		var data=new Date();
		var year=data.getFullYear();
		var mon=data.getMonth()+1;
		var d=data.getDate();
		var h=data.getHours();
		var min=data.getMinutes();
		var now=year+'-'+mon+'-'+d;
		var now2=h+':'+min
		$('.rep-time').text(now);
		$('.rep-time2').text(now2);
	}
	setInterval("nowDay()",1000)
//关闭弹窗
$('.modal-header .close').click(function(){
	$(this).parent().parent().parent().parent().hide();
})

function initReport(page) {
    var url = "/monitor/jm/reportstatus/initReport";
    var params = {
        page:page,
        pageSize:10
    }

    $.post(url, params, function (data) {
    	console.log("报表data",data);
        html = template('tabletemplate1', {
            list: data.data.rows
        });

        $("#tablecontent1").html(html);
        pages(data.data.total,page);
    })
}

function pages(total,page){
    $("#Pagination").pagination(total, {
        num_edge_entries: 2,
        num_display_entries: 4,
        callback: function(pageIndex){
            initReport(pageIndex+1);
        },
        items_per_page:10,
        current_page:page-1
    });
}

function getStatusmy(statusno) {
    $('.state-list').show();
    var url = "/monitor/jm/reportstatus/getStatusmy";
    var params = {
    	statusno:statusno
	}

    $.post(url, params, function (data) {
        console.log("状态data",data);
        $("#ff_jgstatus").formEdit(data);
        html = template('tabletemplate2', {
            list: data.devicestatuslistmap
        });

        $("#tablecontent2").html(html);
    })
}

function getException(statusno) {
    $('.state-list2').show();
    var url = "/monitor/jm/reportstatus/getException";
    var params = {
    	statusno:statusno
	}

    $.post(url, params, function (data) {
        console.log("异常data",data);
        html = template('tabletemplate3', {
            list: data.warnlogList
        });

        $("#tablecontent3").html(html);
    })
}

function deletereportbyid() {

    $(".chk-body input[type=checkbox]").each(function () {
        if ($(this).is(':checked') == true) {
            alert("准备删除！");
            var mm = $(this);
            var url = "/monitor/jm/reportstatus/deletereportbyid";
            var params = {
                id:mm.val()
            }

            $.post(url, params, function (data) {
                console.log("删除",data);
                if(data==1){
                    alert("删除成功");
                    initReport();
                }else{
                    alert("删除失败");
                }
            })

        }

    })
}

function print1() {
    $("#printstatus").jqprint({operaSupport: true});
}

function print2() {
    $("#printexception").jqprint({operaSupport: true});
}