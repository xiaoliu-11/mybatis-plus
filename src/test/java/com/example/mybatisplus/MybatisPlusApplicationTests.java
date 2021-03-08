package com.example.mybatisplus;

import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    //获取user表所有数据
    @Test
    void getData() {
         List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    //增加数据手动设置主键ID
//    @Test
//    void insertData() {
//        User user = new User(6l,"张三",20,"1223@qq.com");
//         int result = userMapper.insert(user);
//        System.out.println("返回结果，1代表插入成功，0代表失败："+result);
//    }

    //增加数据不设置主键ID(由mybatis_plus自动生成主键。)
    //利用snowflake算法自动生成一个19位的Long型ID.
    @Test
    void insertDataOne() {
        User user = new User();
        user.setAge(40);
        user.setName("李四四");
        user.setEmail("1221233@qq.com");
        int result1 = userMapper.insert(user);
        System.out.println("返回结果，1代表插入成功，0代表失败："+result1);
    }

    //删除数据
    @Test
    void deleteData() {

    }
    //修改数据
    @Test
    void updateData() {
        User user = new User();
        user.setId(1368889981593976833l);
        user.setName("修改了数据");
        user.setEmail("1231231@qq.com");
         int row = userMapper.updateById(user); //返回的数据是影响的行数
    }
    //条件查询（复杂查询）


}
