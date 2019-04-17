package com.springmybatis.springbootmybatis.mapper;


import com.springmybatis.springbootmybatis.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


/**
 * 基于注解的mapper
 * @author amc2533064395@163.com
 * @date 2019/4/15 13:28
 */
@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    @Results({
            @Result(column = "id", property = "Id"),
            @Result(column = "name", property = "name"),
            @Result(column = "age", property = "age"),
            @Result(column = "sex", property = "sex")
    })

    User findUserById( int id);

    @Insert("insert into user(name,age,sex) values(#{name},#{age},#{sex})")
    boolean saveUser(User user) ;

    @Delete("delete from user where id =#{id}")
    boolean deleteUserById(@Param("id") int id);

    @Update("update user set name=#{name},age=#{age},sex=#{sex} where id=#{id}")
    boolean updateUserById(@Param("name") String name, @Param("age") int age, @Param("sex") int sex, @Param("id") int id);

}

