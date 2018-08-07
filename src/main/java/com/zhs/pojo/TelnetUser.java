package com.zhs.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class TelnetUser {
    @ApiModelProperty(value = "主键，不需要填写，填写有可能报错")
    private Integer id;

    @NotNull(message="用户名不能为空")
    @Length(min=6,max = 12,message="用户名长度必须位于6到12之间")
    @ApiModelProperty(value = "用户名")
    private String username;


    @ApiModelProperty(value = "真实姓名")
    private String realname;

    @NotNull(message="密码不能为空")
    @Length(min=6,message="密码长度不能小于6位")
    @ApiModelProperty(value = "密码")
    private String password;


    @ApiModelProperty(value = "手机号码")
    @NotNull(message="手机号码不能为空")
    @Pattern(regexp = "^[1](([3][0-9])|([4][5,7,9])|([5][^4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$",message = "手机号码格式不正确")
    private String phonenumber;

    @ApiModelProperty(value = "是否可用，默认 不需要填写")
    private String disabeld;

    @ApiModelProperty(value = "身份证号")
    @Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message = "身份证格式错误")
    private String idnumber;

    @ApiModelProperty(value = "创建时间，默认  不需要填写")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private Date createTime;

    @ApiModelProperty(value = "住址")
    private String address;

    private String sex;

    @ApiModelProperty(value = "备用1")
    private String ext1;

    @ApiModelProperty(value = "备用2")
    private String ext2;


}