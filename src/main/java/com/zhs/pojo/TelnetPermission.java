package com.zhs.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Data
public class TelnetPermission implements Serializable {
    private Long id;

    private String name;

    private String type;

    private String path;

    private String permission;

    private Long parentId;

    private String parentIds;

    private Integer state;

    private Date createdTime;

    private Date updatedTime;

    private boolean checked;


    private List<TelnetPermission> children;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelnetPermission that = (TelnetPermission) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}