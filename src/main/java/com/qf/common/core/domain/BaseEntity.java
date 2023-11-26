package com.qf.common.core.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author : sin
 * @date : 2023/11/26 12:46
 * @Description : 基类   即抽取公共属性
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 搜索值
     * @TableField(exist = false)注解加载bean属性上，表示当前属性不是数据库的字段，
     * 但在项目中必须使用，这样在新增等使用bean的时候，mybatis-plus就会忽略这个，不会报错
     */
    @TableField(exist = false)
    private String searchValue;

    /**
     * 创建者
     * fill 在需要被填充的字段上使用注解，声明什么时候要被填充
     * FieldFill.INSERT 只在插入时填充
     * FieldFill.INSERT_UPDATE 插入和更新时都填充
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /** 更新者 */
    @TableField(fill = FieldFill.INSERT)
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date updateTime;

    /** 备注 */
    private String remark;

    /** 请求参数 */
    @TableField(exist = false)
    private Map<String, Object> params;
}