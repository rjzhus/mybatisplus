package com.example.mybatisplus;

import com.example.dao.UserMapper;
import com.example.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisplusApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void contextLoads() {

        List<User> users = userMapper.selectList( null );
        users.forEach( System.out::println );
    }

    @Test
    public void save() {
        System.out.println( ("----- save method test ------") );
        User user = new User( 6L, "jerry", 18, "jerry@163.com" );
        System.out.println( user );
        int insert = userMapper.insert( user );
        System.out.println( "插入行数" + insert );
    }

    @Test
    public void testSelect() {
        System.out.println( ("----- selectAll method test ------") );
        List<User> userList = userMapper.selectList( null );
        Assert.assertEquals( 5, userList.size() );
        userList.forEach( System.out::println );
    }

    @Test
    public void demo() {
        System.out.println( "--" + System.getProperty( "user.dir" ) );
    }
}
