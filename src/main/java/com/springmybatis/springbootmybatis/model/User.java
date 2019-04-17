package com.springmybatis.springbootmybatis.model;

import java.io.Serializable;

/**
 * @author amc2533064395@163.com
 * @date 2019/4/15 15:58
 */

public class User implements Serializable {
    /**
     * 实体ID
     */
    private  int Id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private  int age;
    /**

     * 性别
     * 1 男
     * 2 女
     */
    private  int sex;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }


    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
