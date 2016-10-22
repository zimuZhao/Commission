//$('#dataRange').daterangepicker({
//    "startDate": "10/10/2016",
//    "endDate": "10/16/2016"
//}, function (start, end, label) {
//    console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
//});

function changeDateTime(start, end) {
    salesCommission(start, end, 0);
    getSalesCommission(start, end);
    getSalesProportion(start, end);
}

var pagingNumber;
/** url请求失败
 * 佣金记录
 * @param start  开始时间 ("YYYY-MM")
 * @param end    结束时间 ("YYYY-MM")
 * @param pageNo   当前页（从0开始）
 */
var salesCommmission = $("#salesCommmission");
var node = salesCommmission.html();
function salesCommission(start, end, pageNo) {
    $.ajax({
        type: "POST",
        url: "selectCommissionByPage",
        dataType: "json",
        data: {
            startTime: start,
            endTime: end,
            pageNum: pageNo
        },
        async: true,
        cache: false,
        success: function (data) {
            if (data.status) {
                if (data.result != "[]") {
                    salesCommmission.html("");

                    $.each(data.result.datas, function (index, item) {
                        var titemnode = node;
                        if (index % 2 != 0) {
                            titemnode = titemnode.replace("success", "");
                        }
                        titemnode = titemnode.replace("{Date}", item.id);
                        titemnode = titemnode.replace("{Locks}", num);
                        titemnode = titemnode.replace("{Stocks}", item.name);
                        titemnode = titemnode.replace("{Barrels}", item.pv);
                        titemnode = titemnode.replace("{Sale}", item.uv);
                        titemnode = titemnode.replace("{basicCommission}", item.vt);
                        titemnode = titemnode.replace("{midCommission}", item.vt);
                        titemnode = titemnode.replace("{highCommission}", item.vt);
                        titemnode = titemnode.replace("{totalCommission}", item.vt);
                        salesCommmission.append(titemnode);
                    });
                    //让tbody显示
                    salesCommmission.removeClass("hidden");

                    pagingNumber = pageNo;

                    $("#paging").table({
                        pageNum: data.result.totalPage,
                        currentPage: pageNo,
                        jumpTo: function (current) {
                            pagenum = current;
                            //updateVisitRank(start, end, rank, current);
                        }
                    });

                }
            } else {
                hint("D", data.result);
            }
        },
        error: function (data) {
            hint("D", data.result);
        }
    });
}


var salesChart = echarts.init(document.getElementById('SalesTrend'));
var pieChart = echarts.init(document.getElementById('SalesProportion'));

/** 上一个ajax请求后 循环将L S B 数量分别加和填充
 * 饼图 销售占比(上月)
 */
function getSalesProportion(Lnum, Snum, Bnum) {
    pieChart.setOption({
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            x: 'center',
            y: 'bottom',
            data: ['Locks', 'Stocks', 'Barrels']
        },
        toolbox: {
            show: true,
            feature: {
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        series: [
            {
                name: 'Last Month',
                type: 'pie',
                radius: [30, 110],
                roseType: 'area',
                data: [
                    {value: Lnum, name: 'Locks'},
                    {value: Snum, name: 'Stocks'},
                    {value: Bnum, name: 'Barrels'}
                ]
            }
        ]
    });
}

/** 需要增加接口
 * 堆叠折线图 销售趋势(上月)
 */
function getSalesCommission(start, end) {
////        $.ajax({
////            type: "POST",
////            url: "",
////            dataType: "json",
////            data: {siteId: siteID, urlId: urlID, start: DRPstart, end: DRPend, period: Period},
////            async: true,
////            cache: false,
////            success: function (data) {
////                if (data.status) {
////                    if (data.result == "[]") {
////                    } else {
    salesChart.setOption({
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data: ['basicCommission', 'midCommission', 'highCommission']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'value'
        },
        yAxis: {
            type: 'category',
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        },
        series: [
            {
                name: 'basicCommission',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [320, 302, 301, 334, 390, 330, 320]
            },
            {
                name: 'midCommission',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [120, 132, 101, 134, 90, 230, 210]
            },
            {
                name: 'highCommission',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [220, 182, 191, 234, 290, 330, 310]
            }
        ]
    });
//                    }
//                } else {
//                    hint("D", data.result);
//                }
//                loading(8);
//            },
//            error: function (data) {
//                loading(8);
//                hint("D", data.result);
//            }
//        });
}

window.onresize = function () {
    salesChart.resize();
    pieChart.resize();
}
