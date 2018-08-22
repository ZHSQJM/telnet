package com.zhs.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TtRolePermission implements Serializable {
    private Integer id;

    private Integer roleid;

    private Integer resourcesid;

    private Date createtime;

    private Date updatetime;

    private String ext1;

    private String ext2;

    private  Integer disable;

}