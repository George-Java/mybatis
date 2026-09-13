package com.lindu.mapper;

import com.lindu.po.Clazz;
import org.apache.ibatis.annotations.Param;

/*
 *类名: ClazzMapper
 *作者: George
 *日期: 2026-04-06
 */
public interface ClazzMapper {
    Clazz selectByCid(@Param("cid") int cid);

    Clazz selectStepByStep(@Param("cid") int cid);
}