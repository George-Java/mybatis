package com.george.mapper;

import com.george.po.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    Student selectBySid(@Param("sid") int sid);

    List<Student> selectByCid(@Param("cid") int cid);

    Student selectStepByStep(@Param("sid") int sid);
}
