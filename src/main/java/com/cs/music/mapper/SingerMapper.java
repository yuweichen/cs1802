package com.cs.music.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cs.music.entity.Singer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SingerMapper extends BaseMapper<Singer> {

}