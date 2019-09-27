package com.lanxin.service;

import java.util.List;

public interface UserService {
    String getPassWordByUserName(String username);

    List<String> getRolesByUserName(String username);

    List<String> getPermissionsByUserName(String username);
}
