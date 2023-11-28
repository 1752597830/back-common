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
~~~

