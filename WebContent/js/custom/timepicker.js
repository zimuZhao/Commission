/**
 * 时间控件
 */
//时间初始化
var lastdate = moment().subtract(7, 'days').format('YYYY-MM-DD');//获取上一周年月日'yyyy/mm/dd'
var currdate = moment().format('YYYY-MM-DD');//获取当前年月日
var options = {"startDate": lastdate, "endDate": currdate};
var startTime, endTime;
$('#date-range-picker').daterangepicker(options, function (start, end, label) {
    //动态点选控件得到的时间value
    startTime = start.format('YYYY-MM-DD');
    endTime = end.format('YYYY-MM-DD');
    changeDateTime(startTime, endTime);
});
changeDateTime(lastdate, currdate);
