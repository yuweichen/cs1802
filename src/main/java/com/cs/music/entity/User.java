package com.cs.music.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode()
@TableName("users")
public class User extends Model<User> {
    private static final long serialVersionUID = 1L;
    private String username;

    private String password;

    private String role;

    @Override
    protected Serializable pkVal() {
        return username;
    }
}
