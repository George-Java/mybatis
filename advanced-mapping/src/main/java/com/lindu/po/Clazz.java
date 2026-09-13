/*
 *类名: Clazz
 *作者: George
 *日期: 2026-04-06
 */
package com.lindu.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//研究一对多关系，其含义依旧为教室类（等价Classroom类）
public class Clazz {
    private int cid;
    private String cname;
    private List<Student> students;
}
