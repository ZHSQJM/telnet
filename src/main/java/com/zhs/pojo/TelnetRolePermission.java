package com.zhs.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TelnetRolePermission  implements Serializable {
    private Long id;

    private Long roleId;

    private Long permissionId;

    private Integer status;

    private Date createdTime;

}