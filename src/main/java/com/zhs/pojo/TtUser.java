package com.zhs.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Data
public class TtUser implements Serializable {


    private Integer id;

    @NotNull(message="用户名不能为空")
    @Length(min=4,max=8,message = "用户名长度在4-8之间")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;


    private Integer enable;

    @Pattern(regexp="^1(3|4|5|7|8)\\d{9}$",message="手机号码格式错误")
    private String phone;

    @Pattern( regexp="^(\\\\d{18}$)|(^\\\\d{15}$)",message = "身份证号码不正确")
    private String idcard;

    private String realname;

    private Integer sex;

    private String salt;

    @Pattern( regexp="^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$",message = "邮箱格式不正确")
    private String email;

    private String address;

    private Date createtime;

    private Date updatetime;

    private String ext1;

    private String ext2;


}