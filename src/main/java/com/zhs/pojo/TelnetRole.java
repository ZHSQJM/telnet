package com.zhs.pojo;


import lombok.Data;

import java.io.Serializable;

@Data
public class TelnetRole implements Serializable {
    private Integer id;

    private String roledesc;


}