package com.socket.service.impl;

import com.socket.Enum.UserStatusEnum;
import com.socket.domain.User;
import com.socket.dto.UserDto;
import com.socket.mapper.UserMapper;
import com.socket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * create by WSL_SILVA
 * 日期: 2018/7/26 0026
 * 用途：
 * 描述:
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional
    public int save(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPswd(userDto.getPassword());
        user.setCreateTime(new Date());
        user.setStatus(UserStatusEnum.USER_ON_USE.getCode());
        return userMapper.insertSelective(user);
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }
}
