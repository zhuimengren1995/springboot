package com.springmybatis.springbootmybatis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author amc2533064395@163.com
 * @date 2019/4/17 18:54
 */
@Document
public class MongoLog {
    @Id
    private String Id;
    private String method;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
