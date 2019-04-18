package com.springmybatis.springbootmybatis.controller;


import com.springmybatis.springbootmybatis.model.User;
import com.springmybatis.springbootmybatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * 用户基本CRUD
 * @author amc2533064395@163.com
 * @date 2019/4/15 16:48
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value = {"/find"}, method = RequestMethod.GET)
    public User findUserById(int id) {
        User user = userService.findUserById(id);
        logger.info(" user {}", user.getName());
        return user;


    }

    /**
     * 新增user
     * @param name,age,sex
     * @return
     */
    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public boolean saveUser(String name, int age, int sex) {
        User user=new User();
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        boolean b = userService.saveUser(user);
        return b;


    }

    /**
     * 删除user
     * @param id
     * @return
     */
    @RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
    public boolean deleteUserById(int id) {
        boolean b = userService.deleteUserById(id);
        return b;


    }

    /**
     * @param id
     * @return
     */
    @RequestMapping(value = {"/update"})
    public boolean updateUserById(int id ,String name,int age,int sex) {
        User user = findUserById(id);
        boolean b = userService.updateUserById(name==null?user.getName():name, age==0?user.getAge():age, sex==0?user.getSex():sex, id);
        return b;


    }
}
