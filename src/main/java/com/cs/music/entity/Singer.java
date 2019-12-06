package com.cs.music.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode()
@TableName("singer")
public class Singer extends Model<Singer> {
    private static final long serialVersionUID = 1L;
    private Long singerid;
    private String singername;
    private int singergender;
    private String description;
    private String contrytype;

    @Override
    protected Serializable pkVal() {
        return singerid;
    }
}