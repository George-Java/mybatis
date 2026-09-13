package com.george.mapper;

import com.george.po.Student;
import com.george.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class StudentMapperTest {
    @Test
    public void testSelectBySid() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = mapper.selectBySid(1);
        System.out.println(student);
    }

    @Test
    public void testSelectByCid() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.selectByCid(2);
        students.forEach(System.out::println);
    }

    @Test
    public void testSelectStepByStep() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = mapper.selectStepByStep(3);
        System.out.println(student.getSname());
    }
}
