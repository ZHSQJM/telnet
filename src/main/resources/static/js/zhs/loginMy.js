function login() {
    var username=$("#username").val();
    var password=$("#password").val();
    if(username==""||username==null){
        $("#waring").html("请输入用户名");
        return false;
    }
    if(password==""||password==null){
        $("#waring").html("请输入密码");
        return false;
    }
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/login" ,//url
        data: $('#loginform').serialize(),
        success: function (data) {
            if (data.code == 200) {
                window.location.href=data.data;
            }else{
                $("#waring").html(data.message);
            }
        },
        error : function() {
            alert("异常！");
        }
    });
}

function register() {

    var username = $("#username").val();
    var password = $("#password").val();
    var realname = $("#realname").val();
    var flag = $("input[type='checkbox']").is(':checked');
    if (realname == "" || realname == null) {
        $("#waring").html("请输入真实姓名");
        return false;
    }
    if (password == "" || password == null) {
        $("#waring").html("请输入密码");
        return false;
    }
    if (username == "" || username == null) {
        $("#waring").html("请输入用户名");
        return false;
    }
    if (flag == false) {
        $("#waring").html("无法注册");
        return false;
    }
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/user/add",//url POST /user/add
        data: $('#registerform').serialize(),
        success: function (data) {
            if (data.code == 200) {
                alert("注册成功")
                window.location.href = "/tologin";
            } else {
                $("#waring").html(data.message);
            }
        },
        error: function () {
            alert("注册失败");
        }
    });
}
//倒计时  返回登陆页面
    var cancel_flag = 0;
    var already = 0;



