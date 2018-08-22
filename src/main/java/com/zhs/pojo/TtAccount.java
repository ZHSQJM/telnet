package com.zhs.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class TtAccount {
    private Integer id;

    @NotNull(message = "网站地址不能为空")
    private String website;

    @NotNull(message = "网站名不能为空")
    private String webname;

    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "昵称不能为空")
    private String nickname;

    @NotNull(message = "注册手机号码不能为空")
    private String phone;

    @NotNull(message = "密码不能为空")
    private String password;

    private Date createtime;

    private Date updatetime;

    @NotNull(message = "所属者不能为空")
    private Integer userid;

    private String email;

    private String disabled;

    private String ext1;

    private String ext2;

}