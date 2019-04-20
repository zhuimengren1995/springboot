package com.springmybatis.springbootmybatis.util;

import com.springmybatis.springbootmybatis.model.MongoLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    /**
     * 保存对象
     *
     * @param mongoLog
     * @return
     */
    public String saveObj(MongoLog mongoLog) {
        logger.info("--------------------->[MongoDB save start]");
        mongoLog.setMethod(" mongodb成功");
        mongoTemplate.save(mongoLog);
        return "添加成功";
    }


    /**
     * 查询所有
     *
     * @return
     */
    public List<MongoLog> findAll() {
        logger.info("--------------------->[MongoDB find start]");
        return mongoTemplate.findAll(MongoLog.class);
    }


}
