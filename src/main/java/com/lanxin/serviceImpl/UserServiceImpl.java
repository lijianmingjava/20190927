package com.lanxin.serviceImpl;

import com.lanxin.dao.UserDao;
import com.lanxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public String getPassWordByUserName(String username) {
        return userDao.getPassWordByUserName(username);
    }

    @Override
    public List<String> getRolesByUserName(String username) {
        return userDao.getRolesByUserName(username);
    }

    @Override
    public List<String> getPermissionsByUserName(String username) {
        return userDao.getPermissionsByUserName(username);
    }
}
