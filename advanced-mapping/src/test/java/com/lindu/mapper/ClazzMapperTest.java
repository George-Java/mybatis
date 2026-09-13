package com.lindu.mapper;

import com.george.util.SqlSessionUtil;
import com.lindu.po.Clazz;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/*
 *类名: ClazzMapperTest
 *作者: George
 *日期: 2026-04-06
 */
public class ClazzMapperTest {
    @Test
    public void testSelectByCid() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);

        Clazz clazz = mapper.selectByCid(2);
        System.out.println(clazz);
    }

    @Test
    public void testSelectStepByStep() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);

        Clazz clazz = mapper.selectStepByStep(2);
        System.out.println(clazz);
    }
}
