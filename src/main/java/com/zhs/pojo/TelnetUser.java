package com.zhs.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
public class TelnetUser  implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String realname;

    private Integer gender;

    private String mobile;

    private Integer status;

    private Date createdTime;

    private Date updatedTime;

    private List<TelnetRole> roleList;

    private List<TelnetPermission> permissionList;
}