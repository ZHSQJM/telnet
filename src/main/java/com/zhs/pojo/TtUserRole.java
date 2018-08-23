package com.zhs.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TtUserRole  implements Serializable {
    private Integer id;

    private Integer userid;

    private Integer roleid;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createtime;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date updatetime;

    private String ext1;

    private String ext2;

    private  Integer disable;


}