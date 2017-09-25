function systemEdit(){
	$('.self_con select').attr('disabled',false);
	$('.self_con textarea').attr('readonly',false);
	$('.system_btn').show();
}
//省三级调用
_init_area();
//保存
function systemSave(){
	$('.self_con select').attr('disabled',true);
	$('.self_con textarea').attr('readonly',true);
	$('.system_btn').hide();
    systemSave2Database()
}

function systemInit() {
    var mm = $(this);
    var url = "/monitor/jm/device/querySelfDevice";
    var params = {
        deviceType:1
    }

    $.post(url, params, function (data) {
        console.log("fanhuidizhi",data);

        var s=["s_province","s_city","s_county"];//三个select的name
        opt0 = [data.provice,data.city,data.county];//初始值
        _init_area();
        $('#deviceAddress').val(data.machinecode);
        $('#s_detail').val(data.detail);
        $('#deviceIp').val(data.deviceip);
    })

}

function systemSave2Database() {
    var url = "/monitor/jm/device/updateAddr";
    var params = {
        deviceAddress:$('#s_province').val()+' '+$('#s_city').val()+' '+$('#s_county').val()+' '+$('#s_detail').val()+' '
    }

    $.post(url, params, function (data) {
        if(data==1){
            alert("保存成功");
        }else{
            alert("保存失败");
        }
    })

}
