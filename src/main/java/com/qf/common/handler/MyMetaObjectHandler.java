package com.qf.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : sin
 * @date : 2023/11/26 18:25
 * @Description : 自定义填充控制器
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入时自动填充数据
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //根据属性名称设置要填充的值
        this.strictInsertFill(metaObject,"createBy",String.class,"admin");
        this.strictInsertFill(metaObject,"updateBy",String.class,"admin");
        this.strictInsertFill(metaObject,"createTime", Date.class,new Date());
        this.strictInsertFill(metaObject,"updateTime", Date.class,new Date());
    }

    /**
     * update操作时自动填充的数据
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject,"updateBy",String.class,"admin");
        this.strictUpdateFill(metaObject,"updateTime", Date.class,new Date());
    }
}