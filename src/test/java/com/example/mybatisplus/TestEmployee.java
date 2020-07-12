package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.EmployeeMapper;
import com.example.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TestMP
 * @Description: TODO
 * @Author zrj
 * @Date 2020/7/11
 * @Version V1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEmployee {

    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 删除数据
     */
    @Test
    public void testdelete() {
        System.out.println( ("----- delete method test ------") );
        Employee employee = new Employee();
        employee.setId( 6 );
        employee.setLastName( "hello" );
        employee.setAge( 32 );
        employee.setGender( 0 );
        employee.setEmail( "hello@163.com" );

        int insert = employeeMapper.deleteById( employee.getId() );
        System.out.println( "删除行数" + insert );
    }

    /**
     * 更新数据
     */
    @Test
    public void testUpdate() {
        System.out.println( ("----- update method test ------") );
        Employee employee = new Employee();
        employee.setId( 6 );
        employee.setLastName( "hello" );
        employee.setAge( 32 );
        employee.setGender( 0 );
        employee.setEmail( "hello@163.com" );

        int insert = employeeMapper.updateById( employee );
        System.out.println( "更新行数" + insert );
    }

    /**
     * 插入数据
     */
    @Test
    public void testInsert() {
        System.out.println( ("----- save method test ------") );
        Employee employee = new Employee();
        employee.setLastName( "kubuter" );
        employee.setAge( 20 );
        employee.setGender( 1 );
        employee.setEmail( "aliyun@163.com" );
        employee.setSalary( 100 );
        System.out.println( employee );

        int insert = employeeMapper.insert( employee );
        System.out.println( "插入行数" + insert );

        //获取数据主键值
        int id = employee.getId();
        System.out.println( "主键值：" + id );

    }

    /**
     * 查询数据
     */
    @Test
    public void testSelect() {
        System.out.println( ("----- selectAll method test ------") );
        List<Employee> employeeList = employeeMapper.selectList( null );
        //Assert.assertEquals( 5, employeeList.size() );
        employeeList.forEach( System.out::println );
    }

    /**
     * 简单分页查询
     */
    @Test
    public void testSelectPage() {
        System.out.println( ("----- selectAll method test ------") );

        int pageNum = 1;
        int pageSize = 2;
        Page<Employee> page = new Page<>( pageNum, pageSize );
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>().gt( "age", "20" );
        //QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>().gt( "age", "20" );
        IPage<Employee> mpUserIPage = employeeMapper.selectPage( page, queryWrapper );

        System.out.println( "总计：" + mpUserIPage.getSize() );
        mpUserIPage.getRecords().forEach( System.out::println );
    }


}
