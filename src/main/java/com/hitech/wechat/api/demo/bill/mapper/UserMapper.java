package com.hitech.wechat.api.demo.bill.mapper;

import com.hitech.wechat.api.demo.bill.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface UserMapper {
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (name, password, ",
        "phone, enabled, description)",
        "values (#{name,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{enabled,jdbcType=BIT}, #{description,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(User record);

    @Select({
        "select",
        "id, name, password, phone, enabled, description",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, name, password, phone, enabled, description",
        "from user"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectAll();

    @Update({
        "update user",
        "set name = #{name,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "enabled = #{enabled,jdbcType=BIT},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}