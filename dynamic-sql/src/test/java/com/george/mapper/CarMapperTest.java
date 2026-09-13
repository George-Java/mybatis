package com.george.mapper;

import com.george.po.Car;
import com.george.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CarMapperTest {
    @Test
    public void testSelectById() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);

        int[] ids = {1, 2, 4, 6};
        List<Car> cars = carMapper.selectById(ids);
        cars.forEach(System.out::println);
    }

    @Test
    public void testSelectByWhere() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);

        List<Car> cars = carMapper.selectByWhere(40.0, "轿车");
        cars.forEach(System.out::println);
    }

    @Test
    public void testUpdateCar() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse("2025-12-10", formatter);
        System.out.println(date);
        int count = carMapper.updateCar(2, "奥迪cm", 25.4, date, "新能源");
        System.out.println("更新了" + count + "条数据");

        List<Car> cars = carMapper.selectById(new int[]{2});
        cars.forEach(System.out::println);

        sqlSession.commit();
    }

    @Test
    public void testSelectByChoose() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);

        List<Car> cars = carMapper.selectByChoose(null, 36.4, null);
        cars.forEach(System.out::println);

        sqlSession.commit();
    }
}
