/**
 * Created by niushuaike on 2017/9/7.
 */

function init() {
    var url = "/monitor/data/allinfo";
    var params = {
        data:""
    }

    $.post(url,params,function (data) {
        $("#temperature").html(data.temperature);
        $("#current1").text(data.current1);
        $("#frontGate").text(data.frontGate);
        $("#flood").text(data.flood);
        $("#humidity").text(data.humidity);
        $("#voltage").text(data.voltage);
        $("#backGate").text(data.backGate);
        $("#smoke").text(data.smoke);
        $("#infrared").text(data.infrared);
    })
}
