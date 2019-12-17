package com.cs.music.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cs.music.entity.Singer;
import com.cs.music.mapper.SingerMapper;
import com.cs.music.service.ISingerService;
import org.springframework.stereotype.Service;

@Service
public class SingerService extends ServiceImpl<SingerMapper, Singer> implements ISingerService {
}
