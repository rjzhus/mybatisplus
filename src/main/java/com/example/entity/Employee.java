package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Employee
 * @Description: TODO
 * @Author zrj
 * @Date 2020/7/11
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tbl_employee")
public class Employee {

    /**
     * 自增主键
     **/
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    /**
     * 映射数据库字段
     **/
    @TableField(value = "last_name")
    private String lastName;

    /**
     * 忽略数据库中不存在的字段
     **/
    @TableField(exist = false)
    private int salary;

    private String email;
    private int gender;
    private int age;
}
