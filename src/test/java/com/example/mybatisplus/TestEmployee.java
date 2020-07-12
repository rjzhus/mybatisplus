package com.example.mybatisplus;

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

    @Test
    public void testInsert() {
        System.out.println( ("----- save method test ------") );
        Employee employee = new Employee();
        employee.setLastName( "jerry" );
        employee.setAge( 18 );
        employee.setGender( 1 );
        employee.setEmail( "jerry@163.com" );
        System.out.println( employee );

        int insert = employeeMapper.insert( employee );
        System.out.println( "插入行数" + insert );

    }

    @Test
    public void testSelect() {
        System.out.println( ("----- selectAll method test ------") );
        List<Employee> employeeList = employeeMapper.selectList( null );
        //Assert.assertEquals( 5, employeeList.size() );
        employeeList.forEach( System.out::println );
    }
}
