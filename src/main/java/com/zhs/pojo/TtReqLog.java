package com.zhs.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TtReqLog {
    private Integer id;

    private String requrl;

    private String way;

    private String method;

    private String code;

    private Long time;

    private String username;

    private String ip;

    private String ext1;

    private String ext2;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date reqtime;


}