package com.springmybatis.springbootmybatis.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * 使用 MongoTemplate 对方法进行封装
 * @author amc2533064395@163.com
 * @date 2019/4/17 17:33
 */

@Repository
public class MongoDBUtil {
    private  static  final Logger logger= LoggerFactory.getLogger(MongoDBUtil.class);


    @Autowired
    private MongoTemplate mongoTemplate;

}
