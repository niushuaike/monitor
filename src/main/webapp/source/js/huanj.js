/**
 * Created by niushuaike on 2017/9/7.
 */



function inithuanj() {
    var date = new Date();
    var url = "/monitor/data/allinfo?data=" + date;
    var params = {
        data: ""
    }

    $.post(url, params, function (data) {
        console.log("机柜环境：", data);
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

function devicestatus() {
    var date = new Date();
    var url = "/monitor/data/getDeviceStatus?data=" + date;
    var params = {
        data: ""
    }

    $.post(url, params, function (data) {
        $("#deviceStatus").text(data.deviceStatus);
    })
}

function warninfo() {
    var date = new Date();
    var url = "/monitor/bjm/warnlog/getwarninfo?data=" + date;
    var params = {
        data: ""
    }

    $.post(url, params, function (data) {
        console.log("告警信息：", data);
        html = template('warninfo_template', {
            list: data
        });
        $("#table_contenthuanj").html(html);
        //上往下滚动
        $('.huanj_tit').liMarquee({
            direction: 'up',
            scrollamount: 20,
            hoverstop: false
        });
    })
}

var option;
var myChart;
function chartsTH() {
    // 基于准备好的dom，初始化echarts实例
    myChart = echarts.init(document.getElementById('main'));
    // 指定图表的配置项和数据
    option = {
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['温度', '湿度']
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                data: ['00:00', '00:00', '00:00', '00:00', '00:00', '00:00', '00:00']
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '温度',
                type: 'line',
                stack: '总量',
                data: [37.0, 37.0, 37.0, 37.0, 37.0, 37.0, 37.0]
            },
            {
                name: '湿度',
                type: 'line',
                stack: '总量',
                data: [60, 60, 60, 60, 60, 60, 60]
            }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    refreshchart();
    window.setInterval(refreshchart, 2 * 60 * 1000);
}
var requestFlag = 1;
function refreshchart() {
    var date = new Date();
    var url = "/monitor/data/getTHinfo?data=" + date;
    var params = {
        requestFlag: 1
    }
    $.post(url, params, function (data) {
        console.log("表格数据：", data);
        option.xAxis[0].data = data.time;
        option.series[0].data = data.temperature;
        option.series[1].data = data.humidity;
        myChart.setOption(option);
        requestFlag += 1;

    })
}
