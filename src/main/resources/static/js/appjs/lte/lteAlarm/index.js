var prefix = "/lte/lteAlarm";
$().ready(function() {
    drawLine();
    drawPie();
    drawPie2();
});
function drawLine() {
    var lineoption = {
        title : {
            text: '过去一周告警数量'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['告警设备数','正常设备数']
        },
        grid:{
            x:40,
            x2:40,
            y2:24
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['周一','周二','周三','周四','周五','周六','周日']
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLabel : {
                    formatter: '{value}'
                }
            }
        ],
        series : [
            {
                name:'正常设备数',
                type:'line',
                data:[100, 96, 110, 87, 121, 65, 129],
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name: '平均值'}
                    ]
                }
            },
            {
                name:'告警设备数',
                type:'line',
                data:[50, 54, 40, 63, 29, 85, 21],
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name : '平均值'}
                    ]
                }
            }
        ]
    };
    var lineChart = echarts.init(document.getElementById("echarts-line-chart"));
    lineChart.setOption(lineoption);
    $(window).resize(lineChart.resize);

}

function drawPie() {
    var pieChart = echarts.init(document.getElementById("echarts-pie-chart"));
    var pieoption = {
        title : {
            text: '告警分类',
            subtext: '2018年10月22日',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            data:['设备掉线','显卡烧毁','区域断电','负载过大','人为破坏']
        },
        calculable : true,
        series : [
            {
                name:'告警原因',
                type:'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:35, name:'设备掉线'},
                    {value:31, name:'显卡烧毁'},
                    {value:23, name:'区域断电'},
                    {value:13, name:'负载过大'},
                    {value:15, name:'人为破坏'}
                ]
            }
        ]
    };
    pieChart.setOption(pieoption);
    $(window).resize(pieChart.resize);
}



function drawPie2() {
    var pieChart = echarts.init(document.getElementById("echarts-pie2-chart"));
    var pieoption = {
        title : {
            text: '告警统计',
            subtext: '2018年10月22日',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            data:['告警设备数量','正常设备数量']
        },
        calculable : true,
        series : [
            {
                name:'告警统计',
                type:'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:85, name:'告警设备数量'},
                    {value:65, name:'正常设备数量'}
                ]
            }
        ]
    };
    pieChart.setOption(pieoption);
    $(window).resize(pieChart.resize);
}
function openDetail() {
    layer.open({
        type : 2,
        title : 'BBU告警详情',
        maxmin : true,
        shadeClose : true, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/detail' // iframe的url
    });
}