package com.cs.music.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cs.music.entity.User;
import com.cs.music.mapper.UserMapper;
import com.cs.music.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
}
