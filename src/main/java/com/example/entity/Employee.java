package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String lastName;
    private String email;
    private int gender;
    private int age;
}
