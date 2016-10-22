$(function () {
    $("#form").Validform(
        {
            tiptype: function (msg, o, cssctl) {
                if (!o.obj.is("form")) {
                    var form_group = o.obj.closest('.form-group');
                    var infoObj = form_group.find("label.error");
                    if (infoObj.size() == 0) {
                        infoObj = $('<label class="error"></label >');
                        form_group.append(infoObj);
                    }
                    if (o.type == 2) {
                        form_group.addClass('has-success').removeClass(
                            'has-error');

                        infoObj.fadeOut(200);
                    } else {
                        form_group.removeClass('has-success').addClass(
                            'has-error');

                        infoObj.html(msg);
                        if (infoObj.is(":visible")) {
                            return;
                        }
                        infoObj.show().animate({
                            top: top - 35
                        }, 200);
                    }
                }
            },
            beforeSubmit: function () {
                updateUser();
                return false;
            }
        });

    $("#cancel").click(function () {
        window.location.reload();
    });
});

/* url请求失败*/
function updateUser() {

    var newSalesman = checkUser();
    if (newSalesman == null) {
        return;
    }
    newSalesman = JSON.stringify(newSalesman);
    console.log("USER: " + newSalesman);
    $.ajax({
        type: "POST",
        url: "updatenewSalesman",
        dataType: "json",
        contentType: "application/json",
        data: newSalesman,
        async: false,
        cache: false,
        success: function (data) {
            console.log("updatenewSalesman return: " + JSON.stringify(data));
            if (data.status == "true") {
                hint("S", "Successfully modified!", "Please log back in to see the changes~");
            } else {
                hint("D", "Update failed", data.result);
            }
        }
    });
}

function checkUser() {
    var newSalesman = {};
    newSalesman.name = $("#name").val();
    newSalesman.linkman = $("#linkman").val();
    newSalesman.email = $("#email").val();
    newSalesman.mobile = $("#mobile").val();
    newSalesman.address = $("#address").val();

    if (newSalesman.name == "" || newSalesman.linkman == "" || newSalesman.email == "" || newSalesman.mobile == "") {
        hint("W", "The name,linkman,email,mobile can not be null!");
        return null;
    } else {
        return newSalesman;
    }

}