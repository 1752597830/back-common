# 后端初始化模板
tree D:\code\springboot-init\src\main\java\com /F
~~~
|springboot-init
└─qf
    │  MainApplication.java
    │
    ├─common
    │  ├─config
    │  │      Knife4jConfig.java
    │  │      RedisConfig.java
    │  │      WebMvcConfig.java
    │  │
    │  ├─constant
    │  │      Constant.java
    │  │      HttpStatus.java
    │  │
    │  ├─core
    │  │  ├─controller
    │  │  │      BaseController.java
    │  │  │      TestController.java
    │  │  │
    │  │  ├─domain
    │  │  │      BaseEntity.java
    │  │  │      BaseResponse.java
    │  │  │      ResultCode.java
    │  │  │
    │  │  ├─exception
    │  │  │      BaseException.java
    │  │  │      GlobalExceptionHandler.java
    │  │  │
    │  │  └─page
    │  │          PageDomain.java
    │  │          PageResult.java
    │  │
    │  ├─filter
    │  │      JwtAuthenticationTokenFilter.java
    │  │
    │  ├─handler
    │  │      MyMetaObjectHandler.java
    │  │
    │  └─utils
    │          JwtUtil.java
    │          RedisCache.java
    │          RedisFastJson.java
    │          ServletUtils.java
    │
    ├─controller
    └─system
        ├─mapper
        └─service
└─qf
    ├─common  公共模块
    │  ├─constant  常量
    │  │      Constant.java
    │  │      HttpStatus.java  状态码常量
    │  ├─config
    │  │      Knife4jConfig.java
    │  │      RedisConfig.java
    │  │      WebMvcConfig.java
    │  │
    │  ├─core  核心模块
    │  │  ├─controller
    │  │  │      BaseController.java  抽取公共控制器(分页，增删改操作进行统一操作 )
    │  │  │
    │  │  ├─domain
    │  │  │      BaseEntity.java  基类   即抽取公共属性 比如createBy createTime...
    │  │  │      BaseResponse.java  响应结果封装对象
    │  │  │      ResultCode.java  接口统一响应对象返回
    │  │  │
    │  │  ├─exception
    │  │  │      BaseException.java  自定义异常类
    │  │  │      GlobalExceptionHandler.java  全局异常
    │  │  │
    │  │  └─page
    │  │          PageDomain.java  分页参数封装
    │  │          PageResult.java  分页查询统一响应封装
    │  │
    │  ├─handler
    │  │      MyMetaObjectHandler.java  自定义填充控制器 比如createBy createTime 为空可直接封装
    │  │
    │  └─utils
    │          ServletUtils.java  客户端工具类
~~~

