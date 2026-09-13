package com.lindu.mapper;

import com.lindu.po.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 *类名: StudentMapper
 *作者: George
 *日期: 2026-04-06
 */
public interface StudentMapper {
    List<Student> selectByCid(@Param("cid") int cid);
}
