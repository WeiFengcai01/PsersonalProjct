package com.ling.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String username;
    private String password;
    private String token;

    @TableField(fill = FieldFill.INSERT)
    private String create_time;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String update_time;
    private int age;


}
