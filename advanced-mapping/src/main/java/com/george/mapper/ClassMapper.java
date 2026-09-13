package com.george.mapper;

import com.george.po.Classroom;
import org.apache.ibatis.annotations.Param;

public interface ClassMapper {
    Classroom selectByCid(@Param("cid") int cid);
}
