function changeDateTime(start, end) {
    salesHistoryReport(start, end, 0);
}

var pagingNumber;
/**
 * {"data":[],"totalPages":1}
 * 销售历史记录
 * @param startTime  开始时间 (YYYY-MM-DD")
 * @param endTime    结束时间 ("YYYY-MM-DD")
 * @param pageNum   当前页（从0开始）
 */
var salesHistory = $("#salesHistory");
var node = salesHistory.html();
function salesHistoryReport(start, end, pageNo) {
    $.ajax({
        type: "POST",
        url: "selectSalesRecordByPage",
        dataType: "json",
        data: {
            startTime: start,
            endTime: end,
            pageNum: pageNo
        },
        async: true,
        cache: false,
        success: function (data) {
            if (data.data != "[]" || data.data != "") {
                salesHistory.html("");

                var num = 0;//序号
                $.each(data.data, function (index, item) {
                    var titemnode = node;
                    if (index % 2 != 0) {
                        titemnode = titemnode.replace("success", "");
                    }
                    titemnode = titemnode.replace("{Num}", item.Num);
                    titemnode = titemnode.replace("{Date}", item.Date.substring(0, 10));
                    titemnode = titemnode.replace("{Area}", item.Area);
                    titemnode = titemnode.replace("{locksNum}", item.Locks);
                    titemnode = titemnode.replace("{stocksNum}", item.Stocks);
                    titemnode = titemnode.replace("{barrelsNum}", item.Barrels);
                    salesHistory.append(titemnode);
                });
                //让tbody显示
                salesHistory.removeClass("hidden");

                pagingNumber = pageNo;

                $("#paging").table({
                    pageNum: data.totalPages,
                    currentPage: pageNo,
                    jumpTo: function (current) {
                        pagenum = current;
                        //updateVisitRank(start, end, rank, current);
                    }
                });

            }
            loading(1);
        },
        error: function () {
            hint("D", "Request failed!");
            loading(1);
        }
    });
}