# 后端初始化模板

~~~
|springboot-init
└─qf
    ├─common  公共模块
    │  ├─constant  常量
    │  │      HttpStatus.java  状态码常量
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

