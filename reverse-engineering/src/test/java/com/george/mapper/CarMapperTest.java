package com.george.mapper;

import com.george.po.Car;
import com.george.po.CarExample;
import com.george.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/*
 *类名: CarMapperTest
 *作者: George
 *日期: 2026-04-06
 */
public class CarMapperTest {
    @Test
    public void testCarMapper() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        //查询一条数据
        /*Car car = mapper.selectByPrimaryKey(1);
        System.out.println(car);*/


        //查询所有
        /*List<Car> cars = mapper.selectByExample(null);
        cars.forEach(System.out::println);*/


        //条件查询(select *from tb_car where brand='宝马' or price>30.0)
        //CarExample对象，封装查询条件
        CarExample carExample = new CarExample();

        //调用createCriteria()方法，创建查询条件
        //相当于select *from tb_car where brand='宝马';
        carExample.createCriteria().andBrandEqualTo("宝马");
        //相当于select *from tb_car where brand='宝马' or price>30.0;
        carExample.or().andPriceGreaterThan(30.0);

        List<Car> cars = mapper.selectByExample(carExample);
        cars.forEach(System.out::println);
    }
}
