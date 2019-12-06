package com.cs.music.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cs.music.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}