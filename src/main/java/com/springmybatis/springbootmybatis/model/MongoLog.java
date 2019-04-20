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
    private String url;
    private String ip;
    private String CLassMethod;
    private String args;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCLassMethod() {
        return CLassMethod;
    }

    public void setCLassMethod(String CLassMethod) {
        this.CLassMethod = CLassMethod;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

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
