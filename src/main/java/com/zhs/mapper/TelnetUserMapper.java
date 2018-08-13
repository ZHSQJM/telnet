package com.zhs.mapper;

import com.zhs.pojo.TelnetUser;

public interface TelnetUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TelnetUser record);

    int insertSelective(TelnetUser record);

    TelnetUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TelnetUser record);

    int updateByPrimaryKey(TelnetUser record);

    TelnetUser selectUserByUserName(String username);
}