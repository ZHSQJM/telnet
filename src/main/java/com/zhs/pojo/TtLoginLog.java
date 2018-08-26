package com.zhs.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TtLoginLog {
    private Integer id;

    private Integer loginid;

    private String loginname;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date logintime;

    private String loginip;

    private String ext1;

    private String ext2;

    private Integer disable;


}