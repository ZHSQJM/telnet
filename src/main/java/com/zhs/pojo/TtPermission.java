package com.zhs.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TtPermission implements Serializable {
    private Integer id;

    @NotNull(message = "资源名称不能为空")
    private String name;

    private String icon;

    @NotNull(message = "权限码不能为空")
    private String perms;

    @NotNull(message = "资源地址不能为空")
    private String resurl;

    @NotNull(message = "资源类型不能为空")
    private Integer type;

    @NotNull(message = "父资源不能为空")
    private Integer parentid;

    private Integer sort;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createtime;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date updatetime;

    private String ext1;

    private String ext2;

    private  Integer disable;

    private List<TtPermission> list;

}