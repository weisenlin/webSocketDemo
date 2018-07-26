package com.socket.service;

import com.socket.domain.User;
import com.socket.dto.UserDto;

/**
 * create by WSL_SILVA
 * 日期: 2018/7/26 0026
 * 用途：
 * 描述:
 */
public interface UserService {

    int save(UserDto userDto);

    User findByEmail(String email);
}
