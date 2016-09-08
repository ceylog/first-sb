package cn.wglgg.spring.cloud.service;

import cn.wglgg.spring.cloud.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by gang on 9/9/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveUser() throws Exception {
        User u = new User();
        u.setUserName("wanggang");
        u.setPassword("123456");
        u.setAddTime(new Date());
        u.setEmail("finalsin@foxmail.com");
        u.setMobile("18516766689");
        u.setStatus(1);
        userService.saveUser(u);
    }

    @Test
    public void findUserTest(){
        for(int i=0;i<10;i++) {
            userService.findByUserName("wanggang");
        }
    }
}