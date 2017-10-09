function systemEdit(){
	$('.self_con .weizhi').attr('readonly',false).css('border','solid #ccc 1px');
	$('.system_btn').show();
}

//保存
function systemSave(){
    $('.self_con .weizhi').attr('readonly',true).css('border','solid #E0E0E0 1px');
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
        $('#deviceAddress').val(data.deviceaddress);
        $('#deviceIp').val(data.deviceIp);
        $('#machinecode').val(data.machinecode);
        $('#mainControlIp').val(data.maincontrolip);
    })

}

function systemSave2Database() {
    var url = "/monitor/jm/device/updateAddr";
    var params = {
        deviceAddress:$('#deviceAddress').val(),
        mainControlIp:$('#mainControlIp').val()
    }

    $.post(url, params, function (data) {
        if(data==1){
            layer.msg("保存成功");
        }else{
            layer.msg("保存失败");
        }
    })

}
