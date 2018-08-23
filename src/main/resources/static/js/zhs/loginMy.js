//获取input的所有id
var user = document.getElementById("user");
var pwd = document.getElementById("pwd");



//获取span的所有id
var user_pass = document.getElementById("user_pass");
var pwd_pass = document.getElementById("pwd_pass");
function checkUser(){
    //如果昵称未输入，则提示输入昵称
    if(!user.value){
        user_pass.style.fontSize = "13px";
        user_pass.style.width="31%";
        user_pass.style.height="2em";
        user_pass.style.textAlign="center";
        user_pass.style.lineHeight="2em";
        user_pass.style.marginTop='0.05%'
        user_pass.innerHTML = '请填写您的用户名。';
        user_pass.style.display="block";
    }
    else if(user.value){
        user_pass.style.display="none";
    }
}
//输入密码提示
function checkUser1(){
    //如果未输入密码，则提示请输入密码
    if(!pwd.value){
        pwd_pass.style.fontSize = "13px";
        pwd_pass.style.width="31%";
        pwd_pass.style.height="2em";
        pwd_pass.style.textAlign="center";
        pwd_pass.style.lineHeight="2em";
        pwd_pass.innerHTML = '请填写您的用户密码';
        pwd_pass.style.display="block";
    }
    else{
        pwd_pass.innerHTML ='';
        pwd_pass.style.backgroundColor= "#fff";
        pwd_pass.style.border="none";
        pwd_pass.style.display="none";

    }
}
function login() {
    if(!user.value){
        user_pass.style.color = "red";
        user_pass.style.fontSize = "13px";
        user_pass.style.width="31%";
        user_pass.style.height="2em";
        user_pass.style.textAlign="center";
        user_pass.style.lineHeight="2em";
        user_pass.innerHTML = '请填写您的用户名';
        user.focus();
        return false;
    }
    if(!pwd.value){
        pwd_pass.style.color = "red";
        pwd_pass.style.fontSize = "13px";
        pwd_pass.style.width="31%";
        pwd_pass.style.height="2em";
        pwd_pass.style.textAlign="center";
        pwd_pass.style.lineHeight="2em";
        pwd_pass.innerHTML = '请填写您的用户密码';
        pwd.focus();
        return false;
    }
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "/login" ,//url
        data: $('#formOne').serialize(),
        success: function (data) {
            console.log(data);//打印服务端返回的数据(调试用)
            if (data.code == 200) {
                window.location.href=data.data;
            }else{
                $("#warning").html(data.message);
            }
        },
        error : function() {
            alert("异常！");
        }
    });
}

