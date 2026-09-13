package com.george.mybatisplus.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author author
 * @since 2026-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_address")
@Schema(description = "Address对象")
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @SchemaProperty(name = "用户ID")
    private Long userId;

    @SchemaProperty(name = "省")
    private String province;

    @SchemaProperty(name = "市")
    private String city;

    @SchemaProperty(name = "县/区")
    private String town;

    @SchemaProperty(name = "手机")
    private String mobile;

    @SchemaProperty(name = "详细地址")
    private String street;

    @SchemaProperty(name = "联系人")
    private String contact;

    @SchemaProperty(name = "是否是默认 1默认 0否")
    private Boolean isDefault;

    @SchemaProperty(name = "备注")
    private String notes;

    @SchemaProperty(name = "逻辑删除")
    private Boolean deleted;


}
