package com.zhs.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createtime;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date updatetime;

    private String ext1;

    private String ext2;

    private  Integer disable;


}