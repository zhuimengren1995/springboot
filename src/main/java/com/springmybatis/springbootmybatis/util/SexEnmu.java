package com.springmybatis.springbootmybatis.util;

/**
 * @author amc2533064395@163.com
 * @date 2019/4/20 13:21
 * 性别枚举
 */
public enum  SexEnmu {
    men(1,"男"),women(2,"女");
    /**
     * 识别号
     */
    private int index;
    /**
     * 性别
     */
    private  String sexs;

    SexEnmu(int index, String sexs) {
        this.index = index;
        this.sexs = sexs;
    }

    public  static  SexEnmu getSexEnmu(int code){
        SexEnmu [] enmus=SexEnmu.values();
        for( SexEnmu item:enmus){
            if(item.index==code){
                return  item;
            }
        }
        return  null;
    }
}
