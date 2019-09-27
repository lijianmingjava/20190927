package com.lanxin.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    String getPassWordByUserName(String username);

    List<String> getRolesByUserName(String username);

    List<String> getPermissionsByUserName(String username);

}
