package com.zhs.util;

import com.zhs.pojo.TelnetPermission;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/13 15:05
 * 描述: 将权限的等级划分
 * 1
 *  1.1
 *  1.2
 * 2
 *  2.1
 *  2.2
 **/
public class PermissionUtils {

    public static List<TelnetPermission> createTree(Long parentId, List<TelnetPermission> permissions) {

        if (parentId == null || permissions == null || permissions.size() == 0) {
            return null;
        }

        List<TelnetPermission> permissionList = new ArrayList<>();

        for (TelnetPermission current : permissions) {
            if (current.getParentId().compareTo(parentId) == 0) {
                current.setChildren(createTree(current.getId(), permissions));
                permissionList.add(current);
            }
        }
        return permissionList;
    }
}
