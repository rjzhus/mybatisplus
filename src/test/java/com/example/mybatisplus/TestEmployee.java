package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        employee.setId( 1 );
        employee.setLastName( "mybatis" );
        employee.setAge( 32 );
        employee.setGender( 0 );
        employee.setEmail( "mybatis@163.com" );

        //会进行非空判断
        //int insert = employeeMapper.updateById( employee );
        //System.out.println( "按Id更新行数" + insert );

        //按条件更新
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>().eq( "age", "66" );
        int insertWrp = employeeMapper.update( employee, queryWrapper );
        System.out.println( "按条件更新行数" + insertWrp );
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

        /*//查询所有
        List<Employee> employeeList = employeeMapper.selectList( null );
        employeeList.forEach( System.out::println );

        //根据id查询
        Employee employee = employeeMapper.selectById( 1 );
        System.out.println( "根据id查询：" + employee );

        //根据id集合查询
        List<Integer> idList = new ArrayList( 10 );
        idList.add( 1 );
        idList.add( 2 );
        List employees = employeeMapper.selectBatchIds( idList );
        employees.forEach( System.out::println );

        //通过多个列查询,eq的值只能是数据库字段值，否则报错
        //根据条件只能返回一条，否则报错
        Wrapper<Employee> wrapper = new QueryWrapper<Employee>().eq( "last_name", "bear" );
        Employee employee1 = employeeMapper.selectOne( wrapper );
        System.out.println( "employee：" + employee1 );*/

        //通过map查询 Map<表字段名, 值>
        Map<String, Object> columnMap = new HashMap<>( 16 );
        //columnMap.put( "last_name", "aliyun" );
        columnMap.put( "age", 20 );
        List<Employee> employeeList1 = employeeMapper.selectByMap( columnMap );
        employeeList1.forEach( System.out::println );

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
        Page<Employee> userIPage = employeeMapper.selectPage( page, null );

        //内存分页，假分页，不能分页
        System.out.println( "总计：" + userIPage.getSize() );
        userIPage.getRecords().forEach( System.out::println );
    }


}
