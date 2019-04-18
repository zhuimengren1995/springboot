package com.springmybatis.springbootmybatis.service;


import com.springmybatis.springbootmybatis.controller.UserController;
import com.springmybatis.springbootmybatis.mapper.UserMapper;
import com.springmybatis.springbootmybatis.model.User;
import com.springmybatis.springbootmybatis.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author amc2533064395@163.com
 * @date 2019/4/15 16:41
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 先从缓存中获取，没有就查询数据库，然后写入redis
     * @param id
     * @return
     */
    public User findUserById(int id) {
        String key = "user-" + id;
        if (redisUtil.hasKey(key)) {
            Object user = redisUtil.get(key);
            logger.info(" 从缓存中查询的数据:  "+user);
            return (User) user;

        }
        User user = userMapper.findUserById(id);
        try{
        redisUtil.set(key, user);
        redisUtil.expire(key, 3600);
        }
        catch (Exception e){
            e.printStackTrace();
        }


        return userMapper.findUserById(id);
    }


    public boolean saveUser(User user) {
        return userMapper.saveUser(user);
    }


    public boolean deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }


    public boolean updateUserById(String name, int age, int sex, int id) {
        return userMapper.updateUserById(name, age, sex, id);
    }


}
