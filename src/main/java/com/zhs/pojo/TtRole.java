package com.zhs.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Data
public class TtRole implements Serializable {
    private Integer id;


    @NotNull(message ="角色名不能为空")
    private String rolename;

    private String roledesc;

    private Date createtime;

    private Date updatetime;

    private String ext1;

    private String ext2;

    private  Integer disable;


}