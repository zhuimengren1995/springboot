package com.springmybatis.springbootmybatis.util;

/**
 * @author amc2533064395@163.com
 * @date 2019/4/20 13:21
 */
public enum  SexEnmu {
    men("男",1), women("女",2);
    private String sexs;
    private  int index;

    SexEnmu(String sexs, int index) {
        this.sexs = sexs;
        this.index = index;
    }
}
