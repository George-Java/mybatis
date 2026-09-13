package com.george.mapper;

import com.george.po.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CarMapper {
    @Delete("delete from tb_car where id=#{id}")
    int deleteByPrimaryKey(Integer id);

    @Insert("insert into tb_car values(#{id},#{brand},#{price},#{produceTime},#{carType})")
    int insert(Car row);

    @Select("select *from tb_car where id=#{id}")
    //相当于 <resultMap id="carResultMap" type="com.george.entity.Car">
    //        <id property="id" column="id" jdbcType="INTEGER" javaType="int"/>
    //        <result property="brand" column="brand"/>
    //        <result property="price" column="price"/>
    //        <result property="produceTime" column="produce_time"/>
    //        <result property="carType" column="car_type"/>
    //    </resultMap>
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "brand", column = "brand"),
            @Result(property = "price", column = "price"),
            @Result(property = "produceTime", column = "produce_time"),
            @Result(property = "carType", column = "car_type")
    })
    Car selectByPrimaryKey(Integer id);

    @Select("select *from tb_car")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "brand", column = "brand"),
            @Result(property = "price", column = "price"),
            @Result(property = "produceTime", column = "produce_time"),
            @Result(property = "carType", column = "car_type")
    })
    List<Car> selectAll();

    @Update("update tb_car set brand=#{brand},price=#{price},produce_time=#{produceTime},car_type=#{carType} where id=#{id}")
    int updateByPrimaryKey(Car row);
}