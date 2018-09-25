package com.bootdo.testDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {
//    @Autowired
//    RedisTemplate redisTemplate;
//
    @Test
    public void test() {
        String s = "com.bootdo.seahigh.lte";
        s = s.replace("com.bootdo.","");
        System.out.println(s);
        String[] paths = s.split("\\.");
        System.out.println(paths.length);
        System.out.println("------------------------");
        String pathName = "";
        for (String path:paths){
            pathName+=path+"/";
        }
        pathName = pathName.substring(0,pathName.length()-1);
        System.out.println(pathName);
        System.out.println("eeeeennnnnnnnndddddddddddddd");
    }

    ;
}
