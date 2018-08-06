package com.zhs.pojo;

import lombok.Data;

import java.util.Date;


@Data
public class TelnetRole {
    private Integer id;

    private String name;

    private Date createTime;

    private String description;

    private Integer disabled;

    private String ext1;

    private String ext2;


}