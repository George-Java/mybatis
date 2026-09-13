package com.george.mapper;

import com.george.po.Car;
import com.george.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class CarMapperTest {
    @Test
    public void testSelectById() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);

        /*Car car = carMapper.selectByPrimaryKey(3);
        System.out.println(car);*/

        List<Car> cars = carMapper.selectAll();
        cars.forEach(System.out::println);

        sqlSession.close();
    }
}
