package com.george.mapper;

import com.george.po.Car;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface CarMapper {
    List<Car> selectById(@Param("ids") int[] ids);

    List<Car> selectByBrand(@Param("brands") String[] brands);

    List<Car> selectByWhere(@Param("price") double price, @Param("carType") String carType);

    int insertCar(@Param("cars") List<Car> cars);

    int updateCar(@Param("id") int id, @Param("brand") String brand, @Param("price") double price,
                  @Param("produceTime") LocalDate produceTime, @Param("carType") String carType);

    int deleteById(@Param("ids") int[] ids);

    List<Car> selectByChoose(@Param("brand") String brand, @Param("price") double price, @Param("carType") String carType);
}
