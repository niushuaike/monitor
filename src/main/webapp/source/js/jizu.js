/**
 * Created by niushuaike on 2017/9/22.
 */

function initJZ() {
    var url = "/monitor/datap/getRecentOneP";
    var params = {}
    $.post(url, params, function (data) {
        console.log("机组信息：", data)
        $("#jizuff").formEdit(data);
    })
}

function warninfo() {
    var date = new Date();
    var url = "/monitor/bjm/warnlog/getwarninfo?data=" + date;
    var params = {
        data: ""
    }

    $.post(url, params, function (data) {
        html = template('warninfo_template', {
            list: data
        });

        $("#table_content").html(html);
        //上往下滚动
        $('.jizu_tit').liMarquee({
            direction: 'up',
            scrollamount: 20,
            hoverstop: false
        });

    })
}
var option;
var myChart;
function chartsJZ() {
    // 基于准备好的dom，初始化echarts实例
    myChart = echarts.init(document.getElementById('jizuth'));
    // 指定图表的配置项和数据
    option = {
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['温度']
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
                data: [37, 38, 39, 40, 50, 33, 66]
            }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    refreshJiZuChart();
    window.setInterval(refreshJiZuChart, 2 * 60 * 1000);
}
var requestFlag = 1;
function refreshJiZuChart() {
    var date = new Date();
    var url = "/monitor/data/getTHinfo?data=" + date;
    var params = {
        requestFlag: 1
    }
    $.post(url, params, function (data) {
        console.log("表格数据：", data);
        option.xAxis[0].data = data.time;
        option.series[0].data = data.temperature;
        myChart.setOption(option);
        requestFlag += 1;

    })
}