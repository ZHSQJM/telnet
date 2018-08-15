package com.zhs.pojo;


import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Data
public class TelnetPermission implements Serializable {
    private Integer id;

    private String name;

    private String resurl;

    private Integer type;

    private Integer parentid;

    private Integer sort;

    //所有的子菜单  注解是为了在通用mapper时忽略
    @Transient
    private List<TelnetPermission> list;

}