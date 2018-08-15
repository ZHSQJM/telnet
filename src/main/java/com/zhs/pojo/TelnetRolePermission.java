package com.zhs.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class TelnetRolePermission  implements Serializable {
    private Integer roleid;

    private Integer resourcesid;

}