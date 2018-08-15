package com.zhs.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class TelnetUserRole  implements Serializable {
    private Integer userid;

    private Integer roleid;


}