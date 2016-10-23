getMonthlyReport();

var monthlyReport = $("#monthlyReport");
var node = monthlyReport.html();
function getMonthlyReport() {
    $.ajax({
        type: "POST",
        url: "commissionAction",
        dataType: "json",
        async: true,
        cache: false,
        success: function (data) {
            if (data.status) {
                if (data.result != "[]") {
                    monthlyReport.html("");

                    var num = 0;//序号
                    $.each(data.result.datas, function (index, item) {
                        num++;
                        var titemnode = node;
                        if (index % 2 != 0) {
                            titemnode = titemnode.replace("success", "");
                        }
                        titemnode = titemnode.replace("{salesmanID}", item.salesmanID);
                        titemnode = titemnode.replace("{salesDate}", salesDate);
                        titemnode = titemnode.replace("{locksum}", item.locksum);
                        titemnode = titemnode.replace("{stocksum}", item.stocksum);
                        titemnode = titemnode.replace("{barrelsum}", item.barrelsum);
                        titemnode = titemnode.replace("{totalPrice}", item.totalPrice);
                        titemnode = titemnode.replace("{totalCommission}", item.totalCommission);

                        monthlyReport.append(titemnode);
                    });
                    monthlyReport.removeClass("hidden");
                }
            } else {
                hint("D", "There is no data of this month!");
            }
        },
        error: function () {
            hint("D", "Request failed!");
        }
    });
}

