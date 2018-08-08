package com.zhs.pojo;

import com.zhs.base.BasePojo;
import lombok.Data;

import java.util.Date;


@Data
public class TelnetResource  extends BasePojo {
    private Integer id;

    private String name;

    private Integer parentid;

    private String url;

    private String icon;

    private String permission;

    private Date createTime;

    private Integer disabled;

    private Integer sort;

    private Integer type;

    private String ext1;

    private String ext2;


}