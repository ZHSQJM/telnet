package com.zhs.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class TelnetUser  implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Integer enable;


}