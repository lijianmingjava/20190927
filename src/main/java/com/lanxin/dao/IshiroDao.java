package com.lanxin.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by 李建明 on 2019/9/26.
 */

@Mapper
public interface IshiroDao {

    public String selectPassByusername(String username);




}
